package com.example.demo.model;

import java.util.List;

public class ProductVariations {
	private String variantType;
	private List<String> variationValues;
	private int quantity;
	
	
	
	public ProductVariations() {
		super();
	}

	public ProductVariations(String variantType, List<String> variationValues, int quantity) {
		super();
		this.variantType = variantType;
		this.variationValues = variationValues;
		this.quantity = quantity;
	}
	
	public String getVariantType() {
		return variantType;
	}
	public void setVariantType(String variantType) {
		this.variantType = variantType;
	}
	public List<String> getVariationValues() {
		return variationValues;
	}
	public void setVariationValues(List<String> variationValues) {
		this.variationValues = variationValues;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ProductVariations [variantType=" + variantType + ", variationValues=" + variationValues + ", quantity="
				+ quantity + "]";
	}
	
	
	
}
