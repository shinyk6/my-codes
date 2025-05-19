package com.student.dao;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.student.model.Student;

public class StudentDaoImpl implements StudentDao {
	
	@Override
	public int insertStudent(Student s) { // 학생 정보 insert
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(insert_sql,Statement.RETURN_GENERATED_KEYS);
			//SQL 실행 후 auto_increment로 
			//자동으로 생성된 키(id)를 받아올 수 있는 기능 : PremparedStatement에 존재하는 getGeneratedKey()
			
			pstm.setString(1, s.getName());
			pstm.setString(2, s.getMajor());
			pstm.setInt(3, s.getGrade());

			
			res = pstm.executeUpdate();
	
			ResultSet rs = pstm.getGeneratedKeys(); //getGeneratedKey()로 키 가져오기

			if(rs.next()) {
				int generatedId = rs.getInt(1);
				s.setId(generatedId); //Student객체에 id 세팅
			}

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
	

	@Override
	public int deleteStudent(Student s) { //학생 정보 delete
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(delete_sql);
	
			pstm.setInt(1, s.getId()); //Student에 들어온 Id
			
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

	@Override
	public int updateStudent(Student s) { //학생 정보 update
		Connection conn = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = conn.prepareStatement(update_sql);
			
			pstm.setString(1, s.getMajor());
			pstm.setInt(2, s.getGrade());
			pstm.setInt(3, s.getId());

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



	@Override
	public List<Student> selectAllStudent() { // 학생 정보 전체 select
		Connection conn = getConnection();
		List<Student> all = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		Student student = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			
			while(rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString(2));
				student.setMajor(rs.getString("major"));
				student.setGrade(rs.getInt(4));
				
				all.add(student);
				
			}
			
		} catch (SQLException e) {
			System.out.println(e);
		}finally {
			Close(rs);
			Close(stmt);
			Close(conn);
		}

		return all;
	}

}
