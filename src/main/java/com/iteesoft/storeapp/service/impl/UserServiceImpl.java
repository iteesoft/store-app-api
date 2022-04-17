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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AppUserRepository userRepo;
    private final StoreRepo storeRepo;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


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

    @Async
    @Override
    public CompletableFuture<List<AppUser>> findAllUsers() {
        logger.info("getting the list of all users by "+ Thread.currentThread().getName());
        List<AppUser> users = userRepo.findAll();
        return CompletableFuture.completedFuture(users);
    }


}
