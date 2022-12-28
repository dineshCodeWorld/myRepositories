package com.infy.teslapro.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	DataSource dataSource;

	@Bean
	  public PasswordEncoder passwordEncoder()
	  {
		  return new BCryptPasswordEncoder(11);
	  }
	@Autowired
	public void configuer(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication()
		    .dataSource(dataSource)
		    .usersByUsernameQuery("select first_name,password,status from user where first_name=?")
		    .authoritiesByUsernameQuery("select first_name,role from user where first_name=?");

	}
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception
	{
		http.sessionManagement().maximumSessions(1);
		http.cors().and().csrf().disable();
//		http.authorizeHttpRequests().requestMatchers("/**").permitAll();
		http.authorizeHttpRequests()
		    .requestMatchers("/getUserList")
		    .hasAnyAuthority("ADMIN")
		    .anyRequest()
		    .authenticated()
		    .and()
		    .httpBasic();
		return http.build();
	}
}
