package com.mlr.mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.Customer;
import com.mlr.mart.entity.SecurityUser;
import com.mlr.mart.entity.User;
import com.mlr.mart.service.CustomerService;
import com.mlr.mart.service.SecurityUserService;
import com.mlr.mart.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private SecurityUserService securityuserservice;
	
	//private PasswordEncoder encoder;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		
		Customer customer=new Customer();
		customer.setFirstName(user.getFirstName());
		customer.setLastName(user.getLastName());
		customer.setEmail(user.getEmail());
		customer.setContactNo(user.getContactNo());
		
		SecurityUser securityuser=new SecurityUser();
		securityuser.setUserName(user.getUserName());
		securityuser.setPassword(user.getPassword());
		securityuser.setRoles(null);
		
		customerservice.addCustomer(customer);
		userservice.addUser(user);
		securityuserservice.addSecurityUser(securityuser);
		return new ResponseEntity<>("User added",HttpStatus.OK);
	}
	
	

}
