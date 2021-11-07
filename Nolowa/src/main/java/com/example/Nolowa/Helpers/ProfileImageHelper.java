package com.example.Nolowa.Helpers;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.User;

import java.util.List;

public class ProfileImageHelper {
    public static void setDefaultProfileFile(User src) {
        if(src.getProfileImage() == null)
            setDefaultProfileFileModel(src);
    }

    public static void setDefaultProfileFile(List<Post> src) {
        src.stream().filter(x -> x.getPostedUser().getProfileImage() == null).forEach(x -> {
            setDefaultProfileFileModel(x.getPostedUser());
        });
    }

    private static void setDefaultProfileFileModel(User src) {
        var profileImage = new ProfileImage();
        profileImage.setDefaultProfileImage();

        src.setProfileImage(profileImage);
    }
}
