package com.example.Nolowa.post;

import com.example.Nolowa.dataModels.Follower;
import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getFollowerPosts(User user) {
        var followerIds = new ArrayList<Long>();

        for (var follower : user.getFollows()) {
            followerIds.add(follower.getFollowId());
        }

        return getFollowerPosts(followerIds);
    }

    private List<Post> getFollowerPosts(List<Long> followerIds) {
        var followerPosts = new ArrayList<Post>();

        var followerPost = repository.findAllById(followerIds);
        followerPosts.addAll(followerPost);

        followerPosts.sort(Comparator.comparing(Post::getUploadedDate));

        return followerPosts;
    }

}

