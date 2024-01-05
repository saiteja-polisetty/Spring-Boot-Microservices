package com.example.inventory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.inventory.dto.InventoryResponse;
import com.example.inventory.repository.InventoryRepository;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Transactional(readOnly = true)
	public List<InventoryResponse> isInStock(List<String> skuCode) {
		
		List<InventoryResponse> inventoryResponseList = new ArrayList<>();
		
		inventoryRepository.findBySkuCodeIn(skuCode).forEach(inventory -> {
			InventoryResponse inventoryResponse = new InventoryResponse(inventory.getSkuCode(), inventory.getQuantity()>0);
			inventoryResponseList.add(inventoryResponse);
		});
		
		return inventoryResponseList;
	}

}
