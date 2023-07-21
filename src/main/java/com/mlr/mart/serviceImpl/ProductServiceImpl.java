package com.mlr.mart.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.Product;
import com.mlr.mart.repository.ProductRepository;
import com.mlr.mart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productrepository;

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		productrepository.save(product);
		return null;
	}

}
