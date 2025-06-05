package com.sec01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/travels")
@CrossOrigin(origins = "http://localhost:3000") //react 포트 허용
public class TravelController {

	@Autowired
	private TravelService travelService;
	
	@GetMapping
	public List<Travel> getAll(){
		return travelService.getAll();
	}
	
	@PostMapping
	public void save(@RequestBody Travel travel) {
		travelService.save(travel);
	}
	
	//[3] 삭제
	
	@GetMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		travelService.delete(id);
	}
	
}
