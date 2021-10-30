package com.example.Nolowa.authentication;

import com.example.Nolowa.Constant;
import com.example.Nolowa.Helpers.FileHelper;
import com.example.Nolowa.Helpers.LocalImageFileHelper;
import com.example.Nolowa.dataModels.User;
import com.example.Nolowa.user.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String email, String password) {
        var user = userRepository.findByEmailAndPassword(email, password);

        return user.orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
