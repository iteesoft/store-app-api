package com.iteesoft.storeapp.service;


import com.iteesoft.storeapp.dto.CategoryDto;
import com.iteesoft.storeapp.model.Category;
import com.iteesoft.storeapp.model.Product;

import java.util.Collection;
import java.util.List;

public interface CategoryService {
    Category save(CategoryDto categoryDto);
    Category update(Long id, Category category);
    void delete(Long id);
    List<String> getAllCategories();
    List<String> getProductsInCategory(Long id);
}
