package com.example.Nolowa.post;

import com.example.Nolowa.authentication.AuthenticationService;
import com.example.Nolowa.dataModels.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Post")
public class PostController {

    private final PostService postService;
    private final AuthenticationService authenticationService;

    public PostController(PostService postService, AuthenticationService authenticationService) {
        this.postService = postService;
        this.authenticationService = authenticationService;
    }

    @GetMapping("/VerifyService")
    public boolean VerifyService() {
        return true;
    }

    @GetMapping("/{id}/Followers")
    public List<Post> getFollowerPosts(@PathVariable Long id) {
        var user = authenticationService.getUser(id);
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
