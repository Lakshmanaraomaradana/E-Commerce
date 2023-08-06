package com.mlr.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.Customer;
import com.mlr.mart.exception.NoCustomersFound;
import com.mlr.mart.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getAllCustomers")
	public ResponseEntity<?> getAllCustomers(){
		try {
		List<Customer>customers=customerservice.getAllCustomers();
		if(customers!=null) {
			return new ResponseEntity<>(customers,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		}catch(NoCustomersFound e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		
		customerservice.addCustomer(customer);
		return "added";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		
		return null;
		
	}

}
