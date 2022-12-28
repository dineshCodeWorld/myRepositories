package com.example.springrememberme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SpringRememberMeApplication {
//	@Secured("ADMIN")
//	@PreAuthorize
//	@PostAuthorize
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}

	@GetMapping("logout")
	public String showLogOut() {

		return "login";
	}

	@GetMapping("login")
	public String showIndex() {

		return "login";
	}

	@GetMapping("accessDenied")
	public String showAccessDenied() {

		return "accessDenied";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRememberMeApplication.class, args);
	}

}
