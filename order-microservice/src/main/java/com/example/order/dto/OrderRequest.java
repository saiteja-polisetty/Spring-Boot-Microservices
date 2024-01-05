package com.example.order.dto;

import java.util.List;

public class OrderRequest {

	private List<OrderLineItemsDTO> orderLineItemsDTOList;

	public OrderRequest() {}
	
	public OrderRequest(List<OrderLineItemsDTO> orderLineItemsDTOList) {
		super();
		this.orderLineItemsDTOList = orderLineItemsDTOList;
	}

	public List<OrderLineItemsDTO> getOrderLineItemsDTOList() {
		return orderLineItemsDTOList;
	}

	public void setOrderLineItemsDTOList(List<OrderLineItemsDTO> orderLineItemsDTOList) {
		this.orderLineItemsDTOList = orderLineItemsDTOList;
	}

	@Override
	public String toString() {
		return "OrderRequest [orderLineItemsDTOList=" + orderLineItemsDTOList + "]";
	}
	
	
}
