package com.example.Nolowa.dataModels;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    private String password;
    private LocalDateTime joinDate;
    private String email;
    private ProfileImage profileImage;
    private String name;
    private String accountId;

    public User ToEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
