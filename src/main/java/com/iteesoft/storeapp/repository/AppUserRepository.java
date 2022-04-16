package com.iteesoft.storeapp.repository;

import com.iteesoft.storeapp.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
