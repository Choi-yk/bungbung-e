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
	String[] columnNames = {"�����ȣ", "����ȣ", "������ȣ", "�뿩������", "�뿩������"}; // �÷���
	
	public CheckReservation() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		
		Label l1 = new Label("����ȣ�� �Է��ϼ���");
		add(l1);
		
		// �ؽ�Ʈ �ʵ�
		TextField t1 = new TextField();
		add(t1);
		
		JButton searchBtn = new JButton("��ȸ"); // select��
		JButton updateBtn = new JButton("����"); // update��
		add(searchBtn);
		add(updateBtn);
		
		l1.setBounds(20, 20, 150, 40);
		
		t1.setBounds(170, 20, 150, 40);
		
		searchBtn.setBounds(340, 20, 60, 40);
		updateBtn.setBounds(400, 20, 60, 40);
		
		add(p);
		setSize(500, 500);
		setTitle("���೻�� ��ȸ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư
		setVisible(true);
		
		searchBtn.addActionListener(new ActionListener() {
			// ��ȸ ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				String clientNum = t1.getText();
				
				ResDao dao = new ResDao();
				int result = dao.searchReservation(clientNum);
				if (result == 0) {
					JOptionPane.showMessageDialog(null, "���೻�� ��ȸ�� �����߽��ϴ�. ����ȣ�� �ٽ� �Է����ּ���.");
				} 
				
			}
		});
		
		updateBtn.addActionListener(new ActionListener() {
			// ���� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
//				ResDao dao = new ResDao();
//				int result = dao.updateRentDate(resNum, rent_start, rent_end);
//				if (result != 0) {
//					JOptionPane.showMessageDialog(null, "�뿩 �������� ���� �Ǿ����ϴ�.");
//				} else {
//					JOptionPane.showMessageDialog(null, "������ �����߽��ϴ�.");
//				}
			}
		});
		
		
	}
}
