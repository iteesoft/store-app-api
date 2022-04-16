package com.iteesoft.storeapp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends Base{

    private String name;

    @OneToMany(cascade = ALL, fetch = EAGER)
    private List<Product> products = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }
}
