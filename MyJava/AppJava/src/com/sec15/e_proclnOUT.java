package com.sec15;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.*; //static 멤버들은 모두 import하면 클래스.메소드와같이 클래스명을 명시하지 않아도 됨
									//static import : 자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출!!
									//단점 : 한 클래스내에 동일한 이름의 멤버가 있을 때는 충돌남


public class e_proclnOUT {

	public static void main(String[] args) {
		//연결 확인
		Connection conn = getConnection(); //정적메소드
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		
		try {
			String sql = " { call PRO09_SALARY_BONUS(?) }";
			cstmt = conn.prepareCall(sql); //쿼리 준비
			
			int empno = 3;
			//데이터 바인딩
			cstmt.setInt(1, empno); //IN 부분
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER); //OUT 부분
			
			
			//실행
			cstmt.execute();
			
			//결과 - OUT 부분 리턴 값 출력
			int res = cstmt.getInt(1);
			System.out.println("사원 번호 : " + empno + "의 예상 보너스 = " + res);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Close(cstmt);
			Close(conn); //정적메소드
		}
	}

}
		
		