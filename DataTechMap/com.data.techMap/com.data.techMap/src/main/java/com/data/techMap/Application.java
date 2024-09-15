package com.data.techMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job importCollegeJob;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			JobParameters jobParameters = new JobParametersBuilder()
					.addLong("timestamp", System.currentTimeMillis())
					.toJobParameters();

			jobLauncher.run(importCollegeJob, jobParameters);

			logger.info("Batch job has been started successfully.");
		} catch (JobExecutionAlreadyRunningException e) {
			logger.error("Batch job is already running", e);
		} catch (JobInstanceAlreadyCompleteException e) {
			logger.error("Batch job instance already completed", e);
		} catch (JobRestartException e) {
			logger.error("Batch job restart failed", e);
		} catch (JobExecutionException e) {
			logger.error("Batch job execution failed", e);
		}
	}
}
