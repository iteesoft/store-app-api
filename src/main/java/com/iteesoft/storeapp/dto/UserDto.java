package com.iteesoft.storeapp.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {
    @NotNull(message = "name should not be null")
    private String name;

    @Email(message = "email should be valid")
    @NotNull(message = "email should not be null")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "password should be at least 8 characters and contain at least one digit, one uppercase letter, one lowercase letter, one special character and no whitespace")
    private String password;

    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "phone number should be 10 digits")
    private String phoneNumber;
    private String role;
}
