package com.mlr.mart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mlr.mart.entity.ProductsCategory;
import com.mlr.mart.service.ProductCategoryService;

@RestController
public class ProductCategoryController {
	
	@Autowired
	private ProductCategoryService productcategoryservice;
	
	@PostMapping("/addProductCategory")
	public String addProductCategory(@RequestBody ProductsCategory productcategory) {
		productcategoryservice.addProductCategory(productcategory);
		return "added product category";
	}
	
	@GetMapping("/getAllProductcategory")
	public List<ProductsCategory> getAllProductcategory(){
		List<ProductsCategory>productcategory=productcategoryservice.getAllProductCategories();
		return productcategory;
	}

}
