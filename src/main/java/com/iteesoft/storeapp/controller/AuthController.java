package com.iteesoft.storeapp.controller;

import com.iteesoft.storeapp.payload.AuthRequest;
import com.iteesoft.storeapp.payload.AuthResponse;
import com.iteesoft.storeapp.security.JWTProvider;
import com.iteesoft.storeapp.service.impl.CustomUserDetailService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    private final JWTProvider jwtTokenUtil;
    private final CustomUserDetailService jwtUserDetailsService;
    private final AuthenticationManager authenticationManager;


    @Operation(summary = "Validate User credentials to authenticate login and generate token")
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> authenticateUser(@RequestBody AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken userToken =
                new UsernamePasswordAuthenticationToken(authRequest.getUsernameOrEmail(), authRequest.getPassword());
        try {
            authenticationManager.authenticate(userToken);
        } catch (BadCredentialsException e) {
            logger.error("Invalid credentials", e);
            throw e;
        }

        final UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(authRequest.getUsernameOrEmail());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}