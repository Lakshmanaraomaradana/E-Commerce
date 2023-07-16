package com.mlr.mart.service;





import java.util.List;

import com.mlr.mart.entity.Customer;


public interface CustomerService {
	
	public String addCustomer(Customer customer);
	public List<Customer>getAllCustomers();

}
