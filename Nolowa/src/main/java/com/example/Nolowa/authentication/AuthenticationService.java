package com.example.Nolowa.authentication;

import com.example.Nolowa.dataModels.ProfileImage;
import com.example.Nolowa.dataModels.User;
import com.sun.tools.javac.Main;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
