package rentcar.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/rentdb";
	String userid = "root";
	String password = "1234";

	Connection conn = null; // 데이터베이스 연결하는 객체
	PreparedStatement pstmt = null; // 쿼리문을 보내고 실행하는 객체
	ResultSet rs = null; // 결과를 반환받는 객체

	public void searchReservation() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);

			String query = "select * from Reservation order by resNum";
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
			rs.next();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
