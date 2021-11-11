package com.example.Nolowa.search;

import com.example.Nolowa.dataModels.User;
import com.example.Nolowa.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final SearchRepository repository;
    private final UserRepository userRepository;

    public SearchService(SearchRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<User> getSearchedList(Long userId) {
        var searchedUserList = repository.findAllBySearchUser(userId);

        return searchedUserList;
    }

    public List<User> search(String username) {
        var searchedUserList = userRepository.findAllByNameContaining(username);

        return searchedUserList;
    }
}
