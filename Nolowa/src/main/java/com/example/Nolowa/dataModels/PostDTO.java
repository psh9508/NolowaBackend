package com.example.Nolowa.dataModels;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDTO {
    private Long id;
    private UserDTO postedUser;
    private String message;

    public Post toEntity() {
        return Post.builder()
                .postId(id)
                .postedUser(postedUser.ToEntity())
                .message(message)
                .build();
    }
}
