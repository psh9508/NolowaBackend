package com.example.Nolowa.user;

import com.example.Nolowa.dataModels.Follower;
import com.example.Nolowa.dataModels.User;

import java.util.List;

public class FollowerService {

    private final FollowerRepository repository;

    public FollowerService(FollowerRepository followerRepository) {
        this.repository = followerRepository;
    }

    public List<Follower> getFollower(User user) {

        //return repository.getBysource_user_id()

    }
}
