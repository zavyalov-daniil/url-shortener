package ai.leantech.urlshortener.feature.shortening.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "short_url")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElasticShortUrlEntity {
    @Id
    private String shortKey;
    private String originalUrl;
    private String creatorLogin;
    private Long expirationTimestamp;
    private List<String> permittedEmails;
}
