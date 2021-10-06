package com.example.Nolowa.dataModels.Images;

import com.example.Nolowa.dataModels.NolowaImage;
import com.example.Nolowa.dataModels.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class ProfileImage extends NolowaImage {
}
