package com.example.batchprocessspring;

import java.util.Date;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class JobListener implements JobExecutionListener
{

	@Override
	public void beforeJob(JobExecution je) {
      System.out.println("Started at: " + new Date());
      System.out.println("Batch Status: " + je.getStatus());
	}

	@Override
	public void afterJob(JobExecution je) {
	      System.out.println("End at: " + new Date());
	      System.out.println("Batch Status: " + je.getStatus());
	}

}
