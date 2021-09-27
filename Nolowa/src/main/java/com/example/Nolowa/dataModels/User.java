package com.example.Nolowa.dataModels;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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

    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private LocalDateTime joinDate;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Follower> followers;
    private String email;
    @OneToOne
    @JoinColumn(name = "id")
    private ProfileImage profileImage;
}
