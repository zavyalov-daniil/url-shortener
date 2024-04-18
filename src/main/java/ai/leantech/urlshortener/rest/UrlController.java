package ai.leantech.urlshortener.rest;

import ai.leantech.urlshortener.entity.ElasticLink;
import ai.leantech.urlshortener.entity.ElasticsearchLinkRepository;
import ai.leantech.urlshortener.entity.LinkEntity;
import ai.leantech.urlshortener.repository.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UrlController {
    private final RedisRepository repository;
    private final ElasticsearchLinkRepository elasticsearchLinkRepository;

    @GetMapping("/{id}")
    public ElasticLink get(@PathVariable("id") String id) {
        return elasticsearchLinkRepository.findById(id).orElse(null);//repository.findById(id).orElse(null);
    }

    @PostMapping
    //@Cacheable(cacheNames = "Link", key = "#entity.identifier")
    public ElasticLink post(@RequestBody ElasticLink entity) {
        return elasticsearchLinkRepository.save(entity);//repository.save(entity);
    }
}
