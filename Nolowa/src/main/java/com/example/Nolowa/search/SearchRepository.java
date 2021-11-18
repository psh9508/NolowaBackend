package com.example.Nolowa.search;

import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.SearchHistory;
import com.example.Nolowa.dataModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SearchRepository extends JpaRepository<SearchHistory, Long> {
    @Query(value = "select count(s) from SearchHistory as s where s.searchUser.id = :userId")
    int findSearchedCount(Long userId);

    List<User> findAllBySearchUser(Long userId);

    @Query(value = "select top 5 keyword from Search_History where user_id = :userId order by uploaded_date_time desc", nativeQuery = true)
    List<String> findAllKeywords(Long userId);

//    ArrayList<String> findAllKeywordTop5BySearchUserOrderByUploadedDateTimeDesc(User user);
//    void save(User user, String keyword);
}
