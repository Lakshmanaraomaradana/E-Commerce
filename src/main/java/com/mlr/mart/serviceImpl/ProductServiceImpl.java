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

	@Override
	public Product addToCart(Product product) {
		// TODO Auto-generated method stub
		boolean value=product.isThisInCart();
		if(value==false) {
			product.setThisInCart(true);
		}
		else {
			product.setThisInCart(false);
		}
		productrepository.save(product);
		return product;
	}

	@Override
	public List<Product> getAllCartProducts() {
		// TODO Auto-generated method stub
		List<Product>allCartProducts=productrepository.getAllCartProducts();
		return allCartProducts;
	}

	@Override
	public Product updateProductById(Product product) {
		// TODO Auto-generated method stub
		Product updatedProduct=new Product();
		updatedProduct.setAvailabilityQty(product.getAvailabilityQty());
		updatedProduct.setCategory(product.getCategory());
		updatedProduct.setDetails(product.getDetails());
		updatedProduct.setImageUrl(product.getImageUrl());
		updatedProduct.setMaterial(product.getMaterial());
		updatedProduct.setProductName(product.getProductName());
		productrepository.save(updatedProduct);
		return updatedProduct;
	}
}
