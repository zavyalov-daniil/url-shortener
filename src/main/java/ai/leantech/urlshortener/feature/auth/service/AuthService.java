package ai.leantech.urlshortener.feature.auth.service;

import ai.leantech.urlshortener.common.dto.AuthRequestDto;
import ai.leantech.urlshortener.common.dto.TokenResponseDto;
import ai.leantech.urlshortener.common.dto.UserRegistrationRequestDto;
import ai.leantech.urlshortener.config.JWTTokenManager;
import ai.leantech.urlshortener.config.UserDetailsImpl;
import ai.leantech.urlshortener.feature.auth.entity.ElasticUserEntity;
import ai.leantech.urlshortener.feature.auth.mapper.UserMapper;
import ai.leantech.urlshortener.feature.auth.repository.ElasticsearchUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final ElasticsearchUserRepository elasticsearchUserRepository;
    private final UserMapper userMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder encoder;
    private final JWTTokenManager jwtTokenManager;

    public void createUser(UserRegistrationRequestDto userDto) {
        ElasticUserEntity entity = userMapper.map(userDto);
        entity.setPassword(encoder.encode(userDto.getPassword()));
        elasticsearchUserRepository.save(entity);
    }

    public TokenResponseDto getToken(AuthRequestDto dto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword()));

        SecurityContextHolder.getContext()
                .setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String jwt = jwtTokenManager.generateJwtToken(authentication);

        return new TokenResponseDto(jwt);
    }
}
