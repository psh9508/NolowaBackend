package com.example.Nolowa.authentication;

import com.fasterxml.jackson.databind.util.ClassUtil;
import com.sun.istack.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthenticationController {

    private final String parentEndPoint = "/Authentication";
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping(parentEndPoint + "/VerifyService")
    public boolean VerifyService() {
        return true;
    }

    @PostMapping(parentEndPoint + "/Login")
    public boolean Login(@NotNull @RequestBody Map<String, String> param) {

        String id = param.get("id");
        String Password = param.get("password");

        return service.login(id, Password);
    }
}
