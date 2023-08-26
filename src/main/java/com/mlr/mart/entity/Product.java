package com.mlr.mart.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String productName;
	private String details;
	private String imageUrl;
	private int availabilityQty;
	private String category;
	private String material;
	private boolean isThisInCart=false;
	
	@JsonBackReference
	@ManyToMany(mappedBy="products",fetch=FetchType.LAZY)
	private List<User> users;
	
	
   
	
	 

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

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
