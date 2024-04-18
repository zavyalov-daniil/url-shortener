package ai.leantech.urlshortener.feature.link.repository;

import ai.leantech.urlshortener.entity.ElasticShortUrlEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticsearchUrlRepository extends ElasticsearchRepository<ElasticShortUrlEntity, String> {
}
