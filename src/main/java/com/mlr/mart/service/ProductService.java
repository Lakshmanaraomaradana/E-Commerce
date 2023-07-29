package com.mlr.mart.service;

import java.util.List;

import com.mlr.mart.entity.Product;

public interface ProductService {
	
	public String addProduct(Product product);
	public Product findProductById(int id);
	public List<Product>findAllProductsByCategory(String category);
    public Product addToCart(Product product);
    public List<Product>getAllCartProducts();
    public Product updateProductById(Product product,int id);
    public List<Product>getAllProducts();
    public String deleteProductById(int id);
    public List<Product>getProductsByName(String name);
}
