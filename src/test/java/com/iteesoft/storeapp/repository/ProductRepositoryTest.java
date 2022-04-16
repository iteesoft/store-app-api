package com.iteesoft.storeapp.repository;

import com.iteesoft.storeapp.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepoTest;

    @Test
    void itShouldFindProductByName() {

//        Product product = new Product();
//        product.setName("Viju Milk");
//        productRepoTest.save(product);
//
//        Product testProduct = productRepoTest.findByName(product.getName());
//        assertThat(testProduct.getName()).isEqualTo(product.getName());
    }
}