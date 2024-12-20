package com.example.demo;

import java.time.Instant;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entities.Category;
import com.example.demo.entities.Product;

public class Factory {
    public static Product createProduct(){
        Product  product = new Product(1L,"Phone","Good Phone",800.0,"https://img.com/img.png",Instant.parse("2020-07-14T10:00:00Z"));
        product.getCategories().add(new Category(2L, "Electronics"));
        
        return product;
    }
    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }    
}
