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
		Label l1 = new Label("������ȣ");
		Label l2 = new Label("����");
		add(l1);
		add(l2);

		// �ؽ�Ʈ �ʵ�
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		add(t1);
		add(t2);

		// ��ư
		JButton j1 = new JButton("���");
		JButton j2 = new JButton("���");
		add(j1);
		add(j2);
		
		l1.setBounds(40, 40, 40, 40);
		l2.setBounds(40, 100, 40, 40);
		
		t1.setBounds(160, 40, 200, 40);
		t2.setBounds(160, 100, 200, 40);
		
		add(p);
		setSize(500, 500);
		setTitle("���� ��� ȭ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư
		setVisible(true);
	}
}