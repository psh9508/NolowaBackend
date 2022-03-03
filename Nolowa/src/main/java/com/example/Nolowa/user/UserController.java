package com.example.Nolowa.user;

import com.example.Nolowa.dataModels.Follower;
import com.example.Nolowa.dataModels.User;
import com.example.Nolowa.dataModels.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/User")
public class UserController {

    private final UserService userService;
    private final FollowerRepository followerRepository;

    public UserController(UserService userService, FollowerRepository followerRepository) {
        this.userService = userService;
        this.followerRepository = followerRepository;
    }

    @PostMapping("/Save")
    public User Save(@RequestBody UserDTO user) throws Exception {
        // 1. 같은 유저가 있는지 확인
        var hasSameUser = userService.getUser(user.getEmail());

        //    -> 있으면 exception
        if(hasSameUser != null) {
            throw new Exception("같은 유저 있음");
        }

        // 2. 없으면 회원가입 후 가입된 유저 반환
        return userService.Save(user.ToEntity());
    }

    @PostMapping("/Follow/{followerUserId}/{followeeUserId}")
    public boolean Follow(@PathVariable long followerUserId, @PathVariable long followeeUserId) {
        Follower newFollower = new Follower();
        newFollower.setUser(userService.getUser(followerUserId));
        newFollower.setFollowerUser(userService.getUser(followeeUserId));

        var response = followerRepository.save(newFollower);

        return response != null;
    }
}
