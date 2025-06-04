package com.sec01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sec01.dto.EmpDeptDto;
import com.sec01.entity.Dept;
import com.sec01.entity.Emp;
import com.sec01.repository.DeptRepository;
import com.sec01.repository.EmpDeptRepository;
import com.sec01.repository.EmpRepository;

@Service
public class EmpDeptService {
	@Autowired
	EmpRepository empRepository;
	
	@Autowired
	DeptRepository deptRepository;
	
	@Autowired
	EmpDeptRepository empDeptRepository;
	
	
	// Emp와 Dept를 조인해서 DTO로 가져오는 메소드
	public List<EmpDeptDto> getEmpDeptDtos(){
		return empDeptRepository.findEmpDeptInfo();
	}
	
	//Emp 엔티티 전부 조회
	public List<Emp> getAllEmps(){
		return empRepository.findAll();
	}
	
	//Dept 엔티티 전부 조회
	public List<Dept> getAllDepts(){
		return deptRepository.findAll();
	}
	
	//Emp와 Dept조인 결과를 페이지 단위로 조회 (페이징 처리)
	public Page<EmpDeptDto> getEmpDeptPage(Pageable pageable){ 
		return empDeptRepository.findEmpDeptPage(pageable); //OffSet, Size를 담고 있음 
	}
	
}
