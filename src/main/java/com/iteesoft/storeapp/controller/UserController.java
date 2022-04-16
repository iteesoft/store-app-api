package com.iteesoft.storeapp.controller;

import com.iteesoft.storeapp.dto.UserDto;
import com.iteesoft.storeapp.model.AppUser;
import com.iteesoft.storeapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/new")
    public ResponseEntity<AppUser> register(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.save(user), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUser> update(@PathVariable("id") Long id, @RequestBody UserDto user) {
        return new ResponseEntity<>(userService.update(id, user), OK);
    }
}
