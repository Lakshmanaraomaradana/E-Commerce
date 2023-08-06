package com.mlr.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.Product;
import com.mlr.mart.exception.NoExistingProduct;
import com.mlr.mart.exception.NoProductsFound;
import com.mlr.mart.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getAllProductsByCategory/{category}")
	public ResponseEntity<?> getAllProductsByCategory(@PathVariable String category) {
		try {
			List<Product> products = productservice.findAllProductsByCategory(category);
			if (products != null) {
				return new ResponseEntity<>(products, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (NoProductsFound e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getAllProducts")
	public ResponseEntity<?> getAllProducts() {
		try {
			List<Product> allProducts = productservice.getAllProducts();
			return new ResponseEntity<>(allProducts, HttpStatus.OK);
		} catch (NoProductsFound e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		String response = productservice.addProduct(product);
		if (response != null) {
			return new ResponseEntity<>("Product Added", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product not Added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
    
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/findProduct/{id}")
	public ResponseEntity<?> findProductById(@PathVariable int id) {

		Product product = productservice.findProductById(id);
		if (product != null) {
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No products found with this id :" + id, HttpStatus.NOT_FOUND);
		}

	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getAllCartProducts")
	public ResponseEntity<?> getAllCartProducts() {
		try {
			List<Product> allProducts = productservice.getAllCartProducts();
			if (allProducts.size() > 0) {
				return new ResponseEntity<>(allProducts, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (NoProductsFound e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PutMapping("/addToCart/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable int id) {

		Product product = productservice.findProductById(id);
		if (product != null) {
			productservice.addToCart(product);
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No product found with this id" + id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@PutMapping("/updateProductById/{id}")
	public ResponseEntity<?> updateProductById(@RequestBody Product product, @PathVariable int id) {

		// Product product=productservice.findProductById(id);
		try {
			if (product != null) {
				Product updatedProduct = productservice.updateProductById(product, id);
				return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (NoExistingProduct e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/deleteProductById/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable int id) {
		try {
			String response = productservice.deleteProductById(id);
			if (response != null) {
				return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("No existing product with this id :" + id, HttpStatus.NOT_FOUND);
			}
		} catch (NoExistingProduct e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/getProductsByName/{name}")
	public ResponseEntity<?> getAllProductsByName(@PathVariable String name) {
		try {
			List<Product> products = productservice.getProductsByName(name);
			return new ResponseEntity<>(products, HttpStatus.OK);

		} catch (NoProductsFound e) {

			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

}
