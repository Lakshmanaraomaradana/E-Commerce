package com.mlr.mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mlr.mart.entity.Product;
import com.mlr.mart.service.ProductService;

public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		
		
		productservice.addProduct(product);
		return "added";
	}
	
	
	
	

}
