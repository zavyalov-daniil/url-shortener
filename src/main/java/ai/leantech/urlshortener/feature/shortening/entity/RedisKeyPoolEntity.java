package ai.leantech.urlshortener.feature.shortening.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.util.Set;

@RedisHash(value = "key_pull")
@Data
@AllArgsConstructor
public class RedisKeyPoolEntity {
    String id;
    Set<String> keys;
}
