package rentcar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SelectMenu extends JFrame {
	public SelectMenu() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);

		JButton j1 = new JButton("고객 등록");
		JButton j2 = new JButton("예약하기");
		JButton j3 = new JButton("예약내역 확인");
		add(j1);
		add(j2);
		add(j3);

		j1.setBounds(90, 40, 300, 60);
		j2.setBounds(90, 140, 300, 60);
		j3.setBounds(90, 240, 300, 60);

		add(p);
		setSize(500, 500);
		setTitle("메인메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼
		setVisible(true);
		
		j1.addActionListener(new ActionListener() {
			// 고객 등록 화면으로 이동
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 고객등록 화면으로 창 전환
				Client client = new Client();
			}
		});
		
		j2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		j3.addActionListener(new ActionListener() {
			// 예약내역 확인 화면으로 이동
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				CheckReservation cr = new CheckReservation();
			}
		});
	}
}
