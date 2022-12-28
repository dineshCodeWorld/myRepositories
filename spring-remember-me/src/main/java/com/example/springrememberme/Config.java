package com.example.springrememberme;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
//@EnableMethodSecurity(securedEnabled = true)
@EnableMethodSecurity(prePostEnabled = true	)
public class Config
{
    @Autowired
    DataSource dataSource;

   @Bean
   public PersistentTokenRepository persistentTokenRepository() {
   	   JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
   	   tokenRepositoryImpl.setDataSource(dataSource);
   	   return tokenRepositoryImpl;
    }


   @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception 
    {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from user_roles where username=?");

    }
    
    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception
    {
//    	http.sessionManagement().maximumSessions(1);
//    
//    	http.authorizeHttpRequests()
//    	    .requestMatchers("/home")
//    	    .hasAnyAuthority("USER","ADMIN")
//    	    .anyRequest()
//    	    .authenticated()
//    	    .and()
//    	    .formLogin()
//    	    .loginPage("/login")
//    	    .usernameParameter("username")
//    	    .passwordParameter("password")
//    	//    .loginProcessingUrl("/doLogin")
//    	    .defaultSuccessUrl("/home")
//    	    .permitAll()
//    	    .and()
//    	    .rememberMe()
//    	    .rememberMeParameter("remember-me")
//    	    .tokenRepository(persistentTokenRepository())
//    	    .tokenValiditySeconds(8400);
//    	return http.build();
    	
		http.csrf().disable();
		http.sessionManagement().maximumSessions(1);

		http.authorizeRequests().requestMatchers("/home")
				.hasAnyRole("ADMIN", "USER").anyRequest().authenticated().and().formLogin()
				.loginPage("/login").usernameParameter("username").passwordParameter("password")
				.loginProcessingUrl("/doLogin").defaultSuccessUrl("/index", true).failureUrl("/accessDenied")
				.permitAll().and().exceptionHandling().accessDeniedPage("/accessDenied").and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/login").permitAll()

				.and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository())

				/*
				 * The below line is for token based remember me service. Replace the below line
				 * with ".tokenRepository(tokenRepo).tokenValiditySeconds(86400);" to test
				 * persistent based remember me service
				 */
				.key("uniqueAndSecret").tokenValiditySeconds(86400);
		return http.build();
    }
}
