package com.example.actuatorspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{
	@GetMapping("/home")
   public String welcome()
   {
	   return "Welcome To world";
   }
}
