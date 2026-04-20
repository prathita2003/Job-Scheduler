package com.jobscheduler.service;

import com.jobscheduler.entity.Job;
import com.jobscheduler.entity.JobExecutionLog;
import com.jobscheduler.repository.JobRepository;
import com.jobscheduler.repository.JobExecutionLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class JobService
{
    @Autowired
    private JobRepository jr;
    @Autowired
    private JobExecutionLogRepository lr;
    
    @Async
    public void processJob(Job j)
    {
        j.setStatus("RUNNING");
        jr.save(j);
        
        try
        {
            System.out.println("Executing job: "+j.getName());
            Thread.sleep(3000);
            
            if(Math.random()<0.5)
            {
                throw new RuntimeException("Random failure occured");
            }
            j.setStatus("SUCCESS");
            JobExecutionLog l = new JobExecutionLog();
            l.setJobId(j.getId());
            l.setExecutionTime(LocalDateTime.now());
            l.setStatus("SUCCESS");
            l.setMessage("Job executed successfully");

            lr.save(l);
        }
        catch(Exception e)
        {
            JobExecutionLog log = new JobExecutionLog();
            log.setJobId(j.getId());
            log.setExecutionTime(LocalDateTime.now());
            log.setStatus("FAILED");
            log.setMessage(e.getMessage());

            lr.save(log);

            int retries = j.getCurrentRetries();

            if (retries < j.getRetryCount()) {
                j.setCurrentRetries(retries + 1);
                j.setStatus("PENDING");
            } else {
                j.setStatus("FAILED");
            }
        }

        jr.save(j);
        }
    }
