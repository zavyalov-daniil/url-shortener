package ai.leantech.urlshortener.feature.shortening.repository;

import ai.leantech.urlshortener.feature.shortening.entity.RedisKeyPoolEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisKeyPoolRepository extends CrudRepository<RedisKeyPoolEntity, String> {
}
