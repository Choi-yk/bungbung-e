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

import rentcar.client.ClientDao;

public class Client extends JFrame {
	// �޺��ڽ� ������
	String[] yn = { "����", "����" };
	String[] join = { "������", "������������" };

	public Client() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);

		//
		Label l1 = new Label("����ȣ");
		Label l2 = new Label("����");
		Label l3 = new Label("��ȭ��ȣ");
		Label l4 = new Label("���������� ���� ����");
		Label l5 = new Label("���� ���� ����");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);

		// �ؽ�Ʈ �ʵ�
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		add(t1);
		add(t2);
		add(t3);

		// �޺��ڽ�
		JComboBox<String> comboBox1 = new JComboBox<String>(yn);
		JComboBox<String> comboBox2 = new JComboBox<String>(join);
		add(comboBox1);
		add(comboBox2);

		JButton j1 = new JButton("���");
		JButton j2 = new JButton("���");
		add(j1);
		add(j2);

		l1.setBounds(40, 40, 60, 40);
		l2.setBounds(40, 100, 40, 40);
		l3.setBounds(40, 160, 60, 40);
		l4.setBounds(40, 220, 120, 40);
		l5.setBounds(40, 280, 80, 40);

		t1.setBounds(180, 40, 200, 40);
		t2.setBounds(180, 100, 200, 40);
		t3.setBounds(180, 160, 200, 40);

		comboBox1.setBounds(180, 220, 200, 40);
		comboBox2.setBounds(180, 280, 200, 40);

		j1.setBounds(160, 360, 80, 40);
		j2.setBounds(270, 360, 80, 40);

		add(p);
		setSize(500, 500);
		setTitle("�� ���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�ݱ� ��ư
		setVisible(true);

		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��� ��ư
				String clientNum = t1.getText();
				String clientName = t2.getText();
				String phoneNumber = t3.getText();
				String drivers_license = comboBox1.getSelectedItem().toString();
				String insurance = comboBox2.getSelectedItem().toString();

				ClientDao dao = new ClientDao();
				int result = dao.insertClient(clientNum, clientName, phoneNumber, drivers_license, insurance);
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "����� �Ϸ�Ǿ����ϴ�.");
				} else {
					JOptionPane.showMessageDialog(null, "����ȣ�� �ߺ��Ǿ� ��Ͽ� �����߽��ϴ�.");
					t1.setText("");
				}

			}
		});

		j2.addActionListener(new ActionListener() {
			// ��� ��ư
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				SelectMenu menu = new SelectMenu();
			}
		});

	}
}