package com.example.Nolowa.dataModels;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_user_id")
    private List<Follower> followers;

    private String email;

    @OneToOne()
    @JoinColumn(name = "profile_image_id")
    private ProfileImage profileImage;

    private String name;

    private String accountId;

    @Transient
    private String jwtToken;
}
