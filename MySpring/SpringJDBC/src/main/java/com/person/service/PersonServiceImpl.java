package com.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.dao.PersonDao;
import com.person.dao.PersonDaoImpl;
import com.person.model.Person;


@Service
public class PersonServiceImpl implements PersonService {

//	private PersonDao dao = new PersonDaoImpl();
	
	@Autowired
	private PersonDao dao;
	
	
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
