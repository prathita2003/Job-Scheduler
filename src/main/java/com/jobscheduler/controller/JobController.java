package com.jobscheduler.controller;

import com.jobscheduler.entity.Job;
import com.jobscheduler.entity.JobExecutionLog;
import com.jobscheduler.repository.JobRepository;
import com.jobscheduler.repository.JobExecutionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jobs")
public class JobController 
{
    
    @Autowired
    private JobRepository jr;
    
    @PostMapping
    public Job createJob(@RequestBody Job j)
    {
        j.setStatus("PENDING");
        j.setCurrentRetries(0);
        return jr.save(j);
    }
    
    @GetMapping
    public List<Job> getAllJobs()
    {
        return jr.findAll();
    }
    
    @Autowired
    private JobExecutionLogRepository lr;
    
    @GetMapping("/logs")
    public List<JobExecutionLog> getLogs()
    {
        return lr.findAll();
    }
    
    @GetMapping("/logs/{jobId}")
    public List<JobExecutionLog> getLogsbyJob(@PathVariable Long jobId)
    {
        return lr.findAll().stream().filter(log -> log.getJobId().equals(jobId)).toList();
    }
    
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id){
        if(!jr.existsById(id))
        {
            return "Job not found";
        }
        jr.deleteById(id);
        return "Job deleted successfully";
    }
    
}
