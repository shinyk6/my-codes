package com.lab10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab10.domain.Emp;
import com.lab10.repository.DeptRepository;
import com.lab10.repository.EmpRepository;

@Service
public class EmpService {

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
		return empRepository.findById(empno).orElse(null);
	}
	
	// 4. 사번으로 사원 삭제 
	public void delete(int empno){
		empRepository.deleteById(empno);
	}
	
	// 5. 이름에 특정 키워드가 포함된 사원 목록 조회
	public List<Emp> searchByName(String keyword){
		return empRepository.findByEnameContaining(keyword);
	}
	
	// 6. 급여가 특정 값 이상인 사원 목록 조회 
	public List<Emp> findBySalaryAbove(int sal){
		return empRepository.findBySalGreaterThanEqual(sal); 
	}
	

	// 7. 부서번호로 해당 부서의 사원 목록 조회
	public List<Emp> findByDeptno(int deptno){
		return empRepository.findByDept(deptno);
	}
	
	
}
