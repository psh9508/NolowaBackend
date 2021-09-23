package com.example.Nolowa.post;

import com.example.Nolowa.authentication.AuthenticationService;
import com.example.Nolowa.dataModels.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Post> getFollwerPosts(@PathVariable Long id) {
        var user = authenticationService.getUser(id);
        return postService.getFollowerPosts(user);
    }
}
