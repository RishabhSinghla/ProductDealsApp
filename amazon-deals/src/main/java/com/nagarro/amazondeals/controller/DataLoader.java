package com.nagarro.amazondeals.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nagarro.amazondeals.entity.DealItem;
import com.nagarro.amazondeals.repo.DealItemRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private DealItemRepository dealItemRepository;

	@Override
	public void run(String... args) throws Exception {
		List<DealItem> dealItems = createSampleDealItems();
		dealItemRepository.saveAll(dealItems);
	}

	private List<DealItem> createSampleDealItems() {
		List<DealItem> sampleDeals = new ArrayList<>();

		sampleDeals.add(createDealItem("Jeans", "123456789", "Blue Levis Jeans", "30", "Levis",
				"https://example.com/image1.jpg", 29.99, 17.0, 5.0, 24.99, 4, "2022-06-20T15:26:00Z",
				"2022-12-20T14:59:59Z"));
		sampleDeals.add(createDealItem("Jeans", "981235678", "Black Men Slim Fir Mid Rise Jeans", "32",
				"Louis Philippe Jeans", "https://example.com/image2.jpg", 29.99, 50.0, 14.99, 14.99, 3,
				"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		sampleDeals.add(
				createDealItem("Shoes", "345678912", "Running Shoes", "8", "Nike", "https://example.com/image3.jpg",
						99.99, 30.0, 30.0, 69.99, 10, "2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));
		sampleDeals.add(createDealItem("Electronics", "567891234", "Smartphone", "N/A", "Samsung",
				"https://example.com/image4.jpg", 499.99, 15.0, 75.0, 424.99, 5, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		sampleDeals.add(createDealItem("Books", "789123456", "Science Fiction Novel", "N/A", "Author X",
				"https://example.com/image5.jpg", 19.99, 10.0, 2.0, 17.99, 15, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		sampleDeals.add(createDealItem("Home Decor", "901234567", "Decorative Vase", "N/A", "Artisan Crafts",
				"https://example.com/image6.jpg", 49.99, 20.0, 10.0, 39.99, 8, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		sampleDeals.add(createDealItem("Sports Equipment", "1122334455", "Tennis Racket", "N/A", "Wilson",
				"https://example.com/image7.jpg", 89.99, 25.0, 22.5, 67.49, 6, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		sampleDeals.add(createDealItem("Watches", "2233445566", "Men's Luxury Watch", "N/A", "Rolex",
				"https://example.com/image8.jpg", 4999.99, 10.0, 500.0, 4499.99, 2, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		sampleDeals.add(createDealItem("Beauty", "3344556677", "Skincare Set", "N/A", "L'Oreal",
				"https://example.com/image9.jpg", 79.99, 15.0, 12.0, 67.99, 12, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));
		sampleDeals.add(createDealItem("Furniture", "4455667788", "Modern Sofa", "N/A", "IKEA",
				"https://example.com/image10.jpg", 799.99, 20.0, 160.0, 639.99, 3, "2023-06-20T15:26:00Z",
				"2023-12-20T14:59:59Z"));

		return sampleDeals;
	}

	private DealItem createDealItem(String categoryName, String itemId, String productTitle, String size, String brand,
			String imageUrl, double originalPrice, double discountPercentage, double discountAmount, double price,
			int stock, String dealStartDate, String dealEndDate) {
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
