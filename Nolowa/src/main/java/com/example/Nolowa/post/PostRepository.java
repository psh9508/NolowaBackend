package com.example.Nolowa.post;

import com.example.Nolowa.dataModels.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> findAllByUserIds(List<Long> userIds);
    List<Post> findAllByUserId(Long userId);
}
