package com.mlr.mart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mlr.mart.entity.ProductsCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductsCategory, Integer>{

}
