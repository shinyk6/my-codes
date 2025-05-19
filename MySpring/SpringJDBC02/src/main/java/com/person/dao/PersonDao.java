package com.person.dao;

import java.util.List;

import com.person.model.Person;

public interface PersonDao{
	String insert_sql = "insert into person(name, address, phone) values (?,?,?)"; //쿼리는 상수로 만듦
	String update_sql = "update person set address=?, phone=? where name=? ";
	String delete_sql = "delete from person where name=?";
	String select_sql = "select name, address, phone from Person";
	String find_sql = "select name, address, phone from person where name=?";
	String page_sql = "select name, address, phone from person limit ? offset ?";
	
	public int deletePerson(Person p);
	public int insertPerson(Person p);
	public int updatePerson(Person p);
	public List<Person> selectAllPerson();
	public Person searchByName(Person p);
	public List<Person> getPersonByPage(int page, int size);
}
