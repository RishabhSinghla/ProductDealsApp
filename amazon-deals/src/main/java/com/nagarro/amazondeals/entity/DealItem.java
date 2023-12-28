package com.nagarro.amazondeals.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
