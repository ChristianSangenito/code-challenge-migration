package com.example.dummyjson.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.example.dummyjson.service.ProductService;
import com.example.dummyjson.util.ProductUtil;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yaml")
public class ProductControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

	@MockBean
    private ProductService productService;

    @Test
    public void testGetAllProducts() throws Exception {
    	when(productService.getAllProducts()).thenReturn(Arrays.asList(ProductUtil.getProduct(1L)));
    	
    	mockMvc
			.perform(get("/api/products"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isArray())
			.andExpect(jsonPath("$[0].id").value(1))
			.andExpect(jsonPath("$[0].title").value("Title 1"))
			.andExpect(jsonPath("$[0].description").value("Description 1"))
			.andExpect(jsonPath("$[0].price").value(1.0));
    }

    @Test
    public void testGetProductById() throws Exception {
    	long productId = 1L;
    	when(productService.getProductById(productId)).thenReturn(ProductUtil.getProduct(productId));
    	
    	mockMvc
			.perform(get("/api/products/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").isNotEmpty())
			.andExpect(jsonPath("$.id").value(1))
			.andExpect(jsonPath("$.title").value("Title 1"))
			.andExpect(jsonPath("$.description").value("Description 1"))
			.andExpect(jsonPath("$.price").value(1.0));
    }
    

}
