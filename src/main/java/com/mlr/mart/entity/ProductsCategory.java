package com.mlr.mart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="")
public class ProductsCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String imageUrl;
	private String categoryName;
	
	
	
	public ProductsCategory() {
		super();
	}

	public ProductsCategory(int id, String imageUrl, String categoryName) {
		super();
		this.id = id;
		this.imageUrl = imageUrl;
		this.categoryName = categoryName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	

}
