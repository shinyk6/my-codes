package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	void deleteByPostId(Long postId); //JPA쿼리 메소드 규칙에 부합하기에 JPA가 자동으로 구현해줌 (Post ID기준 삭제 메소드)

}
