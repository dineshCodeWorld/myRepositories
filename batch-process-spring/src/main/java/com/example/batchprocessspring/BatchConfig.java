package com.example.batchprocessspring;

import java.util.Date;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class BatchConfig
{
	@Bean
   public FlatFileItemReader<Product> reader()
   {
		FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("products.csv"));
	//	reader.setResource(new FileSystemResource("C:/user/dinesh/product.csv"));
	//	reader.setResource(new UrlResource("http://localhost/files/product.csv"));
		
		reader.setLineMapper(new DefaultLineMapper<>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setDelimiter(DELIMITER_COMMA);
				setNames("id","name","cost");
			}});	
		setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
			setTargetType(Product.class);
		}});
		}});
	  return reader;
   }
   @Bean
   public ItemProcessor<Product, Product> processor()
   {
	   return new ProductProcessor();
	   
//	   return (Product product) -> {             //* we did it in seperated class so as of now commenting but writing here only a good practic
//			Double cost = product.getCost();
//			product.setCost(cost * 12/100.0);
//			product.setGst(cost * 22/100.0);
//			return product;
//	   };
   }
   
   @Autowired
   private DataSource dataSource;
   
   @Bean
   public JdbcBatchItemWriter<Product> writer()
   {
	   JdbcBatchItemWriter<Product> writer = new JdbcBatchItemWriter<>();
	   writer.setDataSource(dataSource);
	   writer.setSql("insert into products(id,name,cost,discount,gst) values(:id,:name:cost,:discount,:gst)");
	   writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
	   return writer;
   }
   @Bean
   public JobExecutionListener listener()
   {
	   return new JobListener();
	   
//	   return new JobExecutionListener() {  //here also we can directly defined here but as of now we defined same in seperate class
//		@Override
//		public void beforeJob(JobExecution je) {
//	      System.out.println("Started at: " + new Date());
//	      System.out.println("Batch Status: " + je.getStatus());
//		}
//
//		@Override
//		public void afterJob(JobExecution je) {
//		      System.out.println("End at: " + new Date());
//		      System.out.println("Batch Status: " + je.getStatus());
//		}
//	   };
   }
  @Autowired
   private StepBuilderFactory sf;
   
   
   @Bean
   public Step step1()
   {
	   return sf.get("step1")
			    .<Product, Product>chunk(3)
			    .reader(reader())
			    .processor(processor())
			    .writer(writer())
			    .build();
   }
   
   @Autowired
   private JobBuilderFactory jf;
   
   @Bean
   public Job job1()
   {
	   return jf.get("job1")
			    .incrementer(new RunIdIncrementer())
			    .listener(listener())
			    .start(step1())
		     // .next(step2())
		     // .next(step3())
			    .build();
   }
}


















