package ai.leantech.urlshortener.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "Key pull not found", code = HttpStatus.INTERNAL_SERVER_ERROR)
public class KeyPoolNotFoundException extends RuntimeException {
}
