package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.*; //static 멤버들은 모두 import하면 클래스.메소드와같이 클래스명을 명시하지 않아도 됨
									//static import : 자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출!!
									//단점 : 한 클래스내에 동일한 이름의 멤버가 있을 때는 충돌남


public class d_proc {

	public static void main(String[] args) {
		//연결 확인
		Connection conn = getConnection(); //정적메소드
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		
		try {
			String sql = " { call PRO06_SELECTALL() }";
			cstmt = conn.prepareCall(sql);
			rs = cstmt.executeQuery();
			
			//출력
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				int deptno = rs.getInt("deptno");
				
				System.out.printf("%5d %10s %5d \n", empno, name, deptno);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Close(rs);
			Close(conn);
			Close(conn); //정적메소드
		}
	}

}
		
		