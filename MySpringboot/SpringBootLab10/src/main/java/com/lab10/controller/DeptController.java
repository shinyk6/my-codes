package com.lab10.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab10.domain.Dept;
import com.lab10.service.DeptService;
import com.lab10.service.EmpService;

@RestController
@RequestMapping("/dept")
public class DeptController {

	private final EmpService empService;
	private final DeptService deptService;
	
	public DeptController(EmpService empService, DeptService deptService) {
		this.empService = empService;
		this.deptService = deptService;
	}
	
	
	//부서 정보를 MongoDB에 저장 (등록 또는 수정) 
	@PostMapping
	public void save(Dept dept) {
		deptService.save(dept);
	}
	
	//전체 부서 목록 조회 
	@GetMapping
	public List<Dept> findAll(){
		return deptService.findAll();
	}
	
	//부서번호로 단일 부서 조회 
	@GetMapping("/{deptno}")
	public Dept findByDeptno(@PathVariable int deptno) {
		return deptService.findByDeptno(deptno);
	}
	
	//네이버 지도용: 모든 부서의 위치 정보(JSON) 반환 
	
	//부서명 키워드로 검색 
	@GetMapping("/search")
	public List<Dept> findByDnameContaining(@RequestParam String keyword){
		return deptService.findByDnameContaining(keyword);
	}
	
	
	
}
