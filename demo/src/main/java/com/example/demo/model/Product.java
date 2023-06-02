package com.example.demo.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Product {
	@Id
	private String id;
	private String name;
	private String discription;
	private float unitPrice;
	private float discount=0;
	private float rating;
	private int unitsInStock;
	private String category;
	private ProductVariations variation;
	private ProductFile image;
	private List<productReviews> reviews;
	private String provider;
	
	
	
	public Product(String id, String name, String discription, float unitPrice, float discount, float rating,
			int unitsInStock, String category, ProductVariations variation, ProductFile image, List<productReviews> reviews,
			String provider) {
		super();
		this.id = id;
		this.name = name;
		this.discription = discription;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.rating = rating;
		this.unitsInStock = unitsInStock;
		this.category = category;
		this.variation = variation;
		this.image = image;
		this.reviews = reviews;
		this.provider = provider;
	}
	public Product(String name, String discription, float unitPrice, float discount, float rating, int unitsInStock,
			String category, ProductVariations variation, ProductFile image, List<productReviews> reviews, String provider) {
		super();
		this.name = name;
		this.discription = discription;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.rating = rating;
		this.unitsInStock = unitsInStock;
		this.category = category;
		this.variation = variation;
		this.image = image;
		this.reviews = reviews;
		this.provider = provider;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ProductVariations getVariation() {
		return variation;
	}
	public void setVariation(ProductVariations variation) {
		this.variation = variation;
	}
	public ProductFile getImage() {
		return image;
	}
	public void setImage(ProductFile image) {
		this.image = image;
	}
	public List<productReviews> getReviews() {
		return reviews;
	}
	public void setReviews(List<productReviews> reviews) {
		this.reviews = reviews;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", discription=" + discription + ", unitPrice=" + unitPrice
				+ ", discount=" + discount + ", rating=" + rating + ", unitsInStock=" + unitsInStock + ", category="
				+ category + ", variation=" + variation + ", image=" + image + ", reviews=" + reviews + ", provider="
				+ provider + "]";
	}
	
	
	
	
}
