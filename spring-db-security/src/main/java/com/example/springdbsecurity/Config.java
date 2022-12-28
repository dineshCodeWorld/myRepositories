package com.example.springdbsecurity;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableWebSecurity
@Configuration
public class Config 
{
    @Autowired
    private DataSource dataSource;
//    @Autowired
//    private PersistentTokenRepository tokenRepository;
    @Bean
    public PersistentTokenRepository persistentTokenRepository()
    {
    	JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
    	tokenRepositoryImpl.setDataSource(dataSource);
   	return tokenRepositoryImpl;
    }
    
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
    //	http.requiresChannel().anyRequest().requiresSecure();
    	http.sessionManagement().maximumSessions(1);
    	http.cors().and().csrf().disable()
    	    .authorizeHttpRequests()
    	    .requestMatchers("/")
    	    .hasAnyAuthority("ADMIN","USER")
    	    .anyRequest()
    	    .authenticated()
    	    .and().formLogin()
    	    .loginPage("/login")
    	    .usernameParameter("username")
    	    .passwordParameter("password")
    	    .loginProcessingUrl("/doLogin")
    	    .defaultSuccessUrl("/",true)
    	    .permitAll()
    	    .and().rememberMe()
    	    .rememberMeParameter("remember-me")
    	  //  .key("uniqueAndSecret")
    	   // .tokenValiditySeconds(86400);
    	    .tokenRepository(persistentTokenRepository())
    	   .tokenValiditySeconds(86400);
    	return http.build();
    }
}
