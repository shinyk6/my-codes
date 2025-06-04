package com.sec01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;

import com.sec01.dto.EmpDeptDto;
import com.sec01.entity.Dept;
import com.sec01.entity.Emp;
import com.sec01.service.EmpDeptService;

@Controller
public class EmpDeptController {

	@Autowired
	EmpDeptService  service;
	
	
	@GetMapping("/emp-info") // 1: 페이지 요청
	public String showEmpDeptInfo(Model model, //2: 뷰 리졸버 값 전달 객체
								  @RequestParam(defaultValue="0") int page, // 3: Http요청 파라미터 //localhost:8080/emp-info?page=0&size=5 로 값을 넘겨준 것과 동일
								  @RequestParam(defaultValue="5") int size,
								  @RequestParam(defaultValue="ename") String sortBy,
								  @RequestParam(defaultValue="asc") String direction){ 
		
		Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<EmpDeptDto> empPage = service.getEmpDeptPage(pageable); // 5: 페이지 객체 값 전달
		model.addAttribute("empPage", empPage); // 6: 페이지 객체 전달 후 리턴값 적용
		
		return "emp-info"; // 7. 리졸버 뷰로 이동
	}
	
	
	@GetMapping("/emps")
	public String showAllEmps(Model model) {
		List<Emp> emps = service.getAllEmps();
		model.addAttribute("emps", emps);
		return "emps"; //emps.html
	}
	
	
	@GetMapping("/depts")
	public String showAllDepts(Model model) {
		List<Dept> depts = service.getAllDepts();
		model.addAttribute("depts", depts);
		return "depts"; //depts.html
	}
}
