package com.example.Nolowa.post;

import com.example.Nolowa.dataModels.Post;
import com.example.Nolowa.dataModels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select p from Post as p where p.postedUser.id in :userIds")
    List<Post> findAllByPostedUserIds(@Param("userIds") List<Long> userIds);

    @Query(value = "select p from Post as p where p.postedUser.id = :userId")
    List<Post> findAllByPostedUserId(@Param("userId") Long userId);
}
