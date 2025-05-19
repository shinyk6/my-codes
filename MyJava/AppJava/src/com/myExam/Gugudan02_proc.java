package com.myExam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static common.JDBCTemplate.*;
public class Gugudan02_proc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 단 입력: ");
		int place = sc.nextInt();
		
		// 연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql = "{ call 03_GuGuDan(?) }";
		
		try {
			cstmt = conn.prepareCall(sql);
			
			cstmt.setInt(1, place); // IN

			rs = cstmt.executeQuery();
 			
			while (rs.next()) {
				String line = rs.getString("GuGuDan_PRN");
				System.out.println(line);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Close(rs);
			Close(cstmt);
			Close(conn);
		}

	}

}
