package ai.leantech.urlshortener.feature.shortening.service;

import ai.leantech.urlshortener.common.exception.KeyPoolNotFoundException;
import ai.leantech.urlshortener.common.utils.RandomStringUtil;
import ai.leantech.urlshortener.feature.shortening.entity.RedisKeyPoolEntity;
import ai.leantech.urlshortener.feature.shortening.repository.ElasticsearchUrlRepository;
import ai.leantech.urlshortener.feature.shortening.repository.RedisKeyPoolRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class KeyService {
    @Value("${app.url.pool}")
    private String keysPoolId;
    @Value("${app.url.pool.size}")
    private Integer keyPoolSize;
    @Value("${app.url.pool.regenerate}")
    private Integer regenerateLength;
    @Value("${app.url.length}")
    private Integer keyLength;
    private final RandomStringUtil randomStringUtil;
    private final ElasticsearchUrlRepository elasticsearchUrlRepository;
    private final RedisKeyPoolRepository redisKeyPoolRepository;

    @PostConstruct
    @Async
    public void generateNewPool() {
        HashSet<String> newKeyPool = new HashSet<>();
        for (int i = 0; i < keyPoolSize; i++) {
            newKeyPool.add(randomStringUtil.nextRandomKey(keyLength));
        }
        RedisKeyPoolEntity newPoolEntity = new RedisKeyPoolEntity(keysPoolId, newKeyPool);
        redisKeyPoolRepository.save(newPoolEntity);
    }

    public String getRandomKey() { //TODO: add random key
        RedisKeyPoolEntity entity = redisKeyPoolRepository.findById(keysPoolId)
                .orElseThrow(KeyPoolNotFoundException::new);
        Set<String> pool = entity.getKeys();

        if (pool.size() <= regenerateLength) {
            generateNewPool();
        }

        String key = pool.stream().findFirst().get();//TODO
        pool.remove(key);
        entity.setKeys(pool);
        redisKeyPoolRepository.save(entity);
        return key; 
    }
}
