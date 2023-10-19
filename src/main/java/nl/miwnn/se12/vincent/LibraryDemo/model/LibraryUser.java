package nl.miwnn.se12.vincent.LibraryDemo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 * Anyone who can log in to the system
 */
@Entity
@Getter @Setter
public class LibraryUser implements UserDetails {

    @Id @GeneratedValue
    private Long userId;

    @Column(unique = true)
    private String username;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();

        authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorityList;
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
