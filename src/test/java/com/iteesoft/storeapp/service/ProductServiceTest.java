//package com.iteesoft.storeapp.service;
//
//import com.iteesoft.storeapp.dto.ProductDto;
//import com.iteesoft.storeapp.model.Product;
//import com.iteesoft.storeapp.repository.ProductRepository;
//import com.iteesoft.storeapp.service.impl.ProductServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServiceTest {
//
//    @Mock
//    private ProductRepository productRepository;
//
//    @InjectMocks
//    private ProductServiceImpl productService;
//
//
//
////    @InjectMocks
////    private ProductService productServiceImpl = new ProductServiceImpl();
//
//
//    @Test
//    void should_save_product() {
//        Product newProduct = Product.builder().name("viju milk").price(new BigDecimal("100.00")).build();
//        Product testProduct = productService.save(newProduct);
//        when(productService.save(newProduct)).thenReturn(testProduct);
//
//        assertThat(testProduct.getName()).isSameAs(newProduct.getName());
//    }
//
//    @Test
//    void should_delete_product() {
//        Product newProduct = Product.builder().name("viju milk").price(new BigDecimal("100.00")).build();
//        Product testProduct = productService.save(newProduct);
//        System.out.println(testProduct);
//        productService.delete(testProduct.getId());
//
//        verify(productRepository, times(1)).deleteById(testProduct.getId());
//    }
//
//
//    @Test
//    void canGetAllProducts() {
//        productService.viewAll();
//        verify(productRepository).findAll();
//    }
//
//    @Test
//    void can_update_Products() {
//        Product newProduct = Product.builder().name("Close Up Toothpaste").build();
//        ProductDto testProduct = ProductDto.builder().productName("Close Up Toothpaste").build();
////        productService.update(1L, testProduct);
//        when(productService.update(1L,testProduct)).thenReturn(newProduct);
//        assertThat(newProduct.getName()).isSameAs(testProduct.getProductName());
//    }
//}