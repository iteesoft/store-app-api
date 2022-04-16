package com.iteesoft.storeapp.service.impl;

import com.iteesoft.storeapp.dto.CategoryDto;
import com.iteesoft.storeapp.exceptions.NotFoundException;
import com.iteesoft.storeapp.model.Category;
import com.iteesoft.storeapp.model.Product;
import com.iteesoft.storeapp.repository.CategoryRepository;
import com.iteesoft.storeapp.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public Category save(CategoryDto categoryDto) {
        log.info("Creating Category with name : {}", categoryDto.getName());
        Category category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category update(Long id, Category category) {
        var existingCategory = getCategory(id);
        existingCategory.setName(category.getName());
        categoryRepository.save(existingCategory);
        return existingCategory;
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting Category with id :{} ", id);
        categoryRepository.delete(getCategory(id));
    }

    @Override
    public List<String> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(Category::getName).collect(Collectors.toList());
    }

    @Override
    public List<String> getProductsInCategory(Long id) {
        List<Product> products = getCategory(id).getProducts();
        return products.stream().map(Product::getName).collect(Collectors.toList());
    }

    private Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("category not found", "check the name and try again"));
    }
}
