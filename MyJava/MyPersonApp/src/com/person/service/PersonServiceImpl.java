package com.person.service;

import java.util.List;

import com.person.dao.PersonDao;
import com.person.dao.PersonDaoImpl;
import com.person.model.Person;

//biz, dao 관리 및 구현
// 현재 Person 테이블의 insert값은 계산형 데이터 또는 로직이 없어서 dao만 호출되어 controller, db연동된다.
// controller -> service(biz X, dao O) -> db 
public class PersonServiceImpl implements PersonService {

	private final PersonDao dao = new PersonDaoImpl();
	@Override
	public List<Person> selectAllPerson() {
		// TODO Auto-generated method stub
		return dao.selectAllPerson();
	}

	@Override
	public int insertPerson(Person p) {
		// TODO Auto-generated method stub
		return dao.insertPerson(p);
	}

	@Override
	public int updatePerson(Person p) {
		// TODO Auto-generated method stub
		return dao.updatePerson(p);
	}

	@Override
	public int deletePerson(Person p) {
		// TODO Auto-generated method stub
		return dao.deletePerson(p);
	}

	@Override
	public Person searchByName(Person p) {
		// TODO Auto-generated method stub
		return dao.searchByName(p);
	}

	@Override
	public List<Person> getPersonByPage(int page, int size) { //나중에는 INTEGER객체로 받음
		// TODO Auto-generated method stub
		return dao.getPersonByPage(page, size);
	}
	
}
