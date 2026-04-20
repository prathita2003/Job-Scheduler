package com.jobscheduler.repository;

import com.jobscheduler.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface JobRepository extends JpaRepository<Job,Long> 
{
    List<Job> findByStatus(String status);
}
