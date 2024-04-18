package ai.leantech.urlshortener.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "link")
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ElasticLink {
    @Id
    private String identifier;
    private String originalUrl;
}
