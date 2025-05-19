package com.person.service;

import java.util.List;

import com.person.model.Person;

// view - controller - model (Service(biz), Dao) -> db
public interface PersonService { 
	//biz X
	//Dao O
	List<Person> selectAllPerson(); //dao와 biz메소드명과 다른이름으로 지정해도 되지만, 동일한 이름으로 지정해야 헷갈리지 않음 
	int insertPerson(Person p);
	int updatePerson(Person p);
	int deletePerson(Person p);
	Person searchByName(Person p);
	List<Person> getPersonByPage(int page, int size);

}
