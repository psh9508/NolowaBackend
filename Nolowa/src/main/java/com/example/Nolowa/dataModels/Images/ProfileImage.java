package com.example.Nolowa.dataModels.Images;

import com.example.Nolowa.dataModels.NolowaImage;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfileImage extends NolowaImage {
    @Id
    private Long id;
}
