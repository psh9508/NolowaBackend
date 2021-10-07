package com.example.Nolowa.dataModels;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Post {

    @Id @GeneratedValue
    @JsonIgnore
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User postedUser;

    private String message;

    private LocalDateTime uploadedDateTime;
}

