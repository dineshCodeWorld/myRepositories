package com.example.actuatorspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 
{
	@GetMapping("/greet")
   public String greet()
   {
	   return "Greeting";
   }
}
