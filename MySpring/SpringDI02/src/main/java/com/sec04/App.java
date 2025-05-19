package com.sec04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sec01.MyAddress;

@Configuration
public class App {
	@Bean 
	public MyAddress m01() {
		return new MyAddress("홍길동", "1111", "111111");
	}
	@Bean 
	public MyAddress m02() {
		return new MyAddress("정길동", "2222", "222222");
	}
	
	@Bean  //MyCollection의 객체 생성
	public MyCollection myCollection() {
		MyCollection m = new MyCollection();
		m.setItems(Arrays.asList("AA","BB","CC")); //setItems을 호출
		m.setMyarray(new String[] {"AAS", "BBS", "CCS" }); //setMyArray호출
		m.setMyset(Set.of("AA", "BB", "CC", "DD"));
		m.setMymap(Map.of("A","AAm",
						  "B","BBm",
						  "C","CCm")); //순서대로 key value로 들어감
		
		Map<String, MyAddress> U_map = new HashMap<>();
		U_map.put("A11", m01());
		U_map.put("B22", m02());
		m.setMyaddr(U_map);
		
		return m;
	}
	
	

}
