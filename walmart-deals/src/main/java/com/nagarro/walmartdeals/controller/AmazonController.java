package com.nagarro.walmartdeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.walmartdeals.entity.DealItem;
import com.nagarro.walmartdeals.entity.DealResponse;
import com.nagarro.walmartdeals.repo.DealItemRepository;

@RestController
@RequestMapping("/backendserver3/walmart")
public class AmazonController {

	@Autowired
	private DealItemRepository dealItemRepository;

	@GetMapping("/deals/{categoryName}")
	public DealResponse getDeals(@PathVariable String categoryName) {
		List<DealItem> dealItems = dealItemRepository.findByCategoryName(categoryName);

		DealResponse response = new DealResponse();
		response.setCategoryName(categoryName);
		response.setDealItems(dealItems);

		return response;
	}
}
