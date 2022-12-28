package com.example.demo;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class WebSecurityClass extends AbstractSecurityWebApplicationInitializer{
public WebSecurityClass() {
		super(Config.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		
	}
}
