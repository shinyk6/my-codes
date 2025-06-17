package com.lab10.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lab10.domain.Emp;

@Repository
public interface EmpRepository extends MongoRepository<Emp, Integer> {   
	List<Emp> findByEnameContaining(String keyword);
	// 내부적으로 밑 쿼리 실행
	// {ename : {$regex: *.keyword.*, $options: 1}   -> $options: 1 소문자는 무시해라
	// Query query = new Query();
	// query.addCriteria(Criteria.where("ename").regex( *.keyword.* )) 
	
	List<Emp> findBySalGreaterThanEqual(Integer sal); 
	// {sal : {$gte : salValue }} 
	// Query query = new Query();
	// query.addCriteria(Criteria.where("sal").gte(salValue))
	
	List<Emp> findByDept(Integer deptno); 
	// {dept : deptnoValue}
	// Query query = new Query();
	// query.addCriteria(Criteria.where("dept").is(deptnoValue))
} 