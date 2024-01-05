package com.example.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.dto.ProductRequest;
import com.example.product.dto.ProductResponse;
import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setPrice(productRequest.getPrice());
		
		productRepository.save(product);
		System.out.println("Product " + product.getId() +" is saved");
	}
	
	public List<ProductResponse> getAllProducts(){
		List<Product> products = productRepository.findAll();
		
		List<ProductResponse> productResponseList = new ArrayList<>();
		
		products.forEach((product) -> {
			ProductResponse productResponse = new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
			productResponseList.add(productResponse);
		});
		
		return productResponseList;
		
	}
}
