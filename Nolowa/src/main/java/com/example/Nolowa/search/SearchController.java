package com.example.Nolowa.search;

import com.example.Nolowa.dataModels.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/{username}")
    public List<User> search(@PathVariable String username, @RequestParam(value="userId")String userId) {

        var searchedUserList = service.search(username);

        return searchedUserList;
    }
}
