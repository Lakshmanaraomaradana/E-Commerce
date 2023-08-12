package com.mlr.mart.dto;

public class ProductDto {
	
	private String productName;
	private String details;
	private String imageUrl;
	private int availabilityQty;
	private String category;
	private String material;
	
	
	
	public ProductDto() {
		super();
	}
	public ProductDto(String productName, String details, String imageUrl, int availabilityQty, String category,
			String material) {
		super();
		this.productName = productName;
		this.details = details;
		this.imageUrl = imageUrl;
		this.availabilityQty = availabilityQty;
		this.category = category;
		this.material = material;
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
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
