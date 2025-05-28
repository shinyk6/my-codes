package com.lab02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab02.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	//필요하면 커스텀 쿼리 메소드 추가 가능 _구체클래스로 구현
}
