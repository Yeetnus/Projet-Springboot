package com.example.demo.controller;

import com.example.demo.model.Article;
import com.example.demo.model.Liker;
import com.example.demo.model.User;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.LikeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private LikeRepository likeRepository;

    @PostMapping("/{userId}/{articleId}/like")
    public Liker likeArticle(@PathVariable Long userId, @PathVariable Long articleId) {
        User user = userRepository.findById(userId).orElse(null);
        Article article = articleRepository.findById(articleId).orElse(null);
        if (user != null && article != null) {
            Liker like = new Liker();
            like.setUser(user);
            like.setArticle(article);
            like.setLiked(true);
            return likeRepository.save(like);
        }
        return null;
    }

    @PostMapping("/{userId}/{articleId}/dislike")
    public Liker dislikeArticle(@PathVariable Long userId, @PathVariable Long articleId) {
        User user = userRepository.findById(userId).orElse(null);
        Article article = articleRepository.findById(articleId).orElse(null);
        if (user != null && article != null) {
            Liker like = new Liker();
            like.setUser(user);
            like.setArticle(article);
            like.setLiked(false);
            return likeRepository.save(like);
        }
        return null;
    }

    @GetMapping("/{articleId}/like")
    public Long countLikes(@PathVariable Long articleId) {
        return likeRepository.countByArticleIdAndIsLiked(articleId, true);
    }

    @GetMapping("/{articleId}/dislike")
    public Long countDislikes(@PathVariable Long articleId) {
        return likeRepository.countByArticleIdAndIsLiked(articleId, false);
    }

    @GetMapping("/{articleId}/likeUsers")
    public List<User> getLikeUsers(@PathVariable Long articleId) {
        return likeRepository.findByArticleIdAndIsLiked(articleId, true).stream().map(Liker::getUser).collect(Collectors.toList());
    }

    @GetMapping("/{articleId}/dislikeUsers")
    public List<User> getDislikeUsers(@PathVariable Long articleId) {
        return likeRepository.findByArticleIdAndIsLiked(articleId, false).stream().map(Liker::getUser).collect(Collectors.toList());
    }
}
