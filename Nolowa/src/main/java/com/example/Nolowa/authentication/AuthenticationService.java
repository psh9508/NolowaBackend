package com.example.Nolowa.authentication;

import com.example.Nolowa.Constant;
import com.example.Nolowa.Helpers.FileHelper;
import com.example.Nolowa.Helpers.LocalImageFileHelper;
import com.example.Nolowa.dataModels.User;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final AuthenticationRepository repository;

    public AuthenticationService(AuthenticationRepository repository) {
        this.repository = repository;
    }

    public User getUser(Long id) {
        var user = repository.getById(id);

        return user;
    }

    public User login(String email, String password) {
        var user = repository.findByEmailAndPassword(email, password);

        return user.orElse(null);
    }
}
