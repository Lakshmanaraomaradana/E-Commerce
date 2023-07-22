package com.mlr.mart.serviceImpl;

import java.util.List;

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

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		Product product=productrepository.findById(id).orElseThrow(null);
		return product;
	}
	@Override
    public List<Product>findAllProductsByCategory(String category){
    	List<Product>products=productrepository.getAllProductsBycategory(category);
    	
    	return products;
    }
}
