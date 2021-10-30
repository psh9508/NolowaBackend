package com.example.Nolowa.post;

import com.example.Nolowa.authentication.AuthenticationService;
import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/VerifyService")
    public boolean VerifyService() {
        return true;
    }

    @GetMapping("/{id}/Followers")
    public List<Post> getFollowerPosts(@PathVariable Long id) {
        var user = userService.getUser(id);
        return postService.getFollowerPosts(user);
    }

    @GetMapping("/{id}/Posts")
    public List<Post> getPosts(@PathVariable Long id) {
        return postService.getPostByPostedUserId(id);
    }

    @PostMapping("/New")
    public Post save(@RequestBody Post post) {
        var uploadedPost = postService.save(post);

        return uploadedPost;
    }

}
