package com.mlr.mart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.Cart;
import com.mlr.mart.repository.CartRepository;
import com.mlr.mart.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartrepository;

	@Override
	public String addProductsToCart(Cart cartproduct) {
		// TODO Auto-generated method stub
		cartrepository.save(cartproduct);
		return "added";
	}

}
