package com.example.Nolowa.post;

import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getFollowerPosts(@NotNull User user) {
        var followerIds = new ArrayList<Long>();

        for (var follower : user.getFollowers()) {
            followerIds.add(follower.getFollowerUser().getId());
        }
        
        return getFollowerPosts(followerIds);
    }

    private List<Post> getFollowerPosts(List<Long> followerIds) {
        var followerPosts = repository.findAllByPostedUserIds(followerIds);
        followerPosts.sort(Comparator.comparing(Post::getUploadedDate));

        return followerPosts;
    }

}

