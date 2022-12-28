package com.example.springmethodlevelsecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true)
@EnableMethodSecurity(prePostEnabled = true)
public class Config
{
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception
    {
    	auth.jdbcAuthentication()
    	    .dataSource(dataSource)
    	    .usersByUsernameQuery("select name,password,status from users where name=?")
    	    .authoritiesByUsernameQuery("select name, role from roles where name=?");

    }
    
    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception
    {
	http.sessionManagement().maximumSessions(1);
	http.cors().and().csrf().disable()
	    .authorizeHttpRequests()
	    .requestMatchers("/")
	    .hasAnyAuthority("ADMIN","USER")
	    .anyRequest()
	    .authenticated()
	    .and().httpBasic();
	return http.build();
    }
}
