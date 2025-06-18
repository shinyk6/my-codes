package com.lab10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab10.domain.Emp;
import com.lab10.repository.DeptRepository;
import com.lab10.repository.EmpRepository;

@Service
public class EmpService {

	// 생성자 주입
	private EmpRepository empRepository;
	
	public EmpService(EmpRepository empRepository) {
		this.empRepository = empRepository;
	}
	
	// 1. 사원 정보를 MongoDB에 저장 (등록 또는 수정) 
	public void save(Emp emp) {
		empRepository.save(emp);
	}
	
	// 2. 모든 사원 목록을 조회 
	public List<Emp> findAll(){
		return empRepository.findAll();
	}
	
	// 3. 사번으로 단일 사원 조회
	public Emp findByEmpno(int empno) {
		//findById는 Optional을 반환하므로 orElse(null)등을 사용하여 처리
		return empRepository.findById(empno).orElse(null);
	}
	
	// 4. 사번으로 사원 삭제 
	public void delete(int empno){
		empRepository.deleteById(empno);
	}
	
	// 5. 이름에 특정 키워드가 포함된 사원 목록 조회
	public List<Emp> searchByName(String keyword){
		//Repository에 findByEnameContaining과 같은 메소드가 있다고 가정
		return empRepository.findByEnameContaining(keyword);
	}
	
	// 6. 급여가 특정 값 이상인 사원 목록 조회 
	public List<Emp> findBySalaryAbove(int sal){
		return empRepository.findBySalGreaterThanEqual(sal); 
	}
	

	// 7. 부서번호로 해당 부서의 사원 목록 조회
	public List<Emp> findByDeptno(int deptno){
		// Repository에 findByDept와 같은 메소드가 있다고 가정 (Emp엔티티의 dept필드 기준)
		return empRepository.findByDept(deptno);
	}
	
	
}
