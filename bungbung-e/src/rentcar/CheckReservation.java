package rentcar;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import rentcar.reservation.ResDao;

public class CheckReservation extends JFrame {
	String[] columnNames = {"예약번호", "고객번호", "차량번호", "대여시작일", "대여종료일"}; // 컬럼명
	
	public CheckReservation() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		
		Label l1 = new Label("고객번호를 입력하세요");
		add(l1);
		
		// 텍스트 필드
		TextField t1 = new TextField();
		add(t1);
		
		JButton searchBtn = new JButton("조회"); // select문
		JButton updateBtn = new JButton("수정"); // update문
		add(searchBtn);
		add(updateBtn);
		
		l1.setBounds(20, 20, 150, 40);
		
		t1.setBounds(170, 20, 150, 40);
		
		searchBtn.setBounds(340, 20, 60, 40);
		updateBtn.setBounds(400, 20, 60, 40);
		
		add(p);
		setSize(500, 500);
		setTitle("예약내역 조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼
		setVisible(true);
		
		searchBtn.addActionListener(new ActionListener() {
			// 조회 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				String clientNum = t1.getText();
				
				ResDao dao = new ResDao();
				int result = dao.searchReservation(clientNum);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "예약내역 조회에 실패했습니다. 고객번호를 다시 입력해주세요.");
				} 
				
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			// 수정 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
//				ResDao dao = new ResDao();
//				int result = dao.updateRentDate(resNum, rent_start, rent_end);
//				if (result != 0) {
//					JOptionPane.showMessageDialog(null, "대여 종료일이 수정 되었습니다.");
//				} else {
//					JOptionPane.showMessageDialog(null, "수정에 실패했습니다.");
//				}
			}
		});
		
		
	}
}
