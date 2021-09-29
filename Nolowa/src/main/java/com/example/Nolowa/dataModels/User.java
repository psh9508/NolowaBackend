package com.example.Nolowa.dataModels;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private LocalDateTime joinDate;

    @OneToMany
    @JoinColumn(name = "follow_user_Id")
    private List<Follower> followers;
    private String email;
    @OneToOne
    @JoinColumn(name = "profile_image_id")
    private ProfileImage profileImage;

    @Transient
    private List<Post> posts;
}
