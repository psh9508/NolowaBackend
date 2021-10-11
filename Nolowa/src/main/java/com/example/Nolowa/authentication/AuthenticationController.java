package com.example.Nolowa.authentication;

import com.example.Nolowa.dataModels.User;
import com.sun.istack.NotNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/Authentication")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationManager authenticationManager, AuthenticationService service) {
        this.authenticationManager = authenticationManager;
        this.service = service;
    }

    @GetMapping("/VerifyService")
    public boolean VerifyService() {
        return true;
    }

    @PostMapping("/Login")
    public User Login(@NotNull @RequestBody Map<String, String> param, HttpSession session) throws Exception {
        String id = param.get("id");
        String password = param.get("password");

        SetToken(id, password, session);

        return service.login(id, password);
    }

    private void SetToken(String id, String Password, HttpSession session) {
        var token = new UsernamePasswordAuthenticationToken(id, Password);
        var authentication = authenticationManager.authenticate(token);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
    }


}
