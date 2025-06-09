package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.board.entity.Comment;
import com.board.entity.Post;
import com.board.event.CommentCreatedEvent;
import com.board.repository.CommentRepository;
import com.board.repository.PostRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommentService {

    private final PostRepository postRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	CommentRepository CommentRepository;

    CommentService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
	
    //댓글 등록
	public Comment addComment(Long postId, Comment comment) {
		Post post = postRepository.findById(postId).orElseThrow(()->new IllegalArgumentException("해당 게시글 없음" + postId));
		comment.setPost(post); //연관관계 설정(댓글이 어떤 게시글(post)에 연결되는지 설정 : comment.post_id)
		Comment saveComment = CommentRepository.save(comment);
		
		Long getPostId = postId; //게시글 id
		String writer = saveComment.getWriter();
		String content = saveComment.getContent();
		publisher.publishEvent(new CommentCreatedEvent(getPostId, writer, content)); 
		System.out.println("비동기 이벤트 발행 완료");
		return saveComment;
	}
	
	//댓글 조회
	public List<Comment> getComment() {
		return CommentRepository.findAll();
	}
	
}
