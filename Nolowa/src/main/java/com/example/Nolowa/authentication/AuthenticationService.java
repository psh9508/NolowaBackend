package com.example.Nolowa.authentication;

import com.example.Nolowa.dataModels.User;
import com.sun.tools.javac.Main;
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

@Service
public class AuthenticationService {

    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(1L, "ab", new Date(), List.of(1L, 2L), "psh0258@gmail.com", GetBinaryProfileImage("1.jpg")));
        users.add(new User(2L, "ab", new Date(), List.of(1L, 2L), "Masuri@naver.com", GetBinaryProfileImage("2.jpg")));
        users.add(new User(3L, "ab", new Date(), List.of(1L, 2L),"Alice@gmail.com", GetBinaryProfileImage("3.jpg")));
        users.add(new User(4L, "ab", new Date(), List.of(1L, 2L), "Elena@gmail.com", GetBinaryProfileImage("4.jpg")));
        users.add(new User(5L, "a", new Date(), List.of(1L, 2L, 3L, 4L, 5L, 6L),"aa", GetBinaryProfileImage("5.png")));
    }

    private static byte[] GetBinaryProfileImage(String imageFileName) {
        ClassPathResource resource = new ClassPathResource("/profileImages/" + imageFileName);
        byte[] content = new byte[1024];
        try {
            content = Files.readAllBytes(resource.getFile().toPath());
        } catch (IOException e) {

        }

        return content;
    }

    public User getUser(Long id) {
        var user = users.stream().filter(x -> x.getId() == id).findFirst();
        return user.orElseGet(null);
    }

    public User login(String email, String password) {
        var user = users.stream().filter(x -> x.getEmail().equals(email) & x.getPassword().equals(password))
                                               .findFirst();

        return user.orElseGet(null);
    }

}
