package com.mlr.mart.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mlr.mart.entity.SecurityUser;
import com.mlr.mart.service.SecurityUserService;

public class UserAuthService implements UserDetailsService{
	
	@Autowired
	private SecurityUserService securityuserservice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SecurityUser users=securityuserservice.getUserByUserName(username);
		if(users==null) {
			throw new UsernameNotFoundException("User details not found with this UserName :"+username);
		}
		
		return null;
	}

}
