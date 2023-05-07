package com.project.MyApp.Services;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.MyApp.Entities.Comment;
import com.project.MyApp.Entities.Post;
import com.project.MyApp.Entities.User;
import com.project.MyApp.Repos.CommentRepository;
import com.project.MyApp.Requests.CommentCreateRequest;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Comment> getAllCommnetsWithParams(Optional<Long> userId, Optional<Long> postId) {
		
		if (userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}
		else if(userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		}
		else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		}
		else {
			commentRepository.findAll();
		}
			
		return null;
	}

	public Comment getOneComment(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	public Comment createOneComment(CommentCreateRequest request) {
		Optional<User> user = userService.findUser(request.getUserId());
		Post post = postService.getOnePost(request.getPostId());
		
		if (user != null && post != null) {
			Comment commentToSave = new Comment();
			
			commentToSave.setId(request.getId());
			//commentToSave.setUser(user);
			commentToSave.setPost(post);
			commentToSave.setText(request.getText());
			
			return commentRepository.save(commentToSave);
		}
		
		return null;
	}

	public Comment UpdateOneComment(CommentCreateRequest request, Long commentId) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		
		if (comment.isPresent()) {
			Comment commentToUpd = comment.get();
			commentToUpd.setText(request.getText());
			
			return commentRepository.save(commentToUpd);
		}
		
		return null;
	}

	public void DeleteOneComment(Long commentId) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		
		if (comment.isPresent()) {		
			commentRepository.deleteById(commentId);
		}
	}

}
