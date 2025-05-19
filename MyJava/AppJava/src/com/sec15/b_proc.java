package com.sec15;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

import static common.JDBCTemplate.*; //static 멤버들은 모두 import하면 클래스.메소드와같이 클래스명을 명시하지 않아도 됨
									//static import : 자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출!!
									//단점 : 한 클래스내에 동일한 이름의 멤버가 있을 때는 충돌남


public class b_proc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제 할 사원 번호");
		int empno = sc.nextInt();
		
		//연결 확인
		Connection conn = getConnection(); //정적메소드
		CallableStatement cstmt = null;
		
		try {
			String sql = "{ call PRO02_DELETE(?) }"; // 간혹 인식이 안될 때가 있어서 { } 띄우기2
			cstmt = conn.prepareCall(sql); // 구문 준비
			cstmt.setInt(1, empno); // 바인딩
			
			cstmt.execute(); //프로시저 실행
			System.out.println("삭제 했어 !!!");
			commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Close(conn); //정적메소드
		}
	}

}
		
		