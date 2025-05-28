package com.test01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test01.entity.Member;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> { 
	//추가 메소드
	//Optional : 리턴값이 null일수도 null아 아닐수도 있을 때 -> NullpointException (NPE) 방지
	// 		     null일 시 orElse로 예외처리 가능
    Optional<Member> findByUsername(String username); 
    
    //전체 회원 중 ID 내림차순 5명 조회
    List<Member> findTop5ByOrderByIdDesc(); //jpa가 쿼리를 만듦 (주요 키워드를 유추해서)
    
} 