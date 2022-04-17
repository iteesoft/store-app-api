package com.iteesoft.storeapp.model;

import com.iteesoft.storeapp.enums.Gender;
import com.iteesoft.storeapp.enums.Role;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser extends Base{

    private String name;
    private String email;
    private String password;

    @OneToOne
    private Wallet wallet;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
