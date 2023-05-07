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

import com.project.MyApp.Entities.Comment;
import com.project.MyApp.Requests.CommentCreateRequest;
import com.project.MyApp.Services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	private CommentService commentService ;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId){		
		return commentService.getAllCommnetsWithParams(userId, postId);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId){		
		return commentService.getOneComment(commentId);
	}
	
	@PostMapping
	public void createOneComment(@RequestBody CommentCreateRequest request){		
		commentService.createOneComment(request);
	}
	
	@DeleteMapping
	public void DeleteOneComment(Long commentId){		
		commentService.DeleteOneComment(commentId);
	}
	
}
