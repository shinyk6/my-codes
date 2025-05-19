package com.sec14;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class c_insert {

		public static void main(String[] args) {
			
			//1. 연결
			Connection conn = null;
			Statement stmt = null;
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
			 //2. 명령수행
			    stmt = conn.createStatement();
			    ///////////////////// 2-1 	insert 예제
			    conn.setAutoCommit(false);
			    String sql_insert = "insert into emp(ename) values('정길동')";
			   
			    int res = stmt.executeUpdate(sql_insert);
			    if(res > 0) {
			    	conn.commit();
			    }else {
			    	System.out.println("쿼리 이상해!! 롤백이야");
			    	conn.rollback();
			    }
			    
			    
			    ///////////////////// 2-2 	select 예제
			    String sql = "select * from emp";
			    rs = stmt.executeQuery(sql);
			    
			//3. 결과 출력
			    while(rs.next()) { //next : 뒤에 값이 존재하면 true, 없으면 false / 한줄의 토플을 읽고 true 나 false를 리턴함
			    	System.out.println(rs.getString("ename") + "\t" + rs.getDouble(6)); //ename컬럼과 6번째의 컬럼을 가져옴. (empno, sal) 계산할 때 -> getType으로 타입 명시
			    																//그냥 출력-> getString
			    }
			    
			} catch (SQLException ex) {
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}finally {
				try {
					rs.close(); // 나중에 선언한 것부터 먼저 닫음
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
