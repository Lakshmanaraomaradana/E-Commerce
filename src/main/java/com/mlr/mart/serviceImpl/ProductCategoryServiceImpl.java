package com.mlr.mart.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlr.mart.entity.ProductsCategory;
import com.mlr.mart.exception.NoProductCategories;
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
		List<ProductsCategory> productcategories = productcategoryrepository.findAll();
		if (productcategories.size() > 0) {
			return productcategories;
		} else {
			throw new NoProductCategories("No product categories found ");
		}
	}

	@Override
	public ProductsCategory updateCategoryById(ProductsCategory productcategory, int id) {
		// TODO Auto-generated method stub
		ProductsCategory category = getProductCategoryById(id);
		if (category == null) {
			throw new NoProductCategories("No product categories found to update with this id :" + id);
		} else {
			category.setCategoryName(productcategory.getCategoryName());
			category.setImageUrl(productcategory.getImageUrl());
			return productcategoryrepository.save(category);
		}

	}

	@Override
	public ProductsCategory getProductCategoryById(int id) {
		// TODO Auto-generated method stub
		ProductsCategory category = productcategoryrepository.findById(id).orElse(null);

		return category;
	}

	@Override
	public String deleteProductCategoryById(int id) {
		// TODO Auto-generated method stub
		ProductsCategory category = getProductCategoryById(id);
		if (category != null) {
			productcategoryrepository.deleteById(id);
			return "Product category deleted";
		} else {
			throw new NoProductCategories("No product categories found with this id :" + id);
		}
	}

}
