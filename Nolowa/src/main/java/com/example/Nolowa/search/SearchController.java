package com.example.Nolowa.search;

import com.example.Nolowa.dataModels.PostDTO;
import com.example.Nolowa.dataModels.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Search")
public class SearchController {

    private final SearchService service;

    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping("/History/{id}")
    public List<User> getSearchedList(@PathVariable Long userId) {
        var searchedUserList = service.getSearchedList(userId);

        return searchedUserList;
    }

    @GetMapping("/{keyword}")
    public List<PostDTO> search(@PathVariable String keyword, @RequestParam(value="userId")String userId) {
        var searchResult = service.search(Long.parseLong(userId), keyword);
        return null;
    }

    @GetMapping("User/{username}")
    public List<User> searchUser(@PathVariable String username) {
        var searchedUserList = service.searchUser(username);

        return searchedUserList;
    }

    @GetMapping("Keywords/{userId}")
    public List<String> getSearchedKeywords(@PathVariable String userId) {
        var searchedKeywords = service.getSearchedKeywords(Long.parseLong(userId));

        return searchedKeywords;
    }
}
