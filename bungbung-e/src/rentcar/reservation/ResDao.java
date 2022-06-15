package rentcar.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdatepicker.JDatePicker;

public class ResDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/rentdb";
	String userid = "root";
	String password = "1234";

	Connection conn = null; // �����ͺ��̽� �����ϴ� ��ü
	PreparedStatement pstmt = null; // �������� ������ �����ϴ� ��ü
	ResultSet rs = null; // ����� ��ȯ�޴� ��ü

	public int searchReservation(String clientNum) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);

			String query = "select * from Reservation where clientNum = ? order by resNum";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setNString(1, clientNum);

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
		
		return 0;
	}

	public int insertReservation(String resNum, String clientNum, String carNum, JDatePicker rent_start) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);

			String query = "insert into Reservation(resNum, clientNum, carNum, rent_start, rent_end) values(?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, resNum);
			pstmt.setString(2, clientNum);
			pstmt.setString(3, carNum);
			pstmt.setString(4, rent_start);
			//pstmt.setString(5, rent_end);

			int result = pstmt.executeUpdate(); // insert, delete, update�� ����

			return result;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
		
	}

	public int updateRentDate(String resNum, String rent_start, String rent_end) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);

			String query = "update Reservation set rent_start = ?, rent_end = ? where resNum = ?";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, rent_start);
			pstmt.setString(2, rent_end);
			pstmt.setString(3, resNum);

			int result = pstmt.executeUpdate(); // insert, delete, update�� ����

			return result;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 0;
	}

}
