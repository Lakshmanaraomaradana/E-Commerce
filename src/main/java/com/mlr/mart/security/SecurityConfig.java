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
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableMethodSecurity(prePostEnabled=true)
@EnableWebSecurity
@EnableTransactionManagement
public class SecurityConfig{
	
	@Autowired
	private UserAuthService userauthservice;
	
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http)throws Exception{
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and()
		.formLogin().loginPage("/login")
				.defaultSuccessUrl("/dashboard").permitAll().and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/login").invalidateHttpSession(true).deleteCookies("JSESSIONID");
		http.headers(headers -> headers.frameOptions().sameOrigin()); 
		http.userDetailsService(userauthservice);
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
}
