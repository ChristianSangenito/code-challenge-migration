package com.example.dummyjson.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductWrapper;

@FeignClient(name="product-service", url = "${dummyjson.server.url}")
public interface ProductClient {

	@GetMapping("/products")
	ProductWrapper getProductWrapper();
	
	@GetMapping("/products/{id}")
	Product getPRoductById(@PathVariable("id") Long id);

}