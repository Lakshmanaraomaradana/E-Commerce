package com.mlr.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mlr.mart.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	

}
