package com.mlr.mart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.ProductsCategory;
import com.mlr.mart.repository.ProductCategoryRepository;
import com.mlr.mart.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository productcategoryrepository;

	@Override
	public String addProductCategory(ProductsCategory productcategory) {
		// TODO Auto-generated method stub
		productcategoryrepository.save(productcategory);
		return "added product category";
	}

	@Override
	public List<ProductsCategory> getAllProductCategories() {
		// TODO Auto-generated method stub
		List<ProductsCategory>productcategories=productcategoryrepository.findAll();
		
		return productcategories;
	}

}
