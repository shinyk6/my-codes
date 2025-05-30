package com.person.view;

import java.util.List;

import com.person.model.Person;

public class PersonConsolView {
	
	//전체 출력
	public void showAllList(List<Person> list) { 
		for(Person p: list) {
			System.out.println(p.getName()+ "\t" + p.getAddress() + "\t" + p.getPhone());
		}
	}
		
	
	//알림 메세지
	public void showMessage(String message) {
		System.out.println("[알림]" + message);
	}


	//파일 저장
	public void saveToFile(List<Person> selectAllPerson, String file_name) {
		try(java.io.FileWriter fw = new java.io.FileWriter(file_name)){
			for(Person p : selectAllPerson) {
				fw.write(p.getName() + "\t" + p.getAddress() + "\t" + p.getPhone() + "\n");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
		
	
}
