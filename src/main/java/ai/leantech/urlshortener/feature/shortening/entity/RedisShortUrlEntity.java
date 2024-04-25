package ai.leantech.urlshortener.feature.shortening.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@RedisHash(value = "short_url", timeToLive = 86400L)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RedisShortUrlEntity implements Serializable {
    @Id
    private String shortKey;
    private String originalUrl;
    private String creatorLogin;
    private Long expirationTimestamp;
    private List<String> permittedEmails;
}
