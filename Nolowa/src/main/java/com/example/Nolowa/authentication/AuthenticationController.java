package com.example.Nolowa.authentication;

import com.example.Nolowa.Helpers.ProfileImageHelper;
import com.example.Nolowa.account.AccountService;
import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.example.Nolowa.dataModels.User;
import com.example.Nolowa.dataModels.oauth.google.OAuthGoogleRequest;
import com.example.Nolowa.dataModels.oauth.google.OAuthGoogleResponse;
import com.example.Nolowa.jwt.JwtTokenProvider;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/VerifyService")
    public boolean VerifyService() {
        return true;
    }

    @GetMapping("/GetSubject")
    public String GetSubjectFromJWT(@RequestParam("token") String token) {
        String subject = jwtTokenProvider.extractUsername(token);

        return subject;
    }

    @PostMapping("/Login")
    public User Login(@NotNull @RequestBody Map<String, String> param) {
        String id = param.get("id");
        String password = param.get("password");

        var account = authenticationService.login(id, password);

        if(account == null)
            return null;

        ProfileImageHelper.setDefaultProfileFile(account);

        account.setJwtToken(jwtTokenProvider.generateToken(account.getEmail()));
        
        return account;
    }
}
