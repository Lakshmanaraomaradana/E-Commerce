package com.mlr.mart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.User;
import com.mlr.mart.repository.UserRepository;
import com.mlr.mart.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepository;

	@Override
	public String addUser(User user) {
		// TODO Auto-generated method stub
		userrepository.save(user);
		return "added";
	}

}
