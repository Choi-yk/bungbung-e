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

		JButton j1 = new JButton("�� ���");
		JButton j2 = new JButton("�����ϱ�");
		JButton j3 = new JButton("���೻�� Ȯ��");
		add(j1);
		add(j2);
		add(j3);

		j1.setBounds(90, 40, 300, 60);
		j2.setBounds(90, 140, 300, 60);
		j3.setBounds(90, 240, 300, 60);

		add(p);
		setSize(500, 500);
		setTitle("���θ޴�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư
		setVisible(true);
		
		j1.addActionListener(new ActionListener() {
			// �� ��� ȭ������ �̵�
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // ����� ȭ������ â ��ȯ
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
			// ���೻�� Ȯ�� ȭ������ �̵�
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				CheckReservation cr = new CheckReservation();
			}
		});
	}
}
