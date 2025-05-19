package common; //모든 곳에서 공통으로 쓸 수 있는 jdbc템플릿

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


// DB 연결 생성, 자원 해제(Connection, Statement, ResultSet), 트랜잭션 처리(commit, rollback)를 일관되게 수행하는 유틸리티 클래스
public class JDBCTemplate {
	
	/// case 1 : DB 연결 하결 하는 곳
	/*
	 * // DB연결 하는 곳 public static Connection getConnection() { //계속 연결하는게 아니라 연결하고
	 * 끊기 때문에 static 사용 Connection conn = null; try { String url =
	 * "jdbc:mysql://localhost:3306/my_emp"; String user = "uk60"; String password =
	 * "thdbsWkd123"; conn = //
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/my_emp?" +
	 * "user=uk60&password=thdbsWkd123");
	 * 
	 * DriverManager.getConnection(url, user, password);
	 * 
	 * conn.setAutoCommit(false); // 트랜잭션 수동 설정
	 * 
	 * if(!conn.isClosed()) { System.out.println("연결 중이야");
	 * 
	 * }
	 * 
	 * }catch(Exception e) { System.out.println(e); } return conn; }
	 */
	
	/// case 2 : DB 연결 하결 하는 곳_properties 파일로 로드하는 법
	public static Connection getConnection() { 
		Connection conn = null; 
		Properties prop = new Properties();
		
		try (InputStream input = JDBCTemplate.class.getClassLoader().getResourceAsStream("db.properties")){
			if (input == null) {
				throw new RuntimeException("db.properties 파일 없어!!!!");
			}
			
			prop.load(input); //input을 읽음
			
			String driver = prop.getProperty("driver"); //키값으로 value를 부름
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			
			Class.forName(driver);	//jdk 버전 상관없이 리소스 로드 할 때 반드시 명시!!
			conn = DriverManager.getConnection(url, user, password);
			
			conn.setAutoCommit(false); // 트랜잭션 수동 설정
		 
		//	if(!conn.isClosed()) { 

		//	 System.out.println("연결 완료");
		//	}
		 
		 }catch(Exception e){ 
			 
			 System.out.println(e); 
		 } 
			return conn; 	
	}
	
	
	
	
	// 1. DB close 하는 곳
	public static void Close(Connection con) { // 메이커 측 close가 소문자이기에 대문자 Close단어 사용
		if(con != null) {
			try {
				con.close();
				//con = null;  non-static일때 명시
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("데이터베이스 연결 닫기 오류 : " + e.getSQLState() + "\t" + e.getMessage());
			}//try
		}//if
	}//method
	
	
	// 2. statement close하는 곳
	public static void Close(Statement stmt) { // 메이커 측 close가 소문자이기에 대문자 Close단어 사용
		if(stmt != null) {
			try {
				stmt.close();
				//con = null;  non-static일때 명시
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("명령 오류 : " + e.getSQLState() + "\t" + e.getMessage());
			}//try
		}//if
	}//method
	
	
	// 3. ResultSet close하는 곳
	public static void Close(ResultSet res) { // 메이커 측 close가 소문자이기에 대문자 사용
		if(res != null) {
			try {
				res.close();
				//con = null;  non-static일때 명시
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("쿼리 리턴 오류 : " + e.getSQLState() + "\t" + e.getMessage());
			}//try
		}//if
	}//method
	
	
	// 4. 트랜잭션 처리(commit, rollback)
	// 4-1. commit
	public static void commit(Connection con) { // 메이커 측 close가 소문자이기에 대문자 Close단어 사용
		if(con != null) {
			try {
				con.commit();
				//con = null;  non-static일때 명시
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("데이터베이스 연결 닫기 오류 : " + e.getSQLState() + "\t" + e.getMessage());
			}//try
		}//if
	}//method
	
	
	// 4-2. rollback
	public static void rollback(Connection con) { // 메이커 측 close가 소문자이기에 대문자 Close단어 사용
		if(con != null) {
			try {
				con.rollback();
				//con = null;  non-static일때 명시
			} catch (SQLException e) {
				//e.printStackTrace();
				System.out.println("데이터베이스 연결 닫기 오류 : " + e.getSQLState() + "\t" + e.getMessage());
			}//try
		}//if
	}//method	
	
	
	
	
	
	
	
}
