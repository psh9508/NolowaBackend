package com.example.Nolowa.dataModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private Long userId;

    private String message;

    private LocalDateTime uploadedDate;
}

