package com.mlr.mart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mlr.mart.entity.Product;

public class ProductController {
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		
		return null;
	}
	
	public String getAllProductCategories() {
		return null;
	}
	
	public String addProductCategory() {
		return null;
	}
	
	public String getAllProductsByCategory() {
		return null;
	}
	
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id) {
		return null;
	}
	@PutMapping("/updateProductbyid/{id}")
	public String updateProductbyid(@PathVariable int id) {
		return null;
	}
	@PutMapping("/updateProductCategory")
	public String updateProductCategory() {
		return null;
	}
	
	

}
