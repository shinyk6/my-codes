package com.board.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@Data
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // DB의 Auto_increment대응
	public Long id; //게시글 id 
	
	public String title; //게시글 제목
	public String content; //내용

	
//	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Comment> comments = new ArrayList<>();
	
	/*
	 * cascade = CascadeType.ALL: Post 삭제 시 연관된 Comment도 같이 삭제
	 * orphanRemoval = true: Comment의 post가 null되면 DB에서 제거
	 * 
	 * */
}
