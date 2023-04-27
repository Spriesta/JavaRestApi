package com.project.MyApp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.MyApp.Entities.User;
import com.project.MyApp.Repos.UserRepository;

@Service
public class UserService {
	UserRepository userRepository;

	public UserService(UserRepository userRepository) {		
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(User newUser) {
		return userRepository.save(newUser);
	}

	public Optional<User> findUser(Long userId) {
		return Optional.of(userRepository.findById(userId).orElse(null));
	}
	
	public User updateUser(Long userId, User newUser) {
		Optional<User> user = userRepository.findById(userId);
		
		if (user.isPresent()) {
			User FoundUser = user.get();
			FoundUser.setUserName(newUser.getUserName());
			FoundUser.setPassword(newUser.getPassword());
			return FoundUser;
		}
		else
			return null;
	}

	public void deleteUser(Long userId) {
		userRepository.deleteById(userId);
	}		
}