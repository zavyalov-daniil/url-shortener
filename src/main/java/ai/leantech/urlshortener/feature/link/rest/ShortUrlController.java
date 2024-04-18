package ai.leantech.urlshortener.feature.link.rest;

import ai.leantech.urlshortener.entity.ElasticShortUrlEntity;
import ai.leantech.urlshortener.feature.link.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/shortener/url")
@RequiredArgsConstructor
public class ShortUrlController {
    private final ShortUrlService service;

    @GetMapping("/{id}")
    public ElasticShortUrlEntity get(@PathVariable("id") String id) {
        return elasticsearchLinkRepository.findById(id).orElse(null);//repository.findById(id).orElse(null);
    }

    @PostMapping
    //@Cacheable(cacheNames = "Link", key = "#entity.identifier")
    public ElasticShortUrlEntity post(@RequestBody ElasticShortUrlEntity entity) {
        return elasticsearchLinkRepository.save(entity);//repository.save(entity);
    }
}
