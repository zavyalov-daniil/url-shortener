package ai.leantech.urlshortener.feature.auth.repository;

import ai.leantech.urlshortener.entity.ElasticUserEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElasticsearchUserRepository extends ElasticsearchRepository<ElasticUserEntity, String> {
    Optional<ElasticUserEntity> findByLogin(String login);
}
