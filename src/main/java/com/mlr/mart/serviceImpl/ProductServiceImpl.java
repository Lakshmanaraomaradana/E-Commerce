package com.mlr.mart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.Product;
import com.mlr.mart.exception.NoExistingProduct;
import com.mlr.mart.exception.NoProductsFound;
import com.mlr.mart.repository.ProductRepository;
import com.mlr.mart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productrepository;

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		productrepository.save(product);
		return "added";
	}

	@Override
	public Product findProductById(int id) {
		// TODO Auto-generated method stub
		Product product = productrepository.findById(id).orElse(null);
		// .orElseThrow(()->
		// new NoExistingProduct("No Product found with this id "+id));
		return product;
	}

	@Override
	public List<Product> findAllProductsByCategory(String category) {

		List<Product> products = productrepository.getAllProductsBycategory(category);
		if (products.size() > 0) {
			return products;
		} else {
			throw new NoProductsFound("No products found");
		}
	}

	@Override
	public Product addToCart(Product product) {
		// TODO Auto-generated method stub
		boolean value = product.isThisInCart();
		if (value == false) {
			product.setThisInCart(true);
		} else {
			product.setThisInCart(false);
		}
		productrepository.save(product);
		return product;
	}

	@Override
	public List<Product> getAllCartProducts() {
		// TODO Auto-generated method stub
		List<Product> allCartProducts = productrepository.getAllCartProducts();
		if (allCartProducts.size() > 0) {
			return allCartProducts;
		} else {
			throw new NoProductsFound("No products found");
		}
	}

	@Override
	public Product updateProductById(Product product, int id) {
		// TODO Auto-generated method stub
		Product updatedProduct = findProductById(id);
		if (updatedProduct == null) {
			throw new NoExistingProduct("No product found withis id : " + id);
		} else {
			updatedProduct.setAvailabilityQty(product.getAvailabilityQty());
			updatedProduct.setCategory(product.getCategory());
			updatedProduct.setDetails(product.getDetails());
			updatedProduct.setImageUrl(product.getImageUrl());
			updatedProduct.setMaterial(product.getMaterial());
			updatedProduct.setProductName(product.getProductName());

			return productrepository.save(updatedProduct);
		}
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> allProducts = productrepository.findAll();
		if (allProducts.size() > 0) {
			return allProducts;
		} else {
			throw new NoProductsFound("No products found");
		}
	}

	@Override
	public String deleteProductById(int id) {
		// TODO Auto-generated method stub

		Product product = findProductById(id);
		if (product != null) {
			productrepository.deleteById(id);
			return "Product deleted";
		} else {
			throw new NoExistingProduct("No existing product with this Id :" + id);
		}
	}

	@Override
	public List<Product> getProductsByName(String name) {
		// TODO Auto-generated method stub
		List<Product> products = productrepository.searchProductByName(name);
		if (products.size() > 0) {
			return products;
		} else {
			throw new NoProductsFound("No products found with this name : " + name);
		}
	}

}
