package com.example.Nolowa.authentication.socialLoginProvider;

import com.example.Nolowa.dataModels.oauth.google.GoogleUserInfo;
import com.example.Nolowa.dataModels.oauth.google.OAuthGoogleRequest;
import com.example.Nolowa.dataModels.oauth.google.OAuthGoogleResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/Authentication/Social")
public class SocialLoginController {

    @GetMapping("/Google/Callback")
    public void googleTokenCallback(@RequestParam(value = "code") String authCode, @Value("${google.client-id}") String clientId, @Value("${google.secret}") String secret) {
        var oAuthGoogleRequest = OAuthGoogleRequest
                .builder()
                .clientId(clientId)
                .clientSecret(secret)
                .code(authCode)
                .redirectUri("http://localhost:8080/Authentication/Social/Google/Callback")
                .grantType("authorization_code").build();

        var webClient = WebClient.create();
        var tokenResponse = webClient.post().uri("https://oauth2.googleapis.com/token")
                                                        .bodyValue(oAuthGoogleRequest)
                                                        .retrieve()
                                                        .bodyToMono(OAuthGoogleResponse.class)
//                                                        .subscribe()
                                                        .block();

        String jwtToken = tokenResponse.getIdToken();
        String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
                                                .queryParam("id_token", jwtToken).toUriString();

        var userInfoResponse = webClient.get().uri(requestUrl).retrieve().bodyToMono(GoogleUserInfo.class).block();
    }
}
