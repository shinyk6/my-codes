package com.lab10.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lab10.domain.Dept;

@Repository
public interface DeptRepository extends MongoRepository<Dept, Integer> { 
	
	Dept findByDname(String dname); 
	// {dname : dnameValue}
	// Query query = new Query();
	// query.addCriteria(Criteria.where("dname").is(dnameValue) 	
	
	//부서명에 특정 키워드가 포함된 부서 목록 조회 
	List<Dept> findByDnameContaining(String keyword); 
	// 내부적으로 실행
	// {dname : {$regex: *.keyword.*, $options: 1}   -> $options: 1 소문자는 무시해라
	// Query query = new Query();
	// query.addCriteria(Criteria.where("dname").regex( *.keyword.* )) 
} 