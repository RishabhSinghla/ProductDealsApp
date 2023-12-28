package com.nagarro.ebaydeals.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.ebaydeals.entity.DealItem;

public interface DealItemRepository extends JpaRepository<DealItem, Long> {

	List<DealItem> findByCategoryName(String categoryName);
}
