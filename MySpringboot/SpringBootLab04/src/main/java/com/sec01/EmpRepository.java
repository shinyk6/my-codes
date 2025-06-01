package com.sec01;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository  extends JpaRepository<Emp, Integer>{
	// 추가 코드
	// findBy	Dept	Deptno 
	//-> findBy로 시작하면 where절을 만듦
	// JPQL -> select e from emp e where e.dept.deptno = :deptno
	List<Emp> findByDeptDeptno(int deptno);
}
