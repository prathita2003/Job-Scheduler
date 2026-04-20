package com.jobscheduler.scheduler;

import com.jobscheduler.entity.Job;
import com.jobscheduler.entity.JobExecutionLog;
import com.jobscheduler.repository.JobRepository;
import com.jobscheduler.repository.JobExecutionLogRepository;
import com.jobscheduler.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class JobScheduler 
{
    @Autowired
    private JobRepository jr;
    
    @Autowired
    private JobService js;
    
    @Scheduled(fixedRate=10000)
    public void processJobs()
    {
        List<Job> jobs=jr.findByStatus("PENDING");
        
        for(Job job:jobs)
        {
            if(job.getScheduleTime().isBefore(LocalDateTime.now()))
            {
                js.processJob(job); //This leads to asynchronous (async) execution
                }
            }
        }
    }

