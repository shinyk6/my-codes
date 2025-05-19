package com.person.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.person.model.Person;
import static common.JDBCTemplate.*;

//DB CRUD
// view -> controller -> dao [JDBCTemplate] -> db
// view <- controller <- dao [JDBCTemplate] <- db
public class PersonDaoImpl implements PersonDao{
	
	///1. insert  //insert코드와 delete, update 코드 모두 비슷함
	public int insertPerson(Person p) { //execute로 리턴받을 경우 int자리에 boolean
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(insert_sql);//쿼리 준비
			//데이터 바인딩
			pstm.setString(1, p.getName()); //Person에 들어온 name값
			pstm.setString(2, p.getAddress());
			pstm.setString(3, p.getPhone());
			
			res = pstm.executeUpdate();
			commit(conn);
			
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}
	
	///2. delete // insert코드와 동일
	public int deletePerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(delete_sql);//쿼리 준비
			//데이터 바인딩
			pstm.setString(1, p.getName()); //Person에 들어온 name값
			
			res = pstm.executeUpdate();
			commit(conn);
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}
	
	///3. update // insert코드와 동일하지만 쿼리의 순서가 다름
	public int updatePerson(Person p) {
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(update_sql);//쿼리 준비
			//데이터 바인딩
			pstm.setString(3, p.getName()); //update쿼리문에서 ?위치가 address:1 phone:2 name:3 순서임
			pstm.setString(1, p.getAddress());
			pstm.setString(2, p.getPhone());
			
			res = pstm.executeUpdate(); // 실행
			commit(conn);
			
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(pstm);
			Close(conn);
		}
		return res;
	}
	
	
	///4. select
	public List<Person> selectAllPerson() { //view단에서 foreach로 리스트를 뿌려줌
		
		/*
		 *  모든 select 결과를 rs객체의 next()로 한줄 씩 읽고, 각각의 속성을 person클래스로 담아서 List<>객체로 add하여 리턴
		 */
		
		List<Person> all = new ArrayList<>(); //전체 레코드를 Person으로 담아서 리턴
		Connection conn = getConnection(); //연결
		Statement stmt = null; // 명령 객체 선언
		ResultSet rs = null; // 명령 실행 결과 select를 참조할 객체
		Person person = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			
		//	case 1 : 매개인자 생성자(오버로드 생성자) 로 값을 전달 후 add
		/*		while(rs.next()) { // 로우데이터가 '있으면' 한줄 씩 읽어서 '리턴'해줘
				
				all.add(new Person( // 한줄 읽어서 Person에(생성자) 담아서 List에 add, 한줄 읽어서 Person에 담아서 List에 add ....반복
						rs.getString(1), //db의 attribute 인덱스 1 읽음 - name
						rs.getString(2), // address
						rs.getString("phone") // phone
						
				));		// 리턴한 row의 각 속성들을 person에 담아서 List에 add한다.
			}
		*/	
		//	case 2 : 기본 생성자 객체 생성 후 setter로 값 전달 후 add
			while(rs.next()) { 
				person = new Person();
				person.setAddress(rs.getString(2));
				person.setName(rs.getString(1));
				person.setPhone(rs.getString("phone"));
				
				all.add(person);
			
			}
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}
		
		
		return all;
	}

	@Override
	public Person searchByName(Person p) {
		Connection conn = getConnection(); //연결
		PreparedStatement pstmt = null; // 명령 객체 선언
		ResultSet rs = null; // 명령 실행 결과 select를 참조할 객체
		Person person = null;
		
		try {
			pstmt = conn.prepareStatement(find_sql); //쿼리 준비 ?플레이스 홀더가 있기에 prepareStatement사용
			pstmt.setString(1, p.getName()); //데이터 바인딩
			
			rs = pstmt.executeQuery(); //실행
			
			while(rs.next()) { 
				person = new Person();
				person.setAddress(rs.getString(2));
				person.setName(rs.getString(1));
				person.setPhone(rs.getString("phone"));
			}
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			Close(rs);
			Close(pstmt);
			Close(conn);
		}
		
		
		return person;
	}

	@Override
	public List<Person> getPersonByPage(int page, int size) { //페이징 처리
		List<Person> all = new ArrayList<>();
		Connection conn = getConnection(); //연결
		PreparedStatement pstmt = null; // 명령 객체 선언
		ResultSet rs = null; // 명령 실행 결과 select를 참조할 객체
		Person person = null;
		
		try {
			pstmt = conn.prepareStatement(page_sql); //쿼리 준비 ?플레이스 홀더가 있기에 prepareStatement사용
			pstmt.setInt(1, size); //데이터 바인딩
			pstmt.setInt(2, (page-1)*size); //OFFEST 공식
			rs = pstmt.executeQuery(); //실행
			
			while(rs.next()) { 
				person = new Person();
				person.setAddress(rs.getString(2));
				person.setName(rs.getString(1));
				person.setPhone(rs.getString("phone"));
				all.add(person);
			}
		}catch(Exception e) {
			System.out.println(e);
			
		}finally {
			Close(rs);
			Close(pstmt);
			Close(conn);
		}
		
		return all;
	}
	
	
}
