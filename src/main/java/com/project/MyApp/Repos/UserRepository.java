package com.project.MyApp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.MyApp.Entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
