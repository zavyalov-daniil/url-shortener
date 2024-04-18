package ai.leantech.urlshortener.feature.auth.service;

import ai.leantech.urlshortener.common.dto.AuthRequestDto;
import ai.leantech.urlshortener.common.dto.UserRegistrationRequestDto;
import ai.leantech.urlshortener.entity.ElasticUserEntity;
import ai.leantech.urlshortener.feature.auth.mapper.UserMapper;
import ai.leantech.urlshortener.feature.auth.repository.ElasticsearchUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final ElasticsearchUserRepository elasticsearchUserRepository;
    private final UserMapper userMapper;

    public void createUser(UserRegistrationRequestDto userDto) {
        ElasticUserEntity entity = userMapper.map(userDto);
        elasticsearchUserRepository.save(entity);
    }

    public String getToken(AuthRequestDto dto) {
        return "";
    }
}
