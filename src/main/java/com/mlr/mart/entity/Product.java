package com.mlr.mart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String productName;
	private String details;
	private String imageUrl;
	private int availabilityQty;
	private String category;
	private String material;
	private boolean isThisInCart=false;
	
	
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public boolean isThisInCart() {
		return isThisInCart;
	}

	public void setThisInCart(boolean isThisInCart) {
		this.isThisInCart = isThisInCart;
	}

	public Product() {
		super();
	}

	public Product(int id, String productName, String details, String imageUrl, int availabilityQty, String category) {
		super();
		this.id = id;
		this.productName = productName;
		this.details = details;
		this.imageUrl = imageUrl;
		this.availabilityQty = availabilityQty;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getAvailabilityQty() {
		return availabilityQty;
	}
	public void setAvailabilityQty(int availabilityQty) {
		this.availabilityQty = availabilityQty;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
