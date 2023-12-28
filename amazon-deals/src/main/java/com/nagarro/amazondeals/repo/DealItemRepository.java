package com.nagarro.amazondeals.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.amazondeals.entity.DealItem;

public interface DealItemRepository extends JpaRepository<DealItem, Long> {

	List<DealItem> findByCategoryName(String categoryName);
}
