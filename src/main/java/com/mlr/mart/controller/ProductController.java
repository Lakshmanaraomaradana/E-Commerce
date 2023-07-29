package com.mlr.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.Product;
import com.mlr.mart.service.ProductService;

@RestController
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
	
	@GetMapping("/getAllCartProducts")
	public List<Product>getAllCartProducts(){
		List<Product>allProducts=productservice.getAllCartProducts();
		return allProducts;
	}
	
	@PutMapping("/addToCart/{id}")
	public Product updateProduct(@PathVariable int id) {
		Product product=productservice.findProductById(id);
		productservice.addToCart(product);
		return product;
	}
	
	@PutMapping("/updateProductById/{id}")
	public String updateProductById(@PathVariable int id) {
		
		Product product=productservice.findProductById(id);
		productservice.updateProductById(product);
		return "updated";
	}
	

}
