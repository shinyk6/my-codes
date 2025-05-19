package com.sec14;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class e_insertPrepared {

		public static void main(String[] args) {
			
			//1. 연결
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				
				String url = "jdbc:mysql://localhost:3306/my_emp";
				String user = "uk60";
				String password = "thdbsWkd123";
			    conn =
			    //  DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" +  "user=uk60&password=thdbsWkd123");
			    
			       DriverManager.getConnection(url, user, password);
			    
			    if(!conn.isClosed()) { //연결이 되고 있는지 아닌지 확인
			    	System.out.println("연결 중이야");
			    }
			    
			    
			    
			 //2. 명령수행  : 사원번호, 이름, 봉급를 매개변수를 이용해서 코드를 구현하자.
			    
			    ///////////////////// 2-1 	insert -> PreparedStatement 사용
			    conn.setAutoCommit(false);
			    int empno = 2;
			    String ename = "홍길동";
			    double sal = 5500; //알아서 캐스팅 5500.0
			    
			    
			    String sql_insert = "insert into emp(empno, ename, sal) values(?,?,?)";
			    																		
			    pstmt = conn.prepareStatement(sql_insert); // 준비된 구문
			    
			    // sql_insert 매개변수에 값 전달 및 변경 코드
			    pstmt.setInt(1, empno);  // 매개변수 바인딩
			    pstmt.setString(2, ename);
			    pstmt.setDouble(3, sal);
			    
			    int res = pstmt.executeUpdate();
			    
			    if(res > 0) {
			    	conn.commit();
			    }else {
			    	System.out.println("쿼리 이상해!! 롤백이야");
			    	conn.rollback();
			    }
			    
			    
			    ///////////////////// 2-2 	select 예제
			    String sql = "select * from emp";
			    rs = pstmt.executeQuery(sql); //pstmt가 prepareStatement의 자식이기에 sql이 매개인자로 들어가도 됨
			    
			//3. 결과 출력
			    while(rs.next()) { //next : 뒤에 값이 존재하면 true, 없으면 false / 한줄의 토플을 읽고 true 나 false를 리턴함
			    	System.out.println(rs.getString("empno") + "\t" + rs.getString("ename") + "\t" + rs.getString("sal"));
			    }
			    
			} catch (SQLException ex) {
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}finally {
				try {
					rs.close(); // 나중에 선언한 것부터 먼저 닫음
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
