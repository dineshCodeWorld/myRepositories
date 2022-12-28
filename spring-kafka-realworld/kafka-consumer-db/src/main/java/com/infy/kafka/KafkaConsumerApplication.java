package com.infy.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaConsumerApplication {
	
	public static void main(String[] args)
	{
		SpringApplication.run(KafkaConsumerApplication.class);
		System.out.println("Kafka Consumer Application Started...");
	}

}
