package com.example.springDoc;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import netscape.javascript.JSObject;

@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.example.springDoc.*")
//@RestController
@Controller
@ResponseBody
public class SpringDocApplication {
	
	private final AtomicLong id = new AtomicLong();

//	@GetMapping("/home")
	@RequestMapping(method = RequestMethod.GET,path = "/home")
	public Student show(@RequestParam(value = "name",defaultValue = "World") String name)
	{
		return new Student(id.incrementAndGet() , String.format("<h1> Hello %s!<h1>",name) );
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringDocApplication.class, args);
	}

}
