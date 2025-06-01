package com.sec01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EmpService {

	@Autowired
	private EmpRepository empRepository;
	
	// 사원 전체 조회
	public List<Emp> findAll(){ //모든 사원 조회
		return empRepository.findAll();
	}
	
	// 사번으로 사원 상세 조회
	public Emp findById(int empno) { 
		return empRepository.findById(empno).orElse(null);
	}
	
	// 사원 등록/수정
	@Transactional
	public void save(Emp emp) { 
		empRepository.save(emp);
	}
	
	@Transactional
	// 사원 삭제
	public void delete(int empno) {
		empRepository.deleteById(empno);
	}
}
