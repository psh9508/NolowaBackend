package com.example.Nolowa.dataModels;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfileImage {

    @Id
    private long id;

    private long userId;

    private String uri;

    private String hash;
}
