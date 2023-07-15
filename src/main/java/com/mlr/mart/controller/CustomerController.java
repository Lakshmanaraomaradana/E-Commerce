package com.mlr.mart.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.mlr.mart.entity.Customer;

public class CustomerController {
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		
		return null;
	}
	
	
	
	@PostMapping("/addCustomer")
	public String addCustomer(Customer customer) {
		
		return null;
	}
	
	
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		
		return null;
		
	}

}
