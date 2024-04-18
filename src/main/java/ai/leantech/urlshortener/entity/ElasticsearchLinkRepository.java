package ai.leantech.urlshortener.entity;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticsearchLinkRepository extends ElasticsearchRepository<ElasticLink, String> {
}
