package com.nagarro.walmartdeals.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nagarro.walmartdeals.entity.DealItem;
import com.nagarro.walmartdeals.repo.DealItemRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private DealItemRepository dealItemRepository;

	@Override
	public void run(String... args) throws Exception {
		List<DealItem> dealItems = createWalmartSampleDealItems();
		dealItemRepository.saveAll(dealItems);
	}

	private List<DealItem> createWalmartSampleDealItems() {
		List<DealItem> walmartSampleDeals = new ArrayList<>();

		walmartSampleDeals.add(createWalmartDealItem("Jeans", "777654321", "Men Black Regular Jeans", "32", "H&M",
				"https://example.com/walmart-image1.jpg", 29.99, 40.0, 11.99, 17.99, 4, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		walmartSampleDeals.add(createWalmartDealItem("Jeans", "55666778231", "Light Fade Clean Look Stretchable Jeans",
				"32", "Louis Philippe Jeans", "https://example.com/walmart-image2.jpg", 39.99, 25.0, 09.99, 29.99, 3,
				"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		walmartSampleDeals.add(createWalmartDealItem("Shirts", "9876543210", "White Oxford Shirt", "L", "Gap",
				"https://example.com/walmart-image3.jpg", 34.99, 15.0, 05.24, 29.75, 10, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		walmartSampleDeals.add(createWalmartDealItem("Shoes", "5678901234", "Brown Leather Boots", "9", "Clarks",
				"https://example.com/walmart-image4.jpg", 89.99, 20.0, 17.99, 72.0, 15, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		walmartSampleDeals.add(createWalmartDealItem("Laptops", "0123456789", "HP Spectre x360", "13.3\"", "HP",
				"https://example.com/walmart-image5.jpg", 1299.99, 10.0, 129.99, 1170.0, 8, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		walmartSampleDeals.add(createWalmartDealItem("Watches", "3456789012",
				"Fossil Men's Grant Stainless Steel Watch", "Men's", "Fossil", "https://example.com/walmart-image6.jpg",
				89.99, 25.0, 22.49, 67.5, 12, "2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		walmartSampleDeals.add(createWalmartDealItem("Cameras", "6789012345", "Nikon D5600 DSLR Camera", "24.2MP",
				"Nikon", "https://example.com/walmart-image7.jpg", 699.99, 15.0, 104.99, 595.0, 6,
				"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		walmartSampleDeals.add(createWalmartDealItem("Smartphones", "9012345678", "Apple iPhone 13", "128GB", "Apple",
				"https://example.com/walmart-image8.jpg", 999.99, 8.0, 79.99, 920.0, 10, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		walmartSampleDeals
				.add(createWalmartDealItem("Headphones", "1234567890", "Bose QuietComfort 35 II Wireless Headphones",
						"Over-Ear", "Bose", "https://example.com/walmart-image9.jpg", 349.99, 20.0, 69.99, 280.0, 20,
						"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		walmartSampleDeals.add(createWalmartDealItem("Gaming Consoles", "0987654321", "Xbox Series X", "1TB SSD",
				"Microsoft", "https://example.com/walmart-image10.jpg", 499.99, 12.0, 59.99, 440.0, 8,
				"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));

		return walmartSampleDeals;
	}

	private DealItem createWalmartDealItem(String categoryName, String itemId, String productTitle, String size,
			String brand, String imageUrl, double originalPrice, double discountPercentage, double discountAmount,
			double price, int stock, String dealStartDate, String dealEndDate) {
		DealItem dealItem = new DealItem();
		dealItem.setCategoryName(categoryName);
		dealItem.setItemId(itemId);
		dealItem.setProductTitle(productTitle);
		dealItem.setSize(size);
		dealItem.setBrand(brand);
		dealItem.setImageUrl(imageUrl);
		dealItem.setOriginalPrice(originalPrice);
		dealItem.setDiscountPercentage(discountPercentage);
		dealItem.setDiscountAmount(discountAmount);
		dealItem.setPrice(price);
		dealItem.setStock(stock);
		dealItem.setDealStartDate(dealStartDate);
		dealItem.setDealEndDate(dealEndDate);
		return dealItem;
	}
}
