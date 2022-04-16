package com.iteesoft.storeapp.repository;

import com.iteesoft.storeapp.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepo extends JpaRepository<Store, Long> {
}
