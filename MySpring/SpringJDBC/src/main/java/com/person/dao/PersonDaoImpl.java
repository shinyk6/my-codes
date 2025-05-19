package com.person.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.person.model.Person;

//DB CRUD
// view -> controller -> dao [JDBCTemplate] -> db
// view <- controller <- dao [JDBCTemplate] <- db

@Repository
public class PersonDaoImpl implements PersonDao {

	// getConnection 말고 JDBCTemplate사용

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { //필드주입하면 이 코드와 같음
	 * this.jdbcTemplate = jdbcTemplate; }
	 */

	/// 기본 CRUD
	/// 1. insert //insert코드와 delete, update 코드 모두 비슷함 : update(String sql,
	/// Object... args)
	public int insertPerson(Person p) { // execute로 리턴받을 경우 int자리에 boolean
		return jdbcTemplate.update(insert_sql, p.getName(), p.getAddress(), p.getPhone());
	}

	/// 2. delete // insert코드와 동일 : update(String sql, Object... args)
	public int deletePerson(Person p) {
		return jdbcTemplate.update(delete_sql, p.getName());
	}

	/// 3. update // insert코드와 동일하지만 쿼리의 순서가 다름 : update(String sql, Object... args)
	public int updatePerson(Person p) {
		return jdbcTemplate.update(update_sql, p.getAddress(), p.getPhone(), p.getName());
	}

	private RowMapper<Person> personRowMapper = (rs, rowNum) -> new Person(rs.getString("name"),
																		   rs.getString("address"), 
																		   rs.getString("phone"));
									

	/// 4. select All : query(String sql, RowMapper<T> rowMapper) - jdbc.core의
	/// rowMapper(I): 함수형 인터페이스(람다형식으로 사용)
	public List<Person> selectAllPerson() {
		return jdbcTemplate.query(select_sql, personRowMapper);
	}

	@Override
	public Person searchByName(Person p) {
		return jdbcTemplate.queryForObject(find_sql, personRowMapper, p.getName()); //리턴이 Person객체로 됨???
	}

	@Override
	public List<Person> getPersonByPage(int page, int size) { // 페이징 처리
		return null;
	}

}
