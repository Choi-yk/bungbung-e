package rentcar;

import java.awt.Label;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Car extends JFrame {
	public Car() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);

		//
		Label l1 = new Label("차량번호");
		Label l2 = new Label("고객명");
		add(l1);
		add(l2);

		// 텍스트 필드
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		add(t1);
		add(t2);

		// 버튼
		JButton j1 = new JButton("등록");
		JButton j2 = new JButton("취소");
		add(j1);
		add(j2);
		
		l1.setBounds(40, 40, 40, 40);
		l2.setBounds(40, 100, 40, 40);
		
		t1.setBounds(160, 40, 200, 40);
		t2.setBounds(160, 100, 200, 40);
		
		add(p);
		setSize(500, 500);
		setTitle("차량 등록 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼
		setVisible(true);
	}
}