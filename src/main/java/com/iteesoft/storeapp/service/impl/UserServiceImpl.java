package com.iteesoft.storeapp.service.impl;

import com.iteesoft.storeapp.enums.Role;
import com.iteesoft.storeapp.dto.UserDto;
import com.iteesoft.storeapp.exceptions.NotFoundException;
import com.iteesoft.storeapp.model.*;
import com.iteesoft.storeapp.repository.AppUserRepository;
import com.iteesoft.storeapp.repository.StoreRepo;
import com.iteesoft.storeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AppUserRepository userRepo;
    private final StoreRepo storeRepo;


    @Override
    public AppUser save(UserDto user) {
        AppUser newUser = AppUser.builder()
                .email(user.getEmail()).name(user.getName())
                .password(user.getPassword()).role(Role.valueOf(user.getRole())).build();

        return userRepo.save(newUser);
    }

    @Override
    public AppUser update(Long userId, UserDto user) {
        AppUser oldUser = userRepo.findById(userId).orElseThrow(()-> new NotFoundException("User doesn't exist", "check the id and try again"));
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(Role.valueOf(user.getRole()));
        oldUser.setUpdatedAt(LocalDateTime.now());
        return userRepo.save(oldUser);
    }


}
