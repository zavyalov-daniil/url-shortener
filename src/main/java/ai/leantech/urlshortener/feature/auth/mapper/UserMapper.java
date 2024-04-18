package ai.leantech.urlshortener.feature.auth.mapper;

import ai.leantech.urlshortener.common.dto.UserRegistrationRequestDto;
import ai.leantech.urlshortener.entity.ElasticUserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "Spring")
public interface UserMapper {
    @Mapping(target = "uid", expression = "java(this.createRandomUuid())")
    ElasticUserEntity map(UserRegistrationRequestDto dto);

    default UUID createRandomUuid() {
        return UUID.randomUUID();
    }
}
