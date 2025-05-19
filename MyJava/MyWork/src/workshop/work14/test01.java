package workshop.work14;
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class test01 {

	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection(); //연결
		
		try {
			stmt = conn.createStatement();
			String sql = "select pdname, pdsubname, facname, stoname, stamount\r\n"
					+ "from product join factory using(factno) join store using (PDNO)\r\n"
					+ "where stamount = 0 and facname like 'SEOUL%'";
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("제품카테고리 \t 제품명 \t 공장명 \t 판매점명 \t 판매점재고수량");
			System.out.println("-------------------------------------------------------");
			while(rs.next()) {
				System.out.printf("%7s %15s %15s %8s %5d\n",rs.getString("pdname"),rs.getString("pdsubname"),
						rs.getString("facname"),rs.getString("stoname"),rs.getInt("stamount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		
	}

}
