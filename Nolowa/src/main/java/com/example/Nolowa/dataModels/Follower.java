package com.example.Nolowa.dataModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Follower {
    @Id @GeneratedValue
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Long userId;

    private Long followId;
}
