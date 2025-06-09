package com.board.event;

public class PostCreatedEvent {

	private final Long postId; //게시글 등록했을 때 id
	private final String title; //게시글 제목
	
	public PostCreatedEvent(Long postId, String title) {
		this.postId = postId;
		this.title = title;
	}

	public Long getPostId() {
		return postId;
	}

	public String getTitle() {
		return title;
	}

}
