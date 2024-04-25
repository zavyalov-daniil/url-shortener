package ai.leantech.urlshortener.common.utils;

import org.springframework.beans.factory.annotation.Value;

public class AppConstants {
    @Value("&{app.url.key_pull}")
    private String KEY_PULL;


}
