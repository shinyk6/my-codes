package com.myExam;


import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.*;


public class Getemp_proc {


	public static void main(String[] args) {
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = " { call GetEmp_Res() }";
			cstmt = conn.prepareCall(sql);
			rs = cstmt.executeQuery();
			
			//출력
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int mgr = rs.getInt("mgr");
				int level = rs.getInt("level");
				
			
				System.out.println( empno + "\t" + ename + "\t" + mgr + "\t" +  level );
				
			}
			commit(conn);
			
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			Close(cstmt);
			Close(conn);
		}
		
		
	}

}
