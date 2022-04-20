package com.iteesoft.storeapp.model;

import com.iteesoft.storeapp.enums.Gender;
import com.iteesoft.storeapp.enums.Role;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.GenerationType.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser extends Base implements UserDetails {

    private String name;
    private String username;
    private String password;
    private String phoneNumber;

    @OneToOne
    private Wallet wallet;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles")
    @Column(name = "roles", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Role> roles = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> authorities = new ArrayList<>();
        this.getRoles().forEach(role -> {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(String.valueOf(role));
            authorities.add(authority);
        });

        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
