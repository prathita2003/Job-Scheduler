# Job Scheduler & Task Execution System

A backend system built using Spring Boot that manages scheduled jobs, executes them asynchronously, handles failures with retry mechanisms, and maintains execution logs for monitoring and debugging.

---

## Overview

This project simulates a real-world job processing system where tasks are:

* Scheduled for execution
* Processed asynchronously
* Retried on failure
* Logged for observability

It demonstrates key backend engineering concepts such as asynchronous processing, fault tolerance, and system design.

---

## Features

* REST APIs for job management
* Time-based job scheduling
* Retry mechanism for failed jobs
* Asynchronous job execution using `@Async`
* Execution logging for monitoring and debugging
* Filter logs by job ID
* Delete jobs via API

---

## System Architecture

```
Client → REST API → Database
                 ↓
           Scheduler (@Scheduled)
                 ↓
        Async Service (@Async)
                 ↓
        Job Execution + Logging
```

---

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Maven

---

## API Endpoints

| Method | Endpoint           | Description                 |
| ------ | ------------------ | --------------------------- |
| POST   | /jobs              | Create a new job            |
| GET    | /jobs              | Get all jobs                |
| DELETE | /jobs/{id}         | Delete a job                |
| GET    | /jobs/logs         | Get all execution logs      |
| GET    | /jobs/logs/{jobId} | Get logs for a specific job |

---

## Testing

### Create Job

<img width="1072" height="726" alt="image" src="https://github.com/user-attachments/assets/91c605ff-52e7-4107-b6f0-5c228c3a2d1d" />

### Jobs Before Execution

<img width="1090" height="691" alt="image" src="https://github.com/user-attachments/assets/a55dc79a-66b4-4b16-8f9f-3222bb53df6e" />

### Asynchronous Execution

<img width="1259" height="172" alt="image" src="https://github.com/user-attachments/assets/e0fea7e2-564c-4904-989a-28f5d5ea9af8" />

### Jobs After Execution

<img width="1082" height="793" alt="image" src="https://github.com/user-attachments/assets/17106f30-8fb0-41d8-88d2-e6a895a68278" />

### Retry Mechanism

<img width="1085" height="772" alt="image" src="https://github.com/user-attachments/assets/33db5a2e-d705-4f80-a197-0ed37a9f75ce" />

### Execution Logs

<img width="1090" height="883" alt="image" src="https://github.com/user-attachments/assets/b7c15526-021a-4b32-bd63-06de22ac3225" />

### Logs by Job ID

<img width="1082" height="604" alt="image" src="https://github.com/user-attachments/assets/55972cb6-f0c4-4164-b86b-c15bc876245e" />

### Delete Job

<img width="940" height="452" alt="image" src="https://github.com/user-attachments/assets/38075072-e3bf-4912-a493-c524f6a838f1" />

---

## Key Concepts Demonstrated

* Asynchronous processing using Spring’s `@Async`
* Background scheduling using `@Scheduled`
* Fault tolerance through retry mechanisms
* State management (PENDING → RUNNING → SUCCESS/FAILED)
* Observability through execution logs

---

## Future Improvements

* Priority-based job scheduling
* Integration with message queues (Kafka/RabbitMQ)
* Distributed worker system
* Authentication and user-specific jobs
* Cloud deployment (AWS / Render / Railway)

---

## Resume Description

Developed a scalable job scheduling backend using Spring Boot with asynchronous execution, retry mechanisms, and persistent execution logging for fault tolerance and monitoring.
