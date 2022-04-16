package com.iteesoft.storeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String productName;
    private String description;
    private BigDecimal price;
    private Long quantity;
    private String imageUrl;
    private String categoryName;
}
