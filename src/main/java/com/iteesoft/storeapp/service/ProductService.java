package com.iteesoft.storeapp.service;

import com.iteesoft.storeapp.dto.ProductDto;
import com.iteesoft.storeapp.exceptions.NotFoundException;
import com.iteesoft.storeapp.model.Category;
import com.iteesoft.storeapp.model.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct(ProductDto product);
    Product update(Long id, ProductDto newProduct) throws NotFoundException;
    void delete(Long id) throws NotFoundException;
    Product viewProduct(Long id);
    List<Product> viewAllProducts();
    Category addProductToCategory(Long productId, Long categoryId);
}
