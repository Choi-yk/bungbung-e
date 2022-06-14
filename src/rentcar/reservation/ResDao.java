package rentcar.reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/rentdb";
	String userid = "root";
	String password = "1234";

	Connection conn = null; // 데이터베이스 연결하는 객체
	PreparedStatement pstmt = null; // 쿼리문을 보내고 실행하는 객체
	ResultSet rs = null; // 결과를 반환받는 객체
	
	// 예약목록 조회
	public ArrayList<ResDto> searchReservation(String clientNum) {
		ArrayList<ResDto> searchList = new ArrayList<ResDto>();
		System.out.println(searchList);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);

			String query = "select * from Reservation where clientNum = ? order by resNum";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setNString(1, clientNum);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				ResDto dto = new ResDto();
				
				dto.setResNum(rs.getString("resNum"));
				dto.setClientNum(rs.getString(1));
				dto.setCarNum(rs.getString("carNum"));
				dto.setRent_start(rs.getString("rent_start"));
				dto.setRent_end(rs.getString("rent_end"));
				
				searchList.add(dto);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("오류");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return searchList;

	}

	public int insertReservation(String resNum, String clientNum, String carNum, String rent_start, String rent_end) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);

			String query = "insert into Reservation(resNum, clientNum, carNum, rent_start, rent_end) values(?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, resNum);
			pstmt.setString(2, clientNum);
			pstmt.setString(3, carNum);
			pstmt.setString(4, rent_start);
			pstmt.setString(5, rent_end);

			int result = pstmt.executeUpdate(); // insert, delete, update문 실행

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

	public int updateRentDate(String resNum, String rent_end) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);

			String query = "update Reservation set rent_end = ? where resNum = ?";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, rent_end);
			pstmt.setString(2, resNum);

			int result = pstmt.executeUpdate(); // insert, delete, update문 실행

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
