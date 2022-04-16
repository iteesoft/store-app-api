package com.iteesoft.storeapp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Wallet extends Base{

    private BigDecimal balance;
}
