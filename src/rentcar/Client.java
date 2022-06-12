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
	// 콤보박스 데이터
	String[] yn = { "있음", "없음" };
	String[] join = { "가입함", "가입하지않음" };

	public Client() {
		JPanel p = new JPanel();
		setLocationRelativeTo(p);

		//
		Label l1 = new Label("고객번호");
		Label l2 = new Label("고객명");
		Label l3 = new Label("전화번호");
		Label l4 = new Label("운전면허증 소지 여부");
		Label l5 = new Label("보험 가입 여부");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);

		// 텍스트 필드
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		add(t1);
		add(t2);
		add(t3);

		// 콤보박스
		JComboBox<String> comboBox1 = new JComboBox<String>(yn);
		JComboBox<String> comboBox2 = new JComboBox<String>(join);
		add(comboBox1);
		add(comboBox2);

		JButton j1 = new JButton("등록");
		JButton j2 = new JButton("취소");
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
		setTitle("고객 등록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창닫기 버튼
		setVisible(true);

		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 등록 버튼
				String clientNum = t1.getText();
				String clientName = t2.getText();
				String phoneNumber = t3.getText();
				String drivers_license = comboBox1.getSelectedItem().toString();
				String insurance = comboBox2.getSelectedItem().toString();

				ClientDao dao = new ClientDao();
				int result = dao.insertClient(clientNum, clientName, phoneNumber, drivers_license, insurance);
				if (result != 0) {
					JOptionPane.showMessageDialog(null, "등록이 완료되었습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "고객번호가 중복되어 등록에 실패했습니다.");
					t1.setText("");
				}

			}
		});

		j2.addActionListener(new ActionListener() {
			// 취소 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				SelectMenu menu = new SelectMenu();
			}
		});

	}
}