package com.example.Nolowa.dataModels;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    private Long id;

    private String message;

    private LocalDateTime uploadedDate;
}

