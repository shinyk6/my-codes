package com.myExam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import static common.JDBCTemplate.*;
public class Fibonacci_proc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("피보나치 몇개까지?: ");
		int place = sc.nextInt();
		
		// 연결확인
		Connection conn = getConnection();
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		String sql = "{ call 04_Fibonacci_CTE(?) }";
		
		try {
			cstmt = conn.prepareCall(sql);

			cstmt.setInt(1, place); // IN

			rs = cstmt.executeQuery();
			
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(metaData.getColumnLabel(i));
				if (i < columnCount) {
					System.out.print(" | ");
				}
			}
			System.out.println();
 			
			while (rs.next()) {
				int number = rs.getInt("항번호");
				int fibNumber = rs.getInt("피보나치 수열");
				System.out.printf("%3d\t%3d\n", number, fibNumber);
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
