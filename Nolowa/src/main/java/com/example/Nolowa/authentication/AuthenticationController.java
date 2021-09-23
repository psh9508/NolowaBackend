package com.example.Nolowa.authentication;

import com.example.Nolowa.dataModels.User;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.sun.istack.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Authentication")
public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/VerifyService")
    public boolean VerifyService() {
        return true;
    }

    @PostMapping("/Login")
    public User Login(@NotNull @RequestBody Map<String, String> param) {
        String id = param.get("id");
        String Password = param.get("password");

        return service.login(id, Password);
    }
}
