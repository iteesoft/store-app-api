package com.iteesoft.storeapp.service;

import com.iteesoft.storeapp.model.Category;
import com.iteesoft.storeapp.model.Product;

public interface UtilService {

    Product getProductById(Long id);
    Category getCategoryById(Long id);
}
