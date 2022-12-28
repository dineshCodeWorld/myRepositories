package com.example.springmethodlevelsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SpringMethodLevelSecurityApplication {
	
//	@Secured("ADMIN")
	@PreAuthorize("hasAuthority('USER')")
	@GetMapping("/")
	public String home()
	{
		return "home";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMethodLevelSecurityApplication.class, args);
	}

}
