package com.example.Nolowa.dataModels;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Follower {
    @Id @GeneratedValue
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "destination_user_id")
    @JsonIgnoreProperties({"followers"})
    private User followerUser;
}
