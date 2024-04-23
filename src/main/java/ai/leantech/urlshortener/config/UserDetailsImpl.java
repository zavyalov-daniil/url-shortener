package ai.leantech.urlshortener.config;

import ai.leantech.urlshortener.entity.ElasticUserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private UUID id;
    @Getter
    private String username;

    @JsonIgnore
    @Getter
    private String password;

    public UserDetailsImpl(UUID id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public static UserDetailsImpl build(ElasticUserEntity user) {

        return new UserDetailsImpl(user.getUid(), user.getLogin(), user.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
