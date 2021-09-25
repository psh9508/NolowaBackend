package com.example.Nolowa.dataModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
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
    private LocalDateTime  joinDate;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Follower> follows;
    private String email;
    //private ProfileImage profileImage;
}
