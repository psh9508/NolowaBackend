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

    public User login(String email, String password) throws IOException {
        var user = repository.findByEmailAndPassword(email, password);

        if(user.isPresent() == false) {
            return null;
        }

        var profileImageInfo = user.get().getProfileImage();
        var profileImageHash = profileImageInfo.getHash();
        var profileImageFile = LocalImageFileHelper.getProfileImageFile(profileImageHash);

        if(profileImageFile.exists() == false) {
            var fileDownloadResult = FileHelper.downloadFileFromURL(Constant.profileImageRootPath + profileImageHash + ".jpg", profileImageInfo.getUrl());

            if(fileDownloadResult) {
              // Log
            } else {
              // Log
              // When It's failed, show default profile image
            }
        }

        return user.get();
    }
}
