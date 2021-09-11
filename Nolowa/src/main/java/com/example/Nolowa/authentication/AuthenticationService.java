package com.example.Nolowa.authentication;

import com.example.Nolowa.dataModels.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuthenticationService {

    private static List<User> users = new ArrayList<User>();

    static {
        users.add(new User(1L, "psh0258@gmail.com", "ab", new Date()));
        users.add(new User(2L, "Masuri@naver.com", "ab", new Date()));
        users.add(new User(3L, "Alice@gmail.com", "ab", new Date()));
        users.add(new User(4L, "Elena@gmail.com", "ab", new Date()));
        users.add(new User(5L, "aa", "a", new Date()));
    }

    public User getUser(Long id) {
        var user = users.stream().filter(x -> x.getId() == id).findFirst();
        return user.orElseGet(null);
    }

    public boolean login(String email, String password) {
        var user = users.stream().filter(x -> x.getEmail().equals(email) & x.getPassword().equals(password))
                                               .findFirst();
        return user.isPresent();
    }

}
