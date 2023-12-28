package com.nagarro.productdeals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.productdeals.entity.DealItem;
import com.nagarro.productdeals.service.DealService;

@RestController
@RequestMapping("/deals")
public class DealController {

	private final DealService dealService;

	@Autowired
	public DealController(DealService dealService) {
		this.dealService = dealService;
	}

	@GetMapping("/{categoryName}")
	public ResponseEntity<List<DealItem>> getDeals(@PathVariable String categoryName) {
		List<DealItem> deals = dealService.getDeals(categoryName);
		return new ResponseEntity<>(deals, HttpStatus.OK);
	}
}
