package com.example.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class SpringSecurity1Application {
	String view = "index";
	
	@GetMapping("/")
	public String showIndexPage()
	{
		return view;
	}
	
	@GetMapping("/home")
	public String home()
	{
		return "Welocm eTo spring Security";
	}
	
	@GetMapping(value = "login")
	public String showindex()
	{
		return "login";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity1Application.class, args);
	}

	@GetMapping(value = "accessDenied")
	public String showAccessDenied() {

		return "accessDenied";
	}

	@GetMapping(value = "logout")
	public String showLogOut() {

		return "login";
	}
	@GetMapping(value = "index")
	public String showHomePage() {

		return view;
	}

}
