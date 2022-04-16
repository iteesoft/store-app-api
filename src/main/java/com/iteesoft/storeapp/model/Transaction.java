package com.iteesoft.storeapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends Base{

    @OneToMany
    private List<TransactionItem> items;
    private BigDecimal totalAmount;
}
