package com.mlr.mart.service;

import java.util.List;

import com.mlr.mart.entity.ProductsCategory;

public interface ProductCategoryService {
	
	public String addProductCategory(ProductsCategory productcategory);
	public List<ProductsCategory>getAllProductCategories();
	

}
