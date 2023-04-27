package com.project.MyApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.MyApp.Entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
