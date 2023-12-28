package com.nagarro.ebaydeals.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nagarro.ebaydeals.entity.DealItem;
import com.nagarro.ebaydeals.repo.DealItemRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private DealItemRepository dealItemRepository;

	@Override
	public void run(String... args) throws Exception {
		List<DealItem> dealItems = createEbaySampleDealItems();
		dealItemRepository.saveAll(dealItems);
	}

	private List<DealItem> createEbaySampleDealItems() {
		List<DealItem> ebaySampleDeals = new ArrayList<>();

		ebaySampleDeals.add(createEbayDealItem("Jeans", "2345678767", "Blue American Eagle Jeans", "32",
				"American Eagle", "https://example.com/ebay-image1.jpg", 49.99, 50.0, 24.99, 24.99, 4,
				"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Jeans", "4567822189", "Navy Blue Rare Rabbit Jeans", "32",
				"Rare Rabbit", "https://example.com/ebay-image2.jpg", 39.99, 25.0, 09.99, 29.99, 0,
				"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Shirts", "7890123456", "Red Polo T-Shirt", "M", "Polo Ralph Lauren",
				"https://example.com/ebay-image3.jpg", 29.99, 20.0, 05.99, 23.99, 8, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Shoes", "1234509876", "Black Running Shoes", "10", "Nike",
				"https://example.com/ebay-image4.jpg", 89.99, 30.0, 26.99, 63.0, 12, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Laptops", "8765432109", "Dell XPS 13 Laptop", "13.3\"", "Dell",
				"https://example.com/ebay-image5.jpg", 1099.99, 15.0, 164.99, 935.0, 20, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Watches", "3456789012", "Seiko Automatic Watch", "Men's", "Seiko",
				"https://example.com/ebay-image6.jpg", 199.99, 10.0, 19.99, 179.99, 5, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Cameras", "6789012345", "Canon EOS Rebel T7i DSLR Camera", "24.2MP",
				"Canon", "https://example.com/ebay-image7.jpg", 699.99, 25.0, 174.99, 525.0, 15, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Smartphones", "9012345678", "Samsung Galaxy S21", "128GB", "Samsung",
				"https://example.com/ebay-image8.jpg", 799.99, 12.0, 95.99, 704.0, 10, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Headphones", "1234567890", "Sony WH-1000XM4 Wireless Headphones",
				"Over-Ear", "Sony", "https://example.com/ebay-image9.jpg", 349.99, 20.0, 69.99, 280.0, 25,
				"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		ebaySampleDeals.add(createEbayDealItem("Gaming Consoles", "0987654321", "PlayStation 5", "1TB SSD", "Sony",
				"https://example.com/ebay-image10.jpg", 499.99, 10.0, 49.99, 450.0, 5, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));

		return ebaySampleDeals;
	}

	private DealItem createEbayDealItem(String categoryName, String itemId, String productTitle, String size,
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
