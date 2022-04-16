package com.iteesoft.storeapp.service;

import com.iteesoft.storeapp.dto.StoreDto;
import com.iteesoft.storeapp.model.Store;

public interface StoreService {
    Store save(StoreDto store, Long userId);
    Store update(StoreDto store, Long storeId);
    String getStoreBalance(Long storeId);
}
