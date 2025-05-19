package workshop.work14;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static common.JDBCTemplate.*;

public class test02 {

	public static void main(String[] args) {
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection(); //연결
		
		try {
			stmt = conn.createStatement();
			String sql = "select pdsubname, pdcost, pdprice\r\n"
					+ "from product\r\n"
					+ "where (PDCOST>all(select min(PDCOST) from product where PDNAME='TV')) and "
					+ "(PDCOST<all(select max(PDCOST) from product where PDNAME='CELLPHONE'))";
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("제품명 \t 제품원가 \t 제품가격");
			System.out.println("-----------------------------------");
			while(rs.next()) {
				System.out.printf("%5s %5s %5s \n",rs.getString("pdsubname"),rs.getInt("pdcost"),
						rs.getInt("pdprice"));
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
