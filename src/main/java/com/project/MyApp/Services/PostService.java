package com.project.MyApp.Services;

import java.util.List; 
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.MyApp.Entities.Post;
import com.project.MyApp.Entities.User;
import com.project.MyApp.Repos.PostRepository;
import com.project.MyApp.Requests.PostCreateRequest;

@Service
public class PostService {

	PostRepository postRepository;
	UserService userService;
	
	public PostService(PostRepository postRepository, UserService userService) {
		this.postRepository = postRepository;
		this.userService = userService;
	}

	public List<Post> getAllPost(Optional<Long> userId) {
		if (userId.isPresent()) 
			return postRepository.findByUserId(userId);		
		
		return postRepository.findAll();
	}

	public Post getOnePost(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {	
		User user = userService.findUser(newPostRequest.getUserId()).orElse(null);
		if(user == null)
			return null;
		
		Post newPst = new Post();
		newPst.setId(newPostRequest.getId());
		newPst.setText(newPostRequest.getText());
		newPst.setTitle(newPostRequest.getTitle());
		newPst.setUser(user);
		return postRepository.save(newPst);
	}

	public Post updateOnePost(@PathVariable Long postId, @RequestBody PostCreateRequest updatePostRequest) {
		Post post = postRepository.findById(postId).orElse(null);
		if(post != null) {
			post.setText(updatePostRequest.getText());
			post.setTitle(updatePostRequest.getTitle());
			return postRepository.save(post);
		}
		
		return null;
	}

	public void deleteOnePost(@PathVariable Long postId) {
		Post post = postRepository.findById(postId).orElse(null);
		if(post != null)
			postRepository.deleteById(post.getId());
	}
}