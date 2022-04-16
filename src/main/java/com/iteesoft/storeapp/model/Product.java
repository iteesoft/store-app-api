package com.iteesoft.storeapp.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Base{

    private String name;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private String imageUrl;
}
