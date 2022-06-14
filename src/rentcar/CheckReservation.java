package rentcar;

import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import rentcar.reservation.ResDao;
import rentcar.reservation.ResDto;

public class CheckReservation extends JFrame {

	public CheckReservation() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);

		Label l1 = new Label("����ȣ�� �Է��ϼ���");
		add(l1);

		// �ؽ�Ʈ �ʵ�
		TextField t1 = new TextField();
		add(t1);

		TextArea ta = new TextArea();

		JScrollPane jsp = new JScrollPane(ta);
		add(jsp);

		JButton searchBtn = new JButton("��ȸ"); // select��
		JButton updateBtn = new JButton("����"); // update��
		JButton returnBtn = new JButton("�ݳ�");
		JButton exitBtn = new JButton("������");
		add(searchBtn);
		add(updateBtn);
		add(returnBtn);
		add(exitBtn);

		l1.setBounds(20, 20, 150, 40);
		t1.setBounds(170, 20, 150, 40);
		jsp.setBounds(10, 80, 450, 200);

		searchBtn.setBounds(335, 20, 60, 40);
		updateBtn.setBounds(400, 20, 60, 40);
		returnBtn.setBounds(160, 380, 80, 40);
		exitBtn.setBounds(260, 380, 80, 40);

		add(p);
		setSize(500, 500);
		setTitle("���೻�� ��ȸ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �ݱ��ư
		setVisible(true);

		searchBtn.addActionListener(new ActionListener() {
			// ��ȸ ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");

				String clientNum = t1.getText();

				ResDao dao = new ResDao();
				ArrayList<ResDto> searchList = new ArrayList<ResDto>();
				searchList = dao.searchReservation(clientNum);

				ta.append("�����ȣ" + "\t" + "����ȣ" + "\t" + "������ȣ" + "\t" + "�뿩 ������" + "\t" + "�뿩 ������" + "\n");
				ta.append("------------------------------------------------------------------------------" + "\n");
				for (int i = 0; i < searchList.size(); i++) {
					ta.append(searchList.get(i).getResNum() + "\t" + clientNum + "\t\t" + searchList.get(i).getCarNum()
							+ "\t" + searchList.get(i).getRent_start() + "\t" + searchList.get(i).getRent_end() + "\n");
				}
				JOptionPane.showMessageDialog(null, "���� ������ ��ȸ�Ͽ����ϴ�.");

			}
		});

		updateBtn.addActionListener(new ActionListener() {
			// ���� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
//				ResDto dto = new ResDto();
//				
//				String resNum = dto.getResNum();
//				String rent_end = dto.getRent_end();
//				
//				ResDao dao = new ResDao();
//				
//				int result = dao.updateRentDate(resNum, rent_end);
//				if (result != 0) {
//					JOptionPane.showMessageDialog(null, "�뿩 �������� ���� �Ǿ����ϴ�.");
//				} else {
//					JOptionPane.showMessageDialog(null, "������ �����߽��ϴ�.");
//				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			// �ݳ� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		exitBtn.addActionListener(new ActionListener() {
			// ������ ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SelectMenu menu = new SelectMenu();
			}
		});

	}
}
