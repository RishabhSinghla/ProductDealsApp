package com.nagarro.walmartdeals.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealResponse {

	private String categoryName;
	private List<DealItem> dealItems;

}
