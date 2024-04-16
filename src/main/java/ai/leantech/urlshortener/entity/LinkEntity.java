package ai.leantech.urlshortener.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash(value = "Link", timeToLive = 15L)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LinkEntity implements Serializable {
    @Id
    private String identifier;
    private String originalUrl;
}
