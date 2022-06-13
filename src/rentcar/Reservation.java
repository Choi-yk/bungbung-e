package rentcar;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import rentcar.reservation.ResDao;

public class Reservation extends JFrame {
	// ������ȣ ������
	String[] carNum = {"01��1234", "02��5678", "03��9101", "04��2345", "05��6789"}; 
	
	public Reservation() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);

		Label l1 = new Label("�����ȣ");
		Label l2 = new Label("����ȣ"); // Client���� ��������
		Label l3 = new Label("���� ����");
		Label l4 = new Label("�뿩 ������");
		Label l5 = new Label("�뿩 ������");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);

		// �ؽ�Ʈ �ʵ�
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField(); // ��¥���� �ӽ÷� �ؽ�Ʈ�ʵ�
		TextField t4 = new TextField();
		add(t1);
		add(t2);
		add(t3);
		add(t4);

		// �޺��ڽ�
		JComboBox<String> comboBox1 = new JComboBox<String>(carNum);
		add(comboBox1);
		
		// ��¥ ������ �� �޷�
		// https://www.codejava.net/java-se/swing/how-to-use-jdatepicker-to-display-calendar-component

		
		JButton j1 = new JButton("����");
		JButton j3 = new JButton("������");
		add(j1);
		add(j3);
		
		l1.setBounds(40, 40, 60, 40);
		l2.setBounds(40, 100, 60, 40);
		l3.setBounds(40, 160, 60, 40);
		l4.setBounds(40, 220, 120, 40);
		l5.setBounds(40, 280, 80, 40);

		t1.setBounds(180, 40, 200, 40);
		t2.setBounds(180, 100, 200, 40);
		
		comboBox1.setBounds(180, 160, 200, 40);
		
		t3.setBounds(180, 220, 200, 40);
		t4.setBounds(180, 280, 200, 40);
		
		j1.setBounds(110, 360, 80, 40);
		j3.setBounds(290, 360, 80, 40);

		add(p);
		setSize(500, 500);
		setTitle("�����ϱ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�ݱ� ��ư
		setVisible(true);
		
		j1.addActionListener(new ActionListener() {
			// ���� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				String resNum = t1.getText();
				String clientNum = t2.getText();
				String carNum = comboBox1.getSelectedItem().toString();
				String rent_start = t3.getText();
				String rent_end = t4.getText();
				
				ResDao dao = new ResDao();
				int result = dao.insertReservation(resNum, clientNum, carNum, rent_start, rent_end);
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.");
				} else {
					JOptionPane.showMessageDialog(null, "���࿡ �����߽��ϴ�.");
					t1.setText("");
				}
			}
		});
		
		j3.addActionListener(new ActionListener() {
			// ������ ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SelectMenu menu = new SelectMenu();
				
			}
		});
	}
}
