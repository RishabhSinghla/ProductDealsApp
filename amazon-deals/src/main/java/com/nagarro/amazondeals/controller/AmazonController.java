package com.nagarro.amazondeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.amazondeals.entity.DealItem;
import com.nagarro.amazondeals.entity.DealResponse;
import com.nagarro.amazondeals.repo.DealItemRepository;

@RestController
@RequestMapping("/backendserver1/amazon")
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
