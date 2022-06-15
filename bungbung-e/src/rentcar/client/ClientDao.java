package rentcar.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//������
public class ClientDao {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/rentdb";
	String userid = "root";
	String password = "1234";

	Connection conn = null; // �����ͺ��̽� �����ϴ� ��ü
	PreparedStatement pstmt = null; // �������� ������ �����ϴ� ��ü
	ResultSet rs = null; // ����� ��ȯ�޴� ��ü

	public int insertClient(String clientNum, String clientName, String phoneNumber, String drivers_license,
			String insurance) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userid, password);

			String query = "insert into Client(clientNum, clientName, phoneNumber, drivers_license, insurance) values(?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, clientNum);
			pstmt.setString(2, clientName);
			pstmt.setString(3, phoneNumber);
			pstmt.setString(4, drivers_license);
			pstmt.setString(5, insurance);
			
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
