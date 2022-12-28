package com.infy.springconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class SpringConsumerApplication {
	
	@KafkaListener(id = "top",topics = "topic1")
	public void consume(String message)
	{
		System.out.println("recieved message is: "+message);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringConsumerApplication.class, args);
	}

}
