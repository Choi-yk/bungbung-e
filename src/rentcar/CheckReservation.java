package rentcar;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rentcar.reservation.ResDao;

public class CheckReservation extends JFrame {
	String[] columnNames = {"�����ȣ", "����ȣ", "������ȣ", "�뿩������", "�뿩������"}; // �÷���
	
	public CheckReservation() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);
		
		Label l1 = new Label("������ȣ�� �Է��ϼ���");
		//add(title);
		add(l1);
		
		l1.setBounds(40, 40, 60, 40);
		
		add(p);
		setSize(500, 500);
		setTitle("���೻�� ��ȸ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư
		setVisible(true);
		
		ResDao dao = new ResDao();
		dao.searchReservation();
	}
}
