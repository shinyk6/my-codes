package com.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.entity.Comment;
import com.board.service.CommentService;

@RestController
public class CommentController {

	private final CommentService service;
	
	public CommentController(CommentService service) {
		this.service = service;
	}
	
	@PostMapping("/comments/{postId}")
	public Comment add(@PathVariable Long postId, @RequestBody Comment comment) {
		
		return service.addComment(postId, comment);
	}
	
	@GetMapping("/comments")
	public List<Comment> getComment(){
		return service.getComment();
	}
	
}
