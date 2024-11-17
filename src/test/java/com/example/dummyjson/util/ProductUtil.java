package com.example.dummyjson.util;

import com.example.dummyjson.dto.Product;

public class ProductUtil {

    public static Product getProduct(long id) {
    	return Product
    			.builder()
    			.id(id)
    			.title("Title " + id)
    			.description("Description " + id)
    			.price(Double.valueOf(id))
    			.build();
    }
	
}