package com.sec01.repository.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Configuration
public class QuerydslConfig {

	@PersistenceContext // 현재 트랜잭션과 관련된 엔티티 매니저를 자동프록시 해줌.
	private EntityManager em; // JPA crud 등의 메소드 실행을 주관하는 매니저
	
	@Bean
	public JPAQueryFactory queryFactory() {//Querydsl의 쿼리 빌더 역할을 수행하는 클래스	
		return new JPAQueryFactory(em);
	}
}
