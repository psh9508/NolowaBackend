package com.example.Nolowa.search;

import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.SearchHistory;
import com.example.Nolowa.dataModels.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchRepository extends JpaRepository<SearchHistory, Long> {
    List<User> findAllBySearchUser(Long userId);
}
