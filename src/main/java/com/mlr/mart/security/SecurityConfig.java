package com.mlr.mart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig{
	
	//@Autowired
	//private UserAuthService userauthservice;
	
	protected SecurityFilterChain configure(HttpSecurity http)throws Exception{
		http.authorizeHttpRequests((autherize)->autherize.anyRequest().authenticated()).httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	UserDetailsService userservice() {
		
	}
}
