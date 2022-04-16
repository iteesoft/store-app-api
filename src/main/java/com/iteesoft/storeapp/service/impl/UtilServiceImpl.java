package com.iteesoft.storeapp.service.impl;

import com.iteesoft.storeapp.exceptions.NotFoundException;
import com.iteesoft.storeapp.model.Category;
import com.iteesoft.storeapp.model.Product;
import com.iteesoft.storeapp.repository.CategoryRepository;
import com.iteesoft.storeapp.repository.ProductRepository;
import com.iteesoft.storeapp.service.UtilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilServiceImpl implements UtilService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->
                new NotFoundException("Product not found", "check the id and try again"));
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("category not found", "check the name and try again"));
    }
}
