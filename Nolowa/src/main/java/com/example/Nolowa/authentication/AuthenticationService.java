package com.example.Nolowa.authentication;

import com.example.Nolowa.dataModels.ProfileImage;
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
import java.util.Optional;

@Service
public class AuthenticationService {

    private static List<User> users = new ArrayList<>();
    private static List<ProfileImage> profileImages = new ArrayList<>();

    static {
        users.add(new User(1L, "ab", new Date(), List.of(1L, 2L, 3L, 4L, 5L, 6L), "psh0258@gmail.com", null));
        users.add(new User(2L, "ab", new Date(), List.of(1L, 2L), "Masuri@naver.com", null));
        users.add(new User(3L, "ab", new Date(), List.of(1L, 2L),"Alice@gmail.com", null));
        users.add(new User(4L, "ab", new Date(), List.of(1L, 2L), "Elena@gmail.com", null));
        users.add(new User(5L, "a", new Date(), List.of(1L, 2L),"aa", null));

        profileImages.add(new ProfileImage(1L, 1L, "asdf","asdf"));
        profileImages.add(new ProfileImage(1L, 2L, "1111","111asdf"));
        profileImages.add(new ProfileImage(1L, 3L, "222asdf","222asdf"));
    }

    public User getUser(Long id) {
        var optionalUser = users.stream().filter(x -> x.getId().equals(id)).findFirst();

        if(optionalUser.isPresent() == false)
            return null;

        var user = optionalUser.get();
        user.setProfileImage(getProfileImage(user.getId()));

        return user;
    }

    public User login(String email, String password) {
        var user = users.stream().filter(x -> x.getEmail().equals(email) & x.getPassword().equals(password))
                                               .findFirst();

        return user.orElse(null);
    }

    private ProfileImage getProfileImage(Long id) {

        var profileImage = profileImages.stream().filter(x -> x.getId() == id).findFirst();

        return profileImage.orElse(null);
    }

}
