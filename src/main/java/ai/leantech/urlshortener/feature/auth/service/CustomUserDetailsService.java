package ai.leantech.urlshortener.feature.auth.service;

import ai.leantech.urlshortener.entity.ElasticUserEntity;
import ai.leantech.urlshortener.feature.auth.repository.ElasticsearchUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final ElasticsearchUserRepository userRepository;

    public CustomUserDetailsService(ElasticsearchUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ElasticUserEntity entity = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return new User(entity.getLogin(), entity.getPassword(), authorities);
    }
}
