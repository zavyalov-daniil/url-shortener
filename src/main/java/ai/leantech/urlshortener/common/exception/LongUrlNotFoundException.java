package ai.leantech.urlshortener.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Long url not found", code = HttpStatus.NOT_FOUND)
public class LongUrlNotFoundException extends RuntimeException {
}
