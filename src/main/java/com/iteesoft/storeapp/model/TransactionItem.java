package com.iteesoft.storeapp.model;

import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionItem extends Base {

    private String productName;
    private int quantity;
    private BigDecimal price;
}
