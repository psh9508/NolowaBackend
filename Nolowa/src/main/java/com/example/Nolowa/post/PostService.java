package com.example.Nolowa.post;

import com.example.Nolowa.dataModels.Images.ProfileImage;
import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.PostDTO;
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

        followerIds.add(user.getId());

        for (var follower : user.getFollowers()) {
            followerIds.add(follower.getFollowerUser().getId());
        }
        
        return getFollowerPosts(followerIds);
    }

    public List<Post> getPostByPostedUserId(Long postedUserId) {
        var posts = repository.findAllByPostedUserId(postedUserId);

        return posts;
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    private List<Post> getFollowerPosts(List<Long> followerIds) {
        var followerPosts = repository.findAllByPostedUserIds(followerIds);

//        followerPosts.stream().filter(x -> x.getPostedUser().getProfileImage() == null).forEach(x -> {
//            String defaultProfileImageName = "ProfilePicture";
//
//            var profileImage = new ProfileImage();
//            profileImage.setHash(defaultProfileImageName);
//
//            x.getPostedUser().setProfileImage(profileImage);
//        });

        followerPosts.sort(Comparator.comparing(Post::getUploadedDateTime, Comparator.reverseOrder()));

        return followerPosts;
    }
}

