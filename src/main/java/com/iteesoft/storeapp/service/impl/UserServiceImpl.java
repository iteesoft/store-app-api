package com.iteesoft.storeapp.service.impl;

import com.iteesoft.storeapp.enums.Gender;
import com.iteesoft.storeapp.enums.Role;
import com.iteesoft.storeapp.dto.UserDto;
import com.iteesoft.storeapp.exceptions.AlreadyExistException;
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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AppUserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    private final StoreRepo storeRepo;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public AppUser save(UserDto user) {
        checkIfUserExist(user.getEmail());
        logger.info("saving new user {} ", user.getName());
        AppUser newUser = AppUser.builder().gender(Gender.valueOf(user.getGender()))
                .username(user.getEmail()).name(user.getName()).phoneNumber(user.getPhoneNumber())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(List.of(Role.valueOf(user.getRole()))).build();

        return userRepo.save(newUser);
    }

    private void checkIfUserExist(String email) {
        logger.info("checking if user exist with {}", email);
        Optional<AppUser> user = userRepo.findByUsername(email);
        if(user.isPresent()) {
            logger.error("User already exist with {}", email);
            throw new AlreadyExistException("User already exist with "+email, "check the username and try again");
        }
    }

    @Override
    public AppUser update(UserDto user) {
        UserDetails loggedInUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = loggedInUser.getUsername();
        logger.info("updating user {} ", username);

        AppUser oldUser = userRepo.findByUsername(username).orElseThrow(()-> new NotFoundException("User doesn't exist", "check the id and try again"));
        oldUser.setName(user.getName());
        oldUser.setUsername(user.getEmail());
        oldUser.getRoles().add(Role.valueOf(user.getRole()));
        oldUser.setUpdatedAt(LocalDateTime.now());
        return userRepo.save(oldUser);
    }

    @Override
    public void addRoleToUser(String userName, String role) {
        logger.info("adding role {} to user {} ", role, userName);

        AppUser user = getUser(userName);
        user.getRoles().add(Role.valueOf(role));
        userRepo.save(user);
    }

    @Override
    public AppUser getUser(String userName) {
        logger.info("fetching user {} ", userName);

        Optional<AppUser> user = userRepo.findByUsername(userName);
        return user.orElseThrow(()-> new NotFoundException("User doesn't exist", "check the username and try again"));
    }

    @Async
    @Override
    public CompletableFuture<List<AppUser>> findAllUsers() {
        logger.info("getting the list of all users by "+ Thread.currentThread().getName());
        List<AppUser> users = userRepo.findAll();
        return CompletableFuture.completedFuture(users);
    }


}
