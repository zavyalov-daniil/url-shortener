package ai.leantech.urlshortener.feature.auth.rest;

import ai.leantech.urlshortener.common.dto.AuthRequestDto;
import ai.leantech.urlshortener.common.dto.TokenResponseDto;
import ai.leantech.urlshortener.common.dto.UserRegistrationRequestDto;
import ai.leantech.urlshortener.feature.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/shortener/auth")
@RequiredArgsConstructor
public class AuthControllerV1 {
    private final AuthService authService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public void registration(@RequestBody @Valid UserRegistrationRequestDto requestDto) {
        authService.createUser(requestDto);
    }

    @PostMapping
    public TokenResponseDto login(@RequestBody @Valid AuthRequestDto requestDto) {
        return authService.getToken(requestDto);
    }
}
