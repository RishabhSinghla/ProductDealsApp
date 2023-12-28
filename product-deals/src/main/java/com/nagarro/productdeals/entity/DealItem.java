package com.nagarro.productdeals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealItem {

	private Long id;
	private String categoryName;
	private String itemId;
	private String productTitle;
	private String size;
	private String brand;
	private String imageUrl;
	private Double originalPrice;
	private Double discountPercentage;
	private Double discountAmount;
	private Double price;
	private Integer stock;
	private String dealStartDate;
	private String dealEndDate;
	
	public DealItem(String categoryName, String itemId, String productTitle, String size, String brand, String imageUrl,
			Double originalPrice, Double discountPercentage, Double discountAmount, Double price, Integer stock,
			String dealStartDate, String dealEndDate) {
		super();
		this.categoryName = categoryName;
		this.itemId = itemId;
		this.productTitle = productTitle;
		this.size = size;
		this.brand = brand;
		this.imageUrl = imageUrl;
		this.originalPrice = originalPrice;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
		this.price = price;
		this.stock = stock;
		this.dealStartDate = dealStartDate;
		this.dealEndDate = dealEndDate;
	}

}
