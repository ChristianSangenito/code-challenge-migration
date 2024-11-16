package com.example.dummyjson.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.interfaces.ProductClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductClient productClient;

    public List<Product> getAllProducts() {
    	return productClient.getProductWrapper().getProducts();
    }

    public Product getProductById(Long id) {
    	return productClient.getPRoductById(id);
    }
}