package com.nagarro.ebaydeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.ebaydeals.entity.DealItem;
import com.nagarro.ebaydeals.entity.DealResponse;
import com.nagarro.ebaydeals.repo.DealItemRepository;

@RestController
@RequestMapping("/backendserver2/ebay")
public class EbayController {

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
