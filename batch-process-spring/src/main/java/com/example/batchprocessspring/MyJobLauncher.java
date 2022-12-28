package com.example.batchprocessspring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class MyJobLauncher implements CommandLineRunner
{
	@Autowired
  private org.springframework.batch.core.launch.JobLauncher jobLauncher;
	
	
	@Autowired
	private Job job1;

	@Override
	public void run(String... args) throws Exception 
	{
		JobParameters jobParameters = new JobParametersBuilder()
				                          .addLong("time", System.currentTimeMillis())
				                          .toJobParameters();
		jobLauncher.run(job1,jobParameters);
		System.out.println("Job Execution Done");
	}
}
