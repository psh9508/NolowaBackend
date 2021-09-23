package com.example.Nolowa.post;

import com.example.Nolowa.dataModels.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
