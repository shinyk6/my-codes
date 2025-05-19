package com.sec15;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;

import static common.JDBCTemplate.*; //static 멤버들은 모두 import하면 클래스.메소드와같이 클래스명을 명시하지 않아도 됨
									//static import : 자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출!!
									//단점 : 한 클래스내에 동일한 이름의 멤버가 있을 때는 충돌남


public class a_proc {

	public static void main(String[] args) {
		//연결 확인
		Connection conn = getConnection(); //정적메소드
		CallableStatement cstmt = null;
		
		try {
			String sql = "{ call PRO01_INSERT() }"; //원래는 my_emp.PRO01_INSERT()이지만 이미 my_emp로 접속중이기에 생략 가능
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.execute(); //프로시저 실행
			commit(conn); // JDBCTemplate에 commit, rollback, close존재 (원래는 jdbc-Connection에 있음)
			
		} catch (SQLException e) {
			rollback(conn); //예외 발생 시 롤백
			e.printStackTrace();
		}finally {
			Close(cstmt);
			Close(conn); //정적메소드
		}
	}

}
		
		