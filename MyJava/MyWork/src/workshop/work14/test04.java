package workshop.work14;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static common.JDBCTemplate.*;

public class test04 {

	public static void main(String[] args) {
		
		Connection conn = getConnection(); //연결
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;


		Date nowDate = new Date(System.currentTimeMillis());

		try {
		
			String select = "select pdno, pdname, pdsubname, factno, pddate, pdcost, pdprice, pdamount"
					+ "from product join factory using(factno)"
					+ "where facloc = 'CHANGWON'";
			String insert = "insert into discarded_product((PDNO, PDNAME, PDSUBNAME, FACTNO, PDDATE, PDCOST, PDPRICE, PDAMOUNT, DISCARDED_DATE)) values(?,?,?,?,?,?,?,?,?)";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select);
			pstmt = conn.prepareStatement(insert);
			
			while(rs.next()) {
				pstmt.setInt(1, rs.getInt("pdno"));
				pstmt.setString(2, rs.getString("pdname"));
				pstmt.setString(3, rs.getString("pdsubname"));
				pstmt.setInt(4, rs.getInt("factno"));
				pstmt.setDate(5, rs.getDate("pddate"));
				pstmt.setInt(6, rs.getInt("pdcost"));
				pstmt.setInt(7, rs.getInt("pdprice"));
				pstmt.setDate(8, nowDate);
			}
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.printf("%d개의 데이터가 정상적으로 INSERT 되었습니다.", result);
				commit(conn);  
				
			}else {
				rollback(conn);
			}
		} catch (SQLException e) {
			rollback(conn);
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
