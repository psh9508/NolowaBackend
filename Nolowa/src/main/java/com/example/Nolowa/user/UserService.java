package com.example.Nolowa.user;

import com.example.Nolowa.dataModels.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        var user = userRepository.getById(id);

        return user;
    }

    public User getUser(String email) {
        var user = userRepository.findByEmail(email);

        return user.orElse(null);
    }

    public User Save(@NotNull User user) {
        var savedUser = userRepository.save(user);

        return savedUser;
    }
}
