package rentcar;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rentcar.reservation.ResDao;

public class CheckReservation extends JFrame {
	String[] columnNames = {"예약번호", "고객번호", "차량번호", "대여시작일", "대여종료일"}; // 컬럼명
	
	public CheckReservation() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		
		Label l1 = new Label("차량번호를 입력하세요");
		//add(title);
		add(l1);
		
		l1.setBounds(40, 40, 60, 40);
		
		add(p);
		setSize(500, 500);
		setTitle("예약내역 조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼
		setVisible(true);
		
		ResDao dao = new ResDao();
		dao.searchReservation();
	}
}
