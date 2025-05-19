package com.sec15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

import static common.JDBCTemplate.*; //static 멤버들은 모두 import하면 클래스.메소드와같이 클래스명을 명시하지 않아도 됨
									//static import : 자주 사용하는 정적 메소드를 클래스명 없이 참조해서 바로 호출!!
									//단점 : 한 클래스내에 동일한 이름의 멤버가 있을 때는 충돌남


//사원 번호와 이름을 입력받아  수정해보자.	3번의 이름을 홍길동으로 변경
public class c_proc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정 될 사원 번호 : ");
		int empno = sc.nextInt();
		sc.nextLine(); // 개행제거
		
		System.out.print("수정될 사원이름 : ");
		String ename = sc.nextLine();	
		
		//연결 확인
		Connection conn = getConnection(); //정적메소드
		CallableStatement cstmt = null;
		
		
		try {
			String sql = "{ call PRO03_UPDATE(?,?) }";
			cstmt = conn.prepareCall(sql); //구문 준비
			cstmt.setInt(1, empno);
			cstmt.setString(2, ename);

			cstmt.executeUpdate(); //프로시저 실행
			System.out.println("수정 했어 !!!");
			commit(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Close(conn); //정적메소드
		}
	}

}
		
		