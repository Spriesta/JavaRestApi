package com.project.MyApp.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.MyApp.Entities.User;
import com.project.MyApp.Repos.UserRepository;
import com.project.MyApp.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private UserService userService;
	
	public UserController(UserRepository userRepository) {
		this.userService = userService;
	}
		
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userId}")
	public Optional<User> getUser(@PathVariable Long userId){
		return userService.findUser(userId);
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser){
		return userService.createUser(newUser);
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@PathVariable Long userId, @RequestBody User newUser){		
		return userService.updateUser(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
}