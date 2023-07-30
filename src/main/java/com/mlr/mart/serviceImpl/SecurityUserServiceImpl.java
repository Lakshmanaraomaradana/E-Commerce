package com.mlr.mart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.SecurityUser;
import com.mlr.mart.repository.SecurityUserRepository;
import com.mlr.mart.service.SecurityUserService;


@Service
public class SecurityUserServiceImpl implements SecurityUserService{
	
	@Autowired
	private SecurityUserRepository securityuserrepository;

	@Override
	public String addSecurityUser(SecurityUser securityuser) {
		// TODO Auto-generated method stub
		securityuserrepository.save(securityuser);
		return "added";
	}

	@Override
	public SecurityUser getUserByUserName(String name) {
		// TODO Auto-generated method stub
		
		return securityuserrepository.getUserByUserName(name);
	}

}
