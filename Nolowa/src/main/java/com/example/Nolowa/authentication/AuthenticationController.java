package com.example.Nolowa.authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final String parentEndPoint = "/Authentication";

    @GetMapping(parentEndPoint + "/VerifyService")
    public boolean VerifyService() {
        return true;
    }

    @GetMapping(parentEndPoint + "/Login")
    public boolean Login(String id, String password) {
        return true;
    }
}
