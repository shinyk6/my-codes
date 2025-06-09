package com.board.event;

public class CommentCreatedEvent {

	private final Long postId; // 댓글 id
	private final String writer; //작성자
	private final String content; //댓글 내용
	
	public CommentCreatedEvent(Long postId, String writer, String content) {
		this.postId = postId;
		this.writer = writer;
		this.content = content;
	}

	public Long getPostId() {
		return postId;
	}

	public String getWriter() {
		return writer;
	}

	public String getContent() {
		return content;
	}
	
	
}
