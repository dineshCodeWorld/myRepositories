package com.example.batchprocessspring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class BatchConfig 
{
   @Bean
   public Job job(JobBuilderFactory jobBuilderFactory
		         ,StepBuilderFactory stepBuilderFactory
		         ,ItemReader<User> reader
		         ,ItemProcessor<User, User> processor
		         ,ItemWriter<User> writer)
   {
	   Step step = stepBuilderFactory.get("step1")
			                         .<User,User>chunk(100)
			                         .reader(reader)
			                         .processor(processor)
			                         .writer(writer)
			                         .build();
	   
	   return  jobBuilderFactory.get("job1")
	                    .incrementer(new RunIdIncrementer())
	                    .start(step)
	                    .build();
   }
   
   @Bean
   public FlatFileItemReader<User> reader(@Value("${input}") Resource resource)
   {
	   FlatFileItemReader<User> fileItemReader = new FlatFileItemReader<>();
	   fileItemReader.setResource(resource);
	   fileItemReader.setName("CSV-Reader");
	   fileItemReader.setLinesToSkip(0);
	   fileItemReader.setLineMapper(lineMapper());
	   return fileItemReader;
   }

   @Bean
   private LineMapper<User> lineMapper() {
      DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();
      DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
      lineTokenizer.setDelimiter(lineTokenizer.DELIMITER_COMMA);
      lineTokenizer.setStrict(false);
      lineTokenizer.setNames(new String[] {"id","name","cost"});
      BeanWrapperFieldSetMapper<User> wrMapper = new BeanWrapperFieldSetMapper<>();
      wrMapper.setTargetType(User.class);
      defaultLineMapper.setLineTokenizer(lineTokenizer);
      defaultLineMapper.setFieldSetMapper(wrMapper);
      return defaultLineMapper;
   }
}
