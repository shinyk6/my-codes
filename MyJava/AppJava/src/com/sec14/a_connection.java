package com.sec14;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class a_connection {

		public static void main(String[] args) {

			Connection conn = null;
			try {
				
				String url = "jdbc:mysql://localhost:3306/my_emp";
				String user = "uk60";
				String password = "thdbsWkd123";
			    conn =
		//	       DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" +  "user=uk60&password=thdbsWkd123");
			    
			       DriverManager.getConnection(url, user, password);
			    
			    if(!conn.isClosed()) { //연결이 되고 있는지 아닌지 확인
			    	System.out.println("연결 중이야");
			    }
			    
			} catch (SQLException ex) {
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}