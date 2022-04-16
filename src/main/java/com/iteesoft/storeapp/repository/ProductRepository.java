package com.iteesoft.storeapp.repository;

import com.iteesoft.storeapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    boolean existsByNameAndDescription(String name, String description);
}
