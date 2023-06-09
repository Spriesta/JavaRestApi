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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.MyApp.Entities.Post;
import com.project.MyApp.Requests.PostCreateRequest;
import com.project.MyApp.Services.PostService;


@RestController
@RequestMapping("/posts")
public class PostController {
	
	private PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
		
	@GetMapping
	public List<Post> getAllPost(@RequestParam Optional<Long> userId){
		return postService.getAllPost(userId);
	}
	
	@GetMapping("/{postId}")
	public Post getOneUser(@PathVariable Long postId){
		return postService.getOnePost(postId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
		return postService.createOnePost(newPostRequest);
	}
	
	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable Long postId,@RequestBody PostCreateRequest updatePostRequest){		
		return postService.updateOnePost(postId, updatePostRequest);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable Long postId) {
		postService.deleteOnePost(postId);
	}
}