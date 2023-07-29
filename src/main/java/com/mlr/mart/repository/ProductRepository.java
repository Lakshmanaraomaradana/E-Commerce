package com.mlr.mart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mlr.mart.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE p.category=:category")
	public List<Product> getAllProductsBycategory(@Param("category")String category);
    
	@Query("SELECT p FROM Product p WHERE p.isThisInCart=true")
	public List<Product>getAllCartProducts();
	
	@Query("SELECT p FROM Product p WHERE p.productName=:name")
	public List<Product>searchProductByName(@Param("name")String name);
}
