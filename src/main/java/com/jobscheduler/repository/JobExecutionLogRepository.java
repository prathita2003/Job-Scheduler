package com.jobscheduler.repository;

import com.jobscheduler.entity.JobExecutionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExecutionLogRepository extends JpaRepository<JobExecutionLog,Long> {

}
