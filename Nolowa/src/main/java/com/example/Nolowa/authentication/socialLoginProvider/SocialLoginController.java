package com.example.Nolowa.authentication.socialLoginProvider;

import com.example.Nolowa.dataModels.oauth.google.OAuthGoogleRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/Authentication/Social")
public class SocialLoginController {

    @GetMapping("/Google/CodeCallback")
    public void googleTokenCallback(@RequestParam(value = "code") String authCode, @Value("${google.client-id}") String clientId, @Value("${google.secret}") String secret) {
        var oAuthGoogleRequest = OAuthGoogleRequest
                .builder()
                .clientId(clientId)
                .clientSecret(secret)
                .code(authCode)
                .redirectUri("https://localhost:8080/Authentication/Login/GoogleCode")
                .grantType("authorization_code").build();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> apiResponse = restTemplate.postForEntity("https://www.googleapis.com/oauth2/v4/token", oAuthGoogleRequest, String.class);
    }

    @GetMapping("/Google/TokenCallback")
    public void getAccessToken() {

    }
}
