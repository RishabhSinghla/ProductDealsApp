package com.nagarro.productdeals.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.nagarro.productdeals.constants.DealConstants;
import com.nagarro.productdeals.entity.DealItem;
import com.nagarro.productdeals.entity.DealResponse;
import com.nagarro.productdeals.service.DealService;

import reactor.core.publisher.Mono;

@Service
public class DealServiceImpl implements DealService {

	private final WebClient webClient;

	public DealServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	public List<DealItem> getDeals(String categoryName) {
		List<CompletableFuture<List<DealItem>>> futures = new ArrayList<>();

		futures.add(fetchDealsAsync(DealConstants.AMAZON_DEALS_URL, categoryName));
		futures.add(fetchDealsAsync(DealConstants.EBAY_DEALS_URL, categoryName));
		futures.add(fetchDealsAsync(DealConstants.WALMART_DEALS_URL, categoryName));

		CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

		List<DealItem> allDeals = allOf
				.thenApply(
						v -> futures.stream().map(CompletableFuture::join).flatMap(List::stream)
								.filter(this::isValidDeal).sorted(Comparator.comparing(DealItem::getDiscountPercentage)
										.reversed().thenComparing(DealItem::getPrice))
								.collect(Collectors.toList()))
				.join();

		return allDeals;
	}

	private CompletableFuture<List<DealItem>> fetchDealsAsync(String uriTemplate, String categoryName) {
		return CompletableFuture.supplyAsync(() -> {
			try {
				return webClient.get().uri(uriTemplate, categoryName).retrieve().bodyToMono(DealResponse.class)
						.onErrorResume(WebClientResponseException.class, ex -> Mono.just(new DealResponse()))
						.map(DealResponse::getDealItems).block();
			} catch (Exception e) {
				return Collections.emptyList();
			}
		});
	}

	private boolean isValidDeal(DealItem dealItem) {
		return dealItem.getStock() > 0 && LocalDateTime.now().isBefore(parseDateTime(dealItem.getDealEndDate()))
				&& LocalDateTime.now().isAfter(parseDateTime(dealItem.getDealStartDate()));
	}

	private LocalDateTime parseDateTime(String dateTimeString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DealConstants.DATE_TIME_FORMAT);
		return LocalDateTime.parse(dateTimeString, formatter);
	}

}
