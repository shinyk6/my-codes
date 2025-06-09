package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.board.entity.Post;
import com.board.event.PostCreatedEvent;
import com.board.event.PostDeletedEvent;
import com.board.repository.PostRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostService {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	PostRepository postRepository;
	
	// 게시글 등록 + PostCreatedEvent 동기 발행
	public Post createPost(Post post) {
		//postRepository.save(new Post(title)); -> content는 null값 저장됨
		Post savePost = postRepository.save(post);
		Long postId = savePost.getId();
		System.out.println("서비스 내부 로직[create] 실행 완료");
		publisher.publishEvent(new PostCreatedEvent(postId, post.getTitle())); 
		System.out.println("[service-create] id : "+ postId + " title : " + post.getTitle());
		System.out.println("이벤트 발행 후 로직 계속 진행됨");	
		return savePost;
	}
	
	// 전체 게시글 목록 조회
	public List<Post> postAll(){
		return postRepository.findAll();
	}
	
	// 게시글 삭제 + PostDeletedEvent 발행
	public void delete(Long id) {
		Post post = postRepository.findById(id).orElseThrow();
		String title = post.getTitle();
		Long postId = post.getId();
		publisher.publishEvent(new PostDeletedEvent(postId)); //이벤트 발행 (
		System.out.println("이벤트 발행 후 로직 계속 진행됨");
	}
}
