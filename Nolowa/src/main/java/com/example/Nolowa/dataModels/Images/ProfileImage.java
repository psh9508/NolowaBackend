package com.example.Nolowa.dataModels.Images;

import com.example.Nolowa.dataModels.NolowaImage;
import com.example.Nolowa.dataModels.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class ProfileImage extends NolowaImage {
    public void setDefaultProfileImage() {
        hash = "ProfilePicture";
    }
}
