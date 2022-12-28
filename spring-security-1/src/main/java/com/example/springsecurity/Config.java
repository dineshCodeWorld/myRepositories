package com.example.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class Config extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/**")
				.hasAnyRole("EMPLOYEE", "USER").anyRequest().authenticated()
				.and().formLogin().loginPage("/login")
				.usernameParameter("username").passwordParameter("password")
				.loginProcessingUrl("/doLogin")
				.defaultSuccessUrl("/index", true).failureUrl("/accessDenied")
				.permitAll().and().exceptionHandling()
				.accessDeniedPage("/accessDenied");

	}
	
//  @Bean
//  public  SecurityFilterChain chain(HttpSecurity http) throws Exception
//  {
//	 http.cors().and().csrf().disable().authorizeHttpRequests()
//	     .antMatchers("/**")
//	     .hasAnyAuthority("USER").anyRequest().authenticated()
//	     .and().formLogin()
//	     .loginPage("/login")
//	     .usernameParameter("username")
//	     .passwordParameter("password")
//	     .loginProcessingUrl("doLogin")
//	     .defaultSuccessUrl("/index",true)
//	     .failureUrl("/accessDenied")
//	     .permitAll().and()
//	     .exceptionHandling()
//	     .accessDeniedPage("/accessDenied");
//	 return http.build();
//  }
}
