package com.example.order.dto;

public class InventoryResponse {

	private String skuCode;
	private Boolean isinStock;
	
	public InventoryResponse() {}

	public InventoryResponse(String skuCode, Boolean isinStock) {
		super();
		this.skuCode = skuCode;
		this.isinStock = isinStock;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public Boolean getIsinStock() {
		return isinStock;
	}

	public void setIsinStock(Boolean isinStock) {
		this.isinStock = isinStock;
	}

	@Override
	public String toString() {
		return "InventoryResponse [skuCode=" + skuCode + ", isinStock=" + isinStock + "]";
	}
	
	
}
