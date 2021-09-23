package com.example.Nolowa.dataModels;

import lombok.*;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Follower {
    @Id
    private Long id;

    private Long userId;

    private Long followId;
}
