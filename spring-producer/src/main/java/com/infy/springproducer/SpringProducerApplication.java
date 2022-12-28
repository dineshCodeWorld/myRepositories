package com.infy.springproducer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.support.Args;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@SpringBootApplication
@Configuration
@EnableKafka
public class SpringProducerApplication {
	
	@Bean
	public NewTopic topic1()
	{
		return TopicBuilder.name("topic1").partitions(1).replicas(1).build();
	}
	
	@Bean
	public ApplicationRunner sendMessage(KafkaTemplate<String, String> template)
	{
		return Args ->{
			             for(int i = 0;i<500;i++)
			             {
			            	 template.send("topic1","hello");
			             }
			             System.out.println("send message success");
		              };		
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringProducerApplication.class, args);
	}

}
