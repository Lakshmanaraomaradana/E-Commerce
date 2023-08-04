package com.mlr.mart.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(HttpSecurity http)throws Exception{
		http.authorizeRequests()
		    .antMatchers("/").permitAll()
		    .and();
		http.formLogin().loginPage("/login").loginProcessingUrl("/")
		    .permitAll().and()
		    .logout().logoutSuccessUrl("/")
		    .permitAll();
		http.httpBasic();  
	}

}
