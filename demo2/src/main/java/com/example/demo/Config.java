package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
           .withUser("Dinesh")
           .password("12345")
           .roles("USER")
           .and().withUser("Lokesh")
           .password("6789")
           .roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
          .antMatchers("/**")
          .hasAnyRole("ADMIN","USER")
          .anyRequest()
          .authenticated()
          .and().formLogin();
	}

}
