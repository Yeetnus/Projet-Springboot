package com.example.demo.repository;

import com.example.demo.model.Liker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Liker, Long> {
}
