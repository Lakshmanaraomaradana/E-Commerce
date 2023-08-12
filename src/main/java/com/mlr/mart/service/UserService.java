package com.mlr.mart.service;

import com.mlr.mart.entity.Product;
import com.mlr.mart.entity.User;

public interface UserService {
	
	public  String addUser(User user);
	public String addProductToCart(User user,Product product);
	public User findUser(String username);
    
}
