package com.example.order.dto;

import java.math.BigDecimal;

public class OrderLineItemsDTO {

	private Long id;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;

	public OrderLineItemsDTO() {}
	
	public OrderLineItemsDTO(Long id, String skuCode, BigDecimal price, Integer quantity) {
		super();
		this.id = id;
		this.skuCode = skuCode;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderLineItemsDTO [id=" + id + ", skuCode=" + skuCode + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

}
