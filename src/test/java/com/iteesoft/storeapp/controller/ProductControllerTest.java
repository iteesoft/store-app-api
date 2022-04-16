//package com.iteesoft.storeapp.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.iteesoft.storeapp.dto.ProductDto;
//import com.iteesoft.storeapp.model.Product;
//import com.iteesoft.storeapp.repository.ProductRepository;
//import com.iteesoft.storeapp.service.ProductService;
//import com.iteesoft.storeapp.service.impl.ProductServiceImpl;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MockMvcBuilder;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//import static org.springframework.http.MediaType.APPLICATION_JSON;
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProductController.class)
//public class ProductControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @InjectMocks
//    ProductController controller;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//    @MockBean
//    private ProductService productService;
//
//    @MockBean
//    private ProductRepository productRepo;
//
//    @Test
//    void createProduct() throws Exception {
//        ProductDto productDto = new ProductDto();
//        productDto.setName("Bournvita");
//        productDto.setPrice(850L);
//
//        Product product = new Product();
//        product.setName("Bournvita");
//        product.setPrice(850L);
//
//       when(productService.save(any(ProductDto.class))).thenReturn(product);
//        mvc.perform(post("/api/v1/products/new")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(productDto))
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isCreated());
//        verify(productService, times(1)).save(any(ProductDto.class));
//    }
//
//    @Test
//    void updateProduct() {
//    }
//
//    @Test
//    void deleteProduct() {
//    }
//
//    @Test
//    @DisplayName("Test findAll()")
//    void viewAllProducts() throws Exception {
//        List<Product> products = new ArrayList<>();
//        products.add(new Product(1L, "coca cola"));
//        products.add(new Product(2L, "cabin biscuits"));
//        products.add(new Product(3L, "can malt"));
//        when(productService.viewAll()).thenReturn(products);
//
//        String url = "/api/v1/products/";
//        mvc.perform(MockMvcRequestBuilders.get(url).accept(APPLICATION_JSON)).andExpect(status().isOk());
//    }
//}