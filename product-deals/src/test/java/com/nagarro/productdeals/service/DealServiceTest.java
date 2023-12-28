package com.nagarro.productdeals.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.productdeals.entity.DealItem;
import com.nagarro.productdeals.entity.DealResponse;
import com.nagarro.productdeals.service.impl.DealService;

class DealServiceTest {

	@Mock
	private WebClient webClient;

	@InjectMocks
	private DealService dealService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testGetDeals() {
		List<DealItem> amazonDeals = Arrays.asList(
				new DealItem("Jeans", "123", "Blue Jeans", "30", "Levis", "", 29.99, 17.0, 5.0, 24.99, 4,
						"2022-06-20T15:26:00Z", "2022-12-20T14:59:59Z"),
				new DealItem("Jeans", "456", "Black Jeans", "32", "Louis Philippe Jeans", "", 29.99, 50.0, 14.99, 14.99,
						3, "2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));

		List<DealItem> ebayDeals = Arrays.asList(
				new DealItem("Jeans", "789", "Blue American Eagle Jeans", "32", "American Eagle", "", 49.99, 50.0,
						24.99, 24.99, 4, "2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"),
				new DealItem("Jeans", "101", "Navy Blue Rare Rabbit Jeans", "32", "Rare Rabbit", "", 39.99, 25.0, 9.99,
						29.99, 0, "2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));

		List<DealItem> walmartDeals = Arrays.asList(
				new DealItem("Jeans", "202", "Men Black Regular Jeans", "32", "H&M", "", 29.99, 40.0, 11.99, 17.99, 4,
						"2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"),
				new DealItem("Jeans", "303", "Light Fade Clean Look Stretchable Jeans", "32", "Louis Philippe Jeans",
						"", 39.99, 25.0, 9.99, 29.99, 3, "2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));

		when(webClient.get()).thenReturn(webClient);
		when(webClient.uri(anyString(), anyString())).thenReturn(webClient);
		when(webClient.retrieve()).thenReturn(webClient);

		when(webClient.get().uri(anyString(), anyString()).retrieve().bodyToMono(DealResponse.class))
				.thenReturn(CompletableFuture.completedFuture(new DealResponse(amazonDeals)))
				.thenReturn(CompletableFuture.completedFuture(new DealResponse(ebayDeals)))
				.thenReturn(CompletableFuture.completedFuture(new DealResponse(walmartDeals)));

		List<DealItem> resultDeals = dealService.getDeals("Jeans");

		assertEquals(4, resultDeals.size());

		assertEquals("789", resultDeals.get(0).getItemId()); 
		assertEquals("101", resultDeals.get(1).getItemId()); 
	}

	@Test
    void testGetDealsWithEmptyResponse() {
        when(webClient.get()).thenReturn(webClient);
        when(webClient.uri(anyString(), anyString())).thenReturn(webClient);
        when(webClient.retrieve()).thenReturn(webClient);

        when(webClient.get().uri(anyString(), anyString()).retrieve().bodyToMono(DealResponse.class))
                .thenReturn(CompletableFuture.completedFuture(new DealResponse()))
                .thenReturn(CompletableFuture.completedFuture(new DealResponse()))
                .thenReturn(CompletableFuture.completedFuture(new DealResponse()));

        List<DealItem> resultDeals = dealService.getDeals("Jeans");

        assertEquals(0, resultDeals.size());
    }

	@Test
	void testGetDealsWithInvalidDates() {
		List<DealItem> invalidDateDeals = Arrays.asList(
				new DealItem("Jeans", "123", "Blue Jeans", "30", "Levis", "", 29.99, 17.0, 5.0, 24.99, 4,
						"2022-06-20T15:26:00Z", "2021-12-20T14:59:59Z"),
				new DealItem("Jeans", "456", "Black Jeans", "32", "Louis Philippe Jeans", "", 29.99, 50.0, 14.99, 14.99,
						3, "2023-06-20T15:26:00Z", "2023-12-20T14:59:59Z"));

		when(webClient.get()).thenReturn(webClient);
		when(webClient.uri(anyString(), anyString())).thenReturn(webClient);
		when(webClient.retrieve()).thenReturn(webClient);

		when(webClient.get().uri(anyString(), anyString()).retrieve().bodyToMono(DealResponse.class))
				.thenReturn(CompletableFuture.completedFuture(new DealResponse(invalidDateDeals)))
				.thenReturn(CompletableFuture.completedFuture(new DealResponse()))
				.thenReturn(CompletableFuture.completedFuture(new DealResponse()));

		List<DealItem> resultDeals = dealService.getDeals("Jeans");

		assertEquals(1, resultDeals.size()); 
		assertEquals("456", resultDeals.get(0).getItemId());
	}
}
