package ai.leantech.urlshortener.repository;

import ai.leantech.urlshortener.entity.LinkEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepository extends CrudRepository<LinkEntity, String> {
}
