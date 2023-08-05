package com.mlr.mart.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.SecurityUser;
import com.mlr.mart.service.SecurityUserService;


public class UserAuthService implements UserDetailsService{
	
	@Autowired
	private SecurityUserService securityuserservice;
    
	private final PasswordEncoder passwordEncoder =new BCryptPasswordEncoder(); 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SecurityUser users=securityuserservice.getUserByUserName(username);
		if(users==null) {
			throw new UsernameNotFoundException("User details not found with this UserName :"+username);
		}
		String name=users.getUserName();
		String password=passwordEncoder.encode(users.getPassword());
		List<String>roles=users.getRoles();
		List<GrantedAuthority>autherities=roles.stream().map(CustomRole::new).collect(Collectors.toList());
		User user=new User(name,password,autherities);
		return (UserDetails)user;
	}

}
