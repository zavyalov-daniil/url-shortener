package ai.leantech.urlshortener.feature.auth.repository;

import ai.leantech.urlshortener.entity.ElasticUserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElasticsearchUserRepository extends ElasticsearchRepository<ElasticUserEntity, String> {
}
