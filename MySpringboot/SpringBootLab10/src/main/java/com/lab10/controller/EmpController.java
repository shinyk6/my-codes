package com.lab10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	public EmpController(EmpService empService) {
		this.empService = empService;
	}
	
	// 1. 사원 등록 또는 수정 
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Emp emp) {
		empService.save(emp);
		return ResponseEntity.ok("saved"); //상태코드 200 + saved문자열
		// ResponseEntity를 쓰는 이유 -> 상태코드, 헤더, 본문제어용
	}
	
	// 2. 전체 사원 목록 조회 
	@GetMapping
	public List<Emp> findAll(){
		return empService.findAll();
	}
	
	// 3. 사번으로 단일 사원 조회 
	@GetMapping("/{empno}")
	public Emp findById(@PathVariable int empno) {
		return empService.findByEmpno(empno);
	}
	
	// 4. 사번으로 사원 삭제 
	@DeleteMapping("/{empno}")
	public ResponseEntity<String> delete(@PathVariable int empno) {
		empService.delete(empno);
		return ResponseEntity.ok("deleted");//Ok():상태코드 200 + deleted문자열
	}
	
	// 5. 이름에 특정 키워드가 포함된 사원 목록 조회 
	@GetMapping("/search")
	public List<Emp> searchByName(@RequestParam String keyword){
		return empService.searchByName(keyword);
	}
	
	// 6. 급여가 특정 값 이상인 사원 목록 조회
	@GetMapping("/sal")
	public List<Emp> searchBySalary(@RequestParam Integer min){
		return empService.findBySalaryAbove(min);
	}
	
	// 7. 부서번호로 사원 검색
	@GetMapping("/dept/{deptno}")
	public List<Emp> findByDept(@PathVariable Integer deptno){
		return empService.findByDeptno(deptno);
	}
	
	
	
}
