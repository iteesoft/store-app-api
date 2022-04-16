package com.iteesoft.storeapp.model;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report extends Base{

    @OneToMany
    private List<Transaction> transactions;
}
