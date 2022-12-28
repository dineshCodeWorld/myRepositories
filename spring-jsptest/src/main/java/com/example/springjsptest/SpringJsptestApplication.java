package com.example.springjsptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@Controller
public class SpringJsptestApplication {
	
    @GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJsptestApplication.class, args);
	}

}
