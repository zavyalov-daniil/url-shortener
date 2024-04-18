package ai.leantech.urlshortener.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;
import java.util.UUID;

@Document(indexName = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElasticUserEntity {
    @Id
    private UUID uid;
    private String login;
    private String password;
}
