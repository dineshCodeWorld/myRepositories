package com.infy.teslapro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TeslaProApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TeslaProApplication.class, args);
	}

}
