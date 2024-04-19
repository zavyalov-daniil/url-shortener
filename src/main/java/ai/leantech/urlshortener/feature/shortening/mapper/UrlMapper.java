package ai.leantech.urlshortener.feature.shortening.mapper;

import ai.leantech.urlshortener.common.dto.LongUrlRequestDto;
import ai.leantech.urlshortener.entity.ElasticShortUrlEntity;
import ai.leantech.urlshortener.entity.RedisShortUrlEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface UrlMapper {

    @Mapping(target = "originalUrl", source = "dto.longUrl")
    ElasticShortUrlEntity mapToElasticEntity(LongUrlRequestDto dto, String shortKey, String creatorLogin);

    RedisShortUrlEntity mapToRedisEntity(ElasticShortUrlEntity elasticEntity);
}
