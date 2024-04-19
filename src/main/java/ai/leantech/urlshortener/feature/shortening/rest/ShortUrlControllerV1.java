package ai.leantech.urlshortener.feature.shortening.rest;

import ai.leantech.urlshortener.common.dto.LongUrlRequestDto;
import ai.leantech.urlshortener.feature.shortening.service.ShortUrlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/shortener/url")
@RequiredArgsConstructor
public class ShortUrlControllerV1 {
    private final ShortUrlService service;

    @PostMapping
    public String createUrl(@RequestBody @Valid LongUrlRequestDto dto) {
        return service.createShortUrl(dto);
    }
}
