package com.example.demo.repository;

import com.example.demo.model.Liker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface LikeRepository extends JpaRepository<Liker, Long> {
    Long countByArticleIdAndIsLiked(Long articleId, boolean b);

    List<Liker> findByArticleIdAndIsLiked(Long articleId, boolean b);
}
