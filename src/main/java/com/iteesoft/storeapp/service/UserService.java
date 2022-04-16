package com.iteesoft.storeapp.service;

import com.iteesoft.storeapp.dto.UserDto;
import com.iteesoft.storeapp.model.AppUser;

public interface UserService {

    AppUser save(UserDto user);
    AppUser update(Long userId, UserDto user);
}
