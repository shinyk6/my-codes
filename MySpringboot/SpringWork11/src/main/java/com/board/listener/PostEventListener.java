package com.board.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import com.board.event.PostCreatedEvent;
import com.board.event.PostDeletedEvent;
import com.board.repository.CommentRepository;

@Component
public class PostEventListener {

	
	@EventListener //게시글 둥록 이벤트
	public void handle(PostCreatedEvent event) {
		System.out.println("게시글 등록됨 : " + event.getTitle());
	}
	

	
}
