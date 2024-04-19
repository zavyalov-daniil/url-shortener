package ai.leantech.urlshortener.feature.shortening.service;

import ai.leantech.urlshortener.common.dto.LongUrlRequestDto;
import ai.leantech.urlshortener.common.exception.LongUrlNotFoundException;
import ai.leantech.urlshortener.entity.ElasticShortUrlEntity;
import ai.leantech.urlshortener.entity.RedisShortUrlEntity;
import ai.leantech.urlshortener.feature.shortening.mapper.UrlMapper;
import ai.leantech.urlshortener.feature.shortening.repository.ElasticsearchUrlRepository;
import ai.leantech.urlshortener.feature.shortening.repository.RedisShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShortUrlService {
    @Value("${app.url}")
    private String APP_URL;
    private final RedisShortUrlRepository redisUrlRepository;
    private final ElasticsearchUrlRepository elasticsearchUrlRepository;
    private final UrlMapper urlMapper;

    public String createShortUrl(LongUrlRequestDto dto) {
        String shortKey = UUID.randomUUID().toString();

        ElasticShortUrlEntity elasticEntity = urlMapper.mapToElasticEntity(dto, shortKey, null);
        ElasticShortUrlEntity savedElasticEntity = elasticsearchUrlRepository.save(elasticEntity);

        RedisShortUrlEntity redisEntity = urlMapper.mapToRedisEntity(savedElasticEntity);
        redisUrlRepository.save(redisEntity);

        return APP_URL + "/" + shortKey;
    }

    public String getLongUrlByKey(String key) {
        Optional<RedisShortUrlEntity> optionalFromRedis = redisUrlRepository.findById(key);
        if (optionalFromRedis.isPresent()) {
            return optionalFromRedis.get().getOriginalUrl();
        }
        Optional<ElasticShortUrlEntity> optionalFromElastic = elasticsearchUrlRepository.findById(key);
        return optionalFromElastic
                .orElseThrow(LongUrlNotFoundException::new)
                .getOriginalUrl();
    }
}
