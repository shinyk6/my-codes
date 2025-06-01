package com.sec01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/emp") //공통 경로
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@Autowired
	private DeptService deptService;

//    EmpController(DeptRepository deptRepository) {
//        this.deptRepository = deptRepository;
//    }
	
	/**
	 *  1 기본 경로로 접근하면 /emp/list로 리다이렉트
	 */
	@GetMapping
	public String redirectToList() {
		return "redirect:/emp/list";
	}
	
	/**
	 *  2 사원 목록 & 부서 목록 조회
	 */
	@GetMapping("/list")
	public String getAll(Model model){ 
		List<Emp> emps = empService.findAll();
		List<Dept> depts = deptService.findAll();
		
		emps.removeIf(emp->emp.getDept()==null); // emp.getDept()가 null인 사원만 제거, 나머지 출력
		model.addAttribute("emps", emps);
		model.addAttribute("depts", depts);
		return "emp/list";
	}
	
	/**
	 *  3 사원 등록 화면 표시
	 */
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("emp", new Emp()); //폼 입력 값을 채우고 제출할 빈 Emp() 객체 전달
		model.addAttribute("depts", deptService.findAll()); //이너뷰용 -> 폼 바인딩 오류 방지용 (명시적으로 depts를 쓰진 않음)
		return "emp/new";
	}
	
	/**
	 *  4 사원 등록 처리
	 *  POST /emp
	 *  	@GetMapping("/new") -> 요청되면 빈Emp 객체를 가지고 emp/new.html으로 이동한 후 데이터를 채운 Emp객체를
	 *  	가지고 현재 메소드가 호출됨. <form action="/emp" method="post" class="mt-3">
	 */
	@PostMapping
	public String create(@ModelAttribute Emp emp) { 
		empService.save(emp);
		return "redirect:/emp/list";
	}
	
	/**
	 *  5 사원 상세 보기
	 *  /emp/{empno}	<a th:href="@{'/emp/' + ${emp.empno}}" class="btn btn-info btn-sm">상세</a> 	
	 */
	@GetMapping("/{empno}")
	public String getById(@PathVariable int empno, Model model) { //사번으로 사원 상세 조회
		Emp emp = empService.findById(empno);
		model.addAttribute("emp", emp);
		return "emp/detail";
	}
	
	
	/**
	 *	6 사원 수정 화면
	 *	/emp/{empno}/edit 
	 */
	@GetMapping("/{empno}/edit")
	public String updateView(@PathVariable int empno, Model model) {
		Emp emp = empService.findById(empno);
		model.addAttribute("emp", emp);
		model.addAttribute("depts", deptService.findAll());
		return "emp/edit";
	}
	
	/**
	 *  7 사원 수정 처리
	 *  POST /emp/{empno}/edit
	 */
	@PostMapping("/{empno}/edit")
	public String update(@PathVariable int empno, @ModelAttribute Emp empDetails) {
		Emp emp = empService.findById(empno);
		if(emp!=null) {
			emp.setEname(empDetails.getEname());
			emp.setJob(empDetails.getJob());
			emp.setSal(empDetails.getSal());
			emp.setDept(empDetails.getDept());
			empService.save(emp);
		}
		return "redirect:/emp/list";
	}
	
	/**
	 *  8 사원 삭제 처리
	 *  POST /emp/{empno}/delete
	 */
	@PostMapping("/{empno}/delete")
	public String delete(int empno) { //사원 삭제
		empService.delete(empno);
		return "redirect:/emp/list";
	}

	
}
