package com.data.techMap.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchService {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importCollegeJob;

    public String startJob() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("startAt", System.currentTimeMillis())
                    .toJobParameters();

            jobLauncher.run(importCollegeJob, jobParameters);
            return "Batch job has been invoked successfully!";
        } catch (Exception e) {
            e.printStackTrace();  // Replace with proper logging
            return "Failed to invoke batch job!";
        }
    }
}
