package com.lab10.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lab10.domain.Dept;
import com.lab10.service.DeptService;
import com.lab10.service.EmpService;

@RestController
@RequestMapping("/dept")
public class DeptController {

	private final DeptService deptService;
	
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	// 1. 부서 정보를 MongoDB에 저장 (등록 또는 수정)  @RequestBody -> 요청 시 Json데이터처리
	/* {deptno:10,
	 * 	dname:영업부,
	 * 	loc:서울,
	 * 	"latitude": 40.000,
	 * 	"longitude": -74.000
	 */
	@PostMapping //자동으로 넣어줄 때 호출
	public void save(@RequestBody Dept dept) {
		deptService.save(dept);
	}
	
	// 2. 전체 부서 목록 조회 
	@GetMapping
	public List<Dept> findAll(){
		return deptService.findAll();
	}
	
//	// 3. 부서번호로 단일 부서 조회  /dept/10
	@GetMapping("/{deptno}")
	public Dept findByDeptno(@PathVariable int deptno) {
		return deptService.findByDeptno(deptno);
	}
	
	// 4. 부서명 키워드로 검색  /dept/search?keyword=
	@GetMapping("/search")
	public List<Dept> findByDnameContaining(@RequestParam String keyword){
		return deptService.findByDnameContaining(keyword);
	}
	// 5. 지도 마커용 API: 모든 부서의 위치 정보(JSON) 반환 (위도/경도 포함) /dept/api -> 지도용 json리턴
	// 목적을 2번과 다르게 함
	@GetMapping("/api")
	public List<Dept> findForMap(){
		return deptService.findAll(); //2번과 동일하지만, 엔드포인트가 다름/2번에선 필드 4개 가져오고 5번에선 6개 가져오기위해서 원래는 DTO를 만들어야함
	}
}
