package com.lab10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab10.domain.Emp;
import com.lab10.service.DeptService;
import com.lab10.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	private final EmpService empService;
	private final DeptService deptService;
	
	public EmpController(EmpService empService, DeptService deptService) {
		this.empService = empService;
		this.deptService = deptService;
	}
	
	
	//사원 등록 또는 수정 
	@PostMapping
	public void save(Emp emp) {
		empService.save(emp);
	}
	
	//전체 사원 목록 조회 
	@GetMapping
	public List<Emp> findAll(){
		return empService.findAll();
	}
	
	//사번으로 단일 사원 조회 
	@GetMapping("/{empno}")
	public Emp findByEmpno(@PathVariable int empno) {
		return empService.findByEmpno(empno);
	}
	
	//사번으로 사원 삭제 
	@DeleteMapping("/{empno}")
	public void delete(@PathVariable int empno) {
		empService.delete(empno);
	}
	
	//이름에 특정 키워드가 포함된 사원 목록 조회 
	@GetMapping("/search")
	public List<Emp> searchByName(@RequestParam String keyword){
		return empService.searchByName(keyword);
	}
	
	//급여가 특정 값 이상인 사원 목록 조회
	@GetMapping("/sal")
	public List<Emp> findBySalaryAbove(@RequestParam int min){
		return empService.findBySalaryAbove(min);
	}
	
	//특정 부서 소속 사원 목록 조회
	@GetMapping("/dept/{deptno}")
	public List<Emp> findByDeptno(int deptno){
		return empService.findByDeptno(deptno);
	}
	
	
	
}
