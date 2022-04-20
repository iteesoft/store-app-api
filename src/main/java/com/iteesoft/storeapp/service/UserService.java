package com.iteesoft.storeapp.service;

import com.iteesoft.storeapp.dto.UserDto;
import com.iteesoft.storeapp.model.AppUser;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface UserService {

    AppUser save(UserDto user);
    AppUser update(UserDto user);
    void addRoleToUser(String userName, String role);
    AppUser getUser(String userName);
    CompletableFuture<List<AppUser>> findAllUsers();
}
