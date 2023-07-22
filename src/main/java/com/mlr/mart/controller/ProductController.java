package com.mlr.mart.controller;

import java.util.List;

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
	
	
	@GetMapping("/getAllProductsByCategory/{category}")
	public List<Product>getAllProductsByCategory(@PathVariable String category){
		List<Product>products=productservice.findAllProductsByCategory(category);
		
		return products;
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		
		
		productservice.addProduct(product);
		return "added";
	}
	
	@GetMapping("/findProduct/{id}")
	public Product findProductById(@PathVariable int id) {
		
		
		Product product=productservice.findProductById(id);
		return product;	
	}
	
	
	
	

}
