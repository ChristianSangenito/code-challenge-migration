package com.example.dummyjson.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.dummyjson.dto.Product;
import com.example.dummyjson.dto.ProductWrapper;
import com.example.dummyjson.interfaces.ProductClient;
import com.example.dummyjson.util.ProductUtil;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;
    
    @Mock
    private ProductClient productClient;

    @Test
    public void testGetAllProducts() {
        List<Product> expectedProducts = Arrays.asList(ProductUtil.getProduct(1L), ProductUtil.getProduct(2L));
        
        when(productClient.getProductWrapper()).thenReturn(ProductWrapper.builder().products(expectedProducts).build());
        List<Product> responseProducts = productService.getAllProducts();
        
        assertThat(expectedProducts).usingRecursiveAssertion().isEqualTo(responseProducts);
    }

    @Test
    public void testGetProductById() {
    	long productId = 2L;
    	Product expectedProduct = ProductUtil.getProduct(productId);
    	
    	when(productClient.getProductById(productId)).thenReturn(expectedProduct);
    	Product responseProduct = productService.getProductById(productId);
    	
    	assertThat(expectedProduct).usingRecursiveAssertion().isEqualTo(responseProduct);
    }
}
