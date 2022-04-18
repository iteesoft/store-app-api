package com.iteesoft.storeapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store extends Base{
    private String name;
    private String address;
    private String logoUrl;
    @OneToOne
    private AppUser storeOwner;

    @OneToMany
    private List<AppUser> staffList;

    @OneToMany
    private List<Product> products;
}
