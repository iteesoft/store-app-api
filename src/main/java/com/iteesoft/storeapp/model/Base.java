package com.iteesoft.storeapp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
@Getter
@Setter
public class Base {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    protected LocalDateTime createdAt = LocalDateTime.now();
    protected LocalDateTime updatedAt;
}