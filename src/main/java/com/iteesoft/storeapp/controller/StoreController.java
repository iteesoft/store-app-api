package com.iteesoft.storeapp.controller;


import com.iteesoft.storeapp.dto.StoreDto;
import com.iteesoft.storeapp.model.Store;
import com.iteesoft.storeapp.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/new/{userId}")
    public ResponseEntity<Store> createStore(@PathVariable Long userId, @RequestBody StoreDto store) {
        return new ResponseEntity<>(storeService.save(store, userId), CREATED);
    }

    @PutMapping("/{storeId}")
    public ResponseEntity<Store> updateStore(@PathVariable Long storeId, @RequestBody StoreDto store) {
        return new ResponseEntity<>(storeService.update(store, storeId), OK);
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<String> viewBalance(@PathVariable Long storeId) {
        return new ResponseEntity<>(storeService.getStoreBalance(storeId), OK);
    }
}
