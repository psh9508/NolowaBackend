package com.example.Nolowa.dataModels;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post {

    @Id @GeneratedValue
    @JsonIgnore
    private Long postId;

    private String name;

    private String userAccountId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User postedUser;

    private String message;

    private LocalDateTime uploadedDate;
}

