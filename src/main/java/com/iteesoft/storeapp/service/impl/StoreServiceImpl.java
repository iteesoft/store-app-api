package com.iteesoft.storeapp.service.impl;

import com.iteesoft.storeapp.dto.StoreDto;
import com.iteesoft.storeapp.exceptions.NotFoundException;
import com.iteesoft.storeapp.model.AppUser;
import com.iteesoft.storeapp.model.Store;
import com.iteesoft.storeapp.model.Wallet;
import com.iteesoft.storeapp.repository.AppUserRepository;
import com.iteesoft.storeapp.repository.StoreRepo;
import com.iteesoft.storeapp.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final AppUserRepository userRepo;
    private final StoreRepo storeRepo;

    @Override
    public Store save(StoreDto store, Long userId) {
        AppUser storeOwner = userRepo.findById(userId).orElseThrow(()-> new NotFoundException("User doesn't exist", "check the id and try again"));

        Store newStore = Store.builder().name(store.getStoreName())
                .storeOwner(storeOwner).address(store.getAddress())
                .logoUrl(store.getLogoUrl())
                .build();
        return storeRepo.save(newStore);
    }

    @Override
    public Store update(StoreDto store, Long storeId) {
        Store oldStore = storeRepo.findById(storeId).orElseThrow(()-> new NotFoundException("Store doesn't exist", "check the id and try again"));;
        oldStore.setName(store.getStoreName());
        oldStore.setAddress(store.getAddress());
        oldStore.setLogoUrl(store.getLogoUrl());
        oldStore.setUpdatedAt(LocalDateTime.now());

        return storeRepo.save(oldStore);
    }

    @Override
    public String getStoreBalance(Long storeId) {
        Store store = storeRepo.findById(storeId).orElseThrow(()-> new NotFoundException("Store doesn't exist", "check the id and try again"));;
        Wallet storeWallet = store.getStoreOwner().getWallet();
        return "$" + storeWallet.getBalance().toString();
    }

}
