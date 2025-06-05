package com.sec01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelService {
	
	@Autowired
	private TravelRepository travelRepository;
	
	//[1] 전체 목록
	
	public List<Travel> getAll(){
		return travelRepository.findAll();
	}
	
	//[2] 저장
	
	public void save(Travel travel) {
		travelRepository.save(travel);
	}
	
	//[3] 삭제
	
	public void delete(Integer id) {
		travelRepository.deleteById(id);
	}
}
