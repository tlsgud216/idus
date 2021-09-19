package com.idus.backend.member;

import com.idus.backend.common.Auditing;
import com.idus.backend.member.commonTypes.GenderTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Member extends Auditing implements UserDetails {
    @Id
    @GeneratedValue()
    Long id;

    @Column(nullable = false, unique = true)
    String loginId = null;

    @Column(nullable = false)
    String password = null;

    @Column(nullable = false, length = 20)
    String name = null;

    @Column(nullable = false, length = 30)
    String nickname = null;

    @Column(nullable = false, length = 20)
    String phone = null;

    @Column(nullable = false, length = 100)
    String email = null;

    @Enumerated(EnumType.STRING)
    GenderTypes gender;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<GrantedAuthority>();
    }

    @Override
    public String getPassword() { return this.password; }

    @Override
    public String getUsername() { return this.loginId; }

    @Override
    public boolean isAccountNonExpired() { return false; }

    @Override
    public boolean isAccountNonLocked() { return false; }

    @Override
    public boolean isCredentialsNonExpired() { return false; }

    @Override
    public boolean isEnabled() { return false; }
}
