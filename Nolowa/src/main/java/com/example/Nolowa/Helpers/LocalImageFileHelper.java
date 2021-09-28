package com.example.Nolowa.Helpers;

import com.example.Nolowa.Constant;

import java.io.File;

public class LocalImageFileHelper {

    public static File getProfileImageFile(String name) {
        var fullPath = Constant.profileImageRootPath + name + ".jpg";

        return new File(fullPath);
    }
}
