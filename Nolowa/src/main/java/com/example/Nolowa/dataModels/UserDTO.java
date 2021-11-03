package com.example.Nolowa.dataModels;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.example.Nolowa.dataModels.Images.ProfileImageDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String password;
    private LocalDateTime joinDate;
    private String email;
    private ProfileImageDTO profileImage;
    private String name;
    private String accountId;

    public User ToEntity() {
        var profileImage = new ProfileImage();
        profileImage.setId(this.profileImage.getId());
        profileImage.setUrl(this.profileImage.getUrl());
        profileImage.setHash(this.profileImage.getHash());

        return User.builder()
                .id(id)
                .email(email)
                .password(password)
                .profileImage(profileImage)
                .build();
    }
}
