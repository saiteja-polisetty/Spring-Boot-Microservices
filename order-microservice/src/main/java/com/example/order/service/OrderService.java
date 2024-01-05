package com.example.order.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.order.dto.InventoryResponse;
import com.example.order.dto.OrderLineItemsDTO;
import com.example.order.dto.OrderRequest;
import com.example.order.model.Order;
import com.example.order.model.OrderLineItems;
import com.example.order.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public String placeOrder(OrderRequest orderRequest) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDTOList()
			.stream()
			.map(this::mapToDTO)
			.toList();
		
		order.setOrderLineItemsList(orderLineItems);
		
		List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();
		InventoryResponse[] inventoryResponseArray = webClientBuilder.build().get().uri("http://InventoryService/api/inventory", uriBuilder->uriBuilder.queryParam("skuCode", skuCodes).build())
				.retrieve().bodyToMono(InventoryResponse[].class).block();
		
		Boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::getIsinStock);
		
		if(allProductsInStock) {
			orderRepository.save(order);
			return "Order Placed Successfully";
		} else {
			throw new IllegalArgumentException("Product is not in stock, please try again later");
		}
		
		
	}

	private OrderLineItems mapToDTO(OrderLineItemsDTO orderLineItemsDTO) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDTO.getPrice());
		orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
		return orderLineItems;
	}
}
