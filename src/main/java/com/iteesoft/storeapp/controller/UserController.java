package com.iteesoft.storeapp.controller;

import com.iteesoft.storeapp.dto.UserDto;
import com.iteesoft.storeapp.model.AppUser;
import com.iteesoft.storeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.concurrent.CompletableFuture;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody @Valid UserDto user) {
        var savedUser = userService.save(user);
        URI uri = URI.create(String.format("/api/v1/users/%s",savedUser.getId()));
//        return ResponseEntity.created(uri).build();
        return ResponseEntity.created(uri).body(savedUser);
    }

    @PutMapping("/update")
    public ResponseEntity<AppUser> update(@RequestBody @Valid UserDto user) {
        return new ResponseEntity<>(userService.update(user), OK);
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<?>> getAllUsers() {
        return userService.findAllUsers().thenApply(ResponseEntity::ok);
    }
}
