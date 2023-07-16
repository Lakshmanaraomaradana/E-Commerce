package com.mlr.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.Customer;
import com.mlr.mart.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	
	@RequestMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		
		return customerservice.getAllCustomers();
	}
	
	
	
	@PostMapping("/addCustomer")
	public String addCustomer(@RequestBody Customer customer) {
		customerservice.addCustomer(customer);
		
		
		return "added";
	}
	
	
	@DeleteMapping("/deleteCustomer/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		
		return null;
		
	}

}
