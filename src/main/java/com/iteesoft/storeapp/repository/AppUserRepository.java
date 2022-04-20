package com.iteesoft.storeapp.repository;

import com.iteesoft.storeapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);

//    Optional<AppUser> findByEmail(String email);
}
