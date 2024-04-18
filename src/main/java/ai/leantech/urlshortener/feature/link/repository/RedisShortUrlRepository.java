package ai.leantech.urlshortener.feature.link.repository;

import ai.leantech.urlshortener.entity.RedisShortUrlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisShortUrlRepository extends CrudRepository<RedisShortUrlEntity, String> {
}
