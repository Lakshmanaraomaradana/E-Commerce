package com.mlr.mart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.Customer;
import com.mlr.mart.exception.NoCustomersFound;
import com.mlr.mart.repository.CustomerRepository;
import com.mlr.mart.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerrepository;

	@Override
	public String addCustomer(Customer customer) {
		
		
		customerrepository.save(customer);
		return "customer added";
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer>customers=customerrepository.findAll();
		if(customers.size()>0) {
			return customers;
		}
		else {
			throw new NoCustomersFound("No customers found");
		}
	}
	
	

}
