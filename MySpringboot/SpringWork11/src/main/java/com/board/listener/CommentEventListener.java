package com.board.listener;
import com.board.repository.PostRepository;

import jakarta.transaction.Transactional;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.board.event.CommentCreatedEvent;
import com.board.event.PostDeletedEvent;
import com.board.repository.CommentRepository;

@Component
public class CommentEventListener {


    private final PostRepository postRepository;
    private final CommentRepository commentRepository;


    CommentEventListener(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
	

	@EventListener
	public void handle(CommentCreatedEvent event) { 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  // 일부러 지연 
		System.out.println("댓글 이벤트 처리 중... by " + event.getWriter()); 
		System.out.println("새 댓글 알림 전송 중...");
	}
	
	//게시글 삭제 시 해당 댓글 삭제됨
	@EventListener
	@Transactional //이벤트 기반 삭제 방식은 트랜잭션 commit 후에 실행돼야 안전함
	public void onPostDeleted(PostDeletedEvent event) { 
		Long postId = event.getPostId();
		System.out.println("해당 게시글의 댓글 삭제 실행: postId = " + postId);  //댓글 먼저 삭제 (게시글을 먼저 삭제하면 댓글이 남아있어서 외래키 제약조건 위반으로 DB가 삭제를 막음-comment의 post_id가 post(id)를 참조(외래키 FK))
		commentRepository.deleteByPostId(postId); 
		
		System.out.println("댓글 삭제 후 게시글 삭제 postId : " + postId);
		postRepository.deleteById(postId);
	}

}
