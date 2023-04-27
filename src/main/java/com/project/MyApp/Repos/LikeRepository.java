package com.project.MyApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.MyApp.Entities.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
