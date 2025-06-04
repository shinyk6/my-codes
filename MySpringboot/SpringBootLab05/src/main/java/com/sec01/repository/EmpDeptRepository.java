package com.sec01.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sec01.dto.EmpDeptDto;
import com.sec01.entity.Emp;

@Repository
public interface EmpDeptRepository extends JpaRepository<Emp, Integer> {
	
	
	// case 1 : DTO를 활용한 JPQL 방식
	@Query("SELECT new com.sec01.dto.EmpDeptDto(e.ename, e.sal, d.dname) FROM Emp e JOIN e.dept d") //EmpDeptDto의 매개변수가 있는 생성자에 값을 넣은 결과
	List<EmpDeptDto> findEmpDeptInfo();  //조인한 쿼리의 결과를 리스트 객체로 리턴 
	
	
	// case 2 : DB쿼리 (nativeQuery) 방식
	@Query(value = "SELECT e.ENAME, e.SAL, d.DNAME FROM EMP e JOIN DEPT d ON e.DEPTNO = d.DEPTNO", nativeQuery = true) //속성이 여러개라 value= 라고 명시
	List<Object[]> findEmpDeptNative();  //결과 그대로 배열로 받아서 직접 DTO로 형변환
	
	
	// case 3: DTO를 활용한 JPQL 페이징 처리 -> 내부적으로 전체 개수 처리를 한다.
	@Query("SELECT new com.sec01.dto.EmpDeptDto(e.ename, e.sal, d.dname) FROM #{#entityName} e JOIN e.dept d") //#{#entityName} : 현재 repository가 다루고있는ㄷ
	Page<EmpDeptDto> findEmpDeptPage(Pageable pageable);  //Page = 데이터 Emp + 페이지 정보
	
	
	//Select e.ename, e.sa, d.dname
	//from emp e
	//join dept d on e.deptno = d.deptno
	//Limit ?,? -> offset, pageSize 기반으로 결정됨 Pageable때문에
	// Offset : 결과 집합 중 특정 위치에서부터 데이터를 반환하도록 하는 기준점
	// 
	
	
	
	
	//case 4:  nativeQuery를 사용한 카운트 처리
	@Query(value = "SELECT e.ENAME, e.SAL, d.DNAME FROM EMP e NATURAL JOIN DEPT d",
	        countQuery = "SELECT COUNT(*) FROM EMP e NATURAL JOIN DEPT d",
	        nativeQuery = true)
	Page<Object[]> findEmpDeptPageNative(Pageable pageable);

}
