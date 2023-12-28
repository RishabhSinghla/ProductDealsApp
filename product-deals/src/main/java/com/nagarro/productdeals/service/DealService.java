package com.nagarro.productdeals.service;

import java.util.List;

import com.nagarro.productdeals.entity.DealItem;

public interface DealService {

	List<DealItem> getDeals(String categoryName);
}
