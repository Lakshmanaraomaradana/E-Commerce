package com.mlr.mart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.Cart;
import com.mlr.mart.service.CartService;
import com.mlr.mart.service.ProductService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartservice;
	
	@Autowired
	private ProductService productservice;
	
	@PostMapping("/addProductToCart")
	public String addProductToCart(@RequestBody Cart cartproduct, int id) {
		
		productservice.findProductById(id);
		cartservice.addProductsToCart(cartproduct);
		
		return "added product to cart";
	}
    
}
