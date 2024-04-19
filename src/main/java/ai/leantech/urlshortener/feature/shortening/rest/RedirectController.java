package ai.leantech.urlshortener.feature.shortening.rest;

import ai.leantech.urlshortener.feature.shortening.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class RedirectController {
    private final ShortUrlService service;

    @GetMapping("/{short_key}")
    public String getContentByShortLink(@PathVariable("short_key") String key) {
        String longUrl = service.getLongUrlByKey(key);
        return "redirect:" + longUrl;
    }
}
