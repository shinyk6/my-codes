package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.entity.Post;
import com.board.service.PostService;

@RestController
public class Postcontroller {

	@Autowired
	PostService postService;
	
	@PostMapping("/posts")
	public Post create(@RequestBody Post post) { //리턴값 권장 - 저장결과 즉시확인, Restful api규칙, 테스트/디버깅 용이
		return postService.createPost(post);
	}
	
	@GetMapping("/posts")
	public List<Post> all(){
		return postService.postAll();
	}
	
	@DeleteMapping("/posts/{id}")
	public void delete(@PathVariable Long id) {
		postService.delete(id);
	}
}
