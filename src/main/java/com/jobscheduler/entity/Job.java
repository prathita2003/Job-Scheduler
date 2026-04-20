package com.jobscheduler.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Job 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime scheduleTime;
    private String status;
    private int retryCount;
    private int currentRetries;
}
