package com.mlr.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.ProductsCategory;
import com.mlr.mart.exception.NoProductCategories;
import com.mlr.mart.service.ProductCategoryService;

@RestController
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productcategoryservice;

	@PostMapping("/addProductCategory")
	public ResponseEntity<String> addProductCategory(@RequestBody ProductsCategory productcategory) {

		String response = productcategoryservice.addProductCategory(productcategory);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Product category Not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllProductcategories")
	public ResponseEntity<?> getAllProductcategory() {
		try {
			List<ProductsCategory> productcategory = productcategoryservice.getAllProductCategories();
			if (productcategory.size() > 0) {
				return new ResponseEntity<>(productcategory, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (NoProductCategories e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updateProductCategoryById/{id}")
	public ResponseEntity<?> updateProductCategoryById(@RequestBody ProductsCategory category, @PathVariable int id) {
		try {
			ProductsCategory productCategory = productcategoryservice.updateCategoryById(category, id);
			if (productCategory != null) {
				return new ResponseEntity<>(productCategory, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (NoProductCategories e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deletecategoryById/{id}")
	public ResponseEntity<?> deletecategoryById(@PathVariable int id) {
		try {
			String response = productcategoryservice.deleteProductCategoryById(id);
			if (response != null) {
				return new ResponseEntity<>("category deleted", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("category not deleted", HttpStatus.NOT_FOUND);
			}
		} catch (NoProductCategories e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/getCategoryById/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable int id) {

		ProductsCategory productCategory = productcategoryservice.getProductCategoryById(id);
		if (productCategory != null) {
			return new ResponseEntity<>(productCategory, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No categories found with this id :" + id, HttpStatus.NOT_FOUND);
		}

	}
}
