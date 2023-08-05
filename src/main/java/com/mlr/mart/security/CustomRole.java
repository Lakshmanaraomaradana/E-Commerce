package com.mlr.mart.security;

import org.springframework.security.core.GrantedAuthority;

public class CustomRole implements GrantedAuthority{
	
	
	private String role;
	
	public CustomRole(String role) {
		this.role=role;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return role;
	}

}
