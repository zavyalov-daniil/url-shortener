package ai.leantech.urlshortener.config;

import ai.leantech.urlshortener.feature.auth.entity.ElasticUserEntity;
import ai.leantech.urlshortener.feature.auth.repository.ElasticsearchUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final ElasticsearchUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ElasticUserEntity entity = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return UserDetailsImpl.build(entity);
    }
}
