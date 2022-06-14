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

		Label l1 = new Label("고객번호를 입력하세요");
		add(l1);

		// 텍스트 필드
		TextField t1 = new TextField();
		add(t1);

		TextArea ta = new TextArea();

		JScrollPane jsp = new JScrollPane(ta);
		add(jsp);

		JButton searchBtn = new JButton("조회"); // select문
		JButton updateBtn = new JButton("수정"); // update문
		JButton returnBtn = new JButton("반납");
		JButton exitBtn = new JButton("나가기");
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
		setTitle("예약내역 조회");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기버튼
		setVisible(true);

		searchBtn.addActionListener(new ActionListener() {
			// 조회 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");

				String clientNum = t1.getText();

				ResDao dao = new ResDao();
				ArrayList<ResDto> searchList = new ArrayList<ResDto>();
				searchList = dao.searchReservation(clientNum);

				ta.append("예약번호" + "\t" + "고객번호" + "\t" + "차량번호" + "\t" + "대여 시작일" + "\t" + "대여 종료일" + "\n");
				ta.append("------------------------------------------------------------------------------" + "\n");
				for (int i = 0; i < searchList.size(); i++) {
					ta.append(searchList.get(i).getResNum() + "\t" + clientNum + "\t\t" + searchList.get(i).getCarNum()
							+ "\t" + searchList.get(i).getRent_start() + "\t" + searchList.get(i).getRent_end() + "\n");
				}
				JOptionPane.showMessageDialog(null, "예약 내역을 조회하였습니다.");

			}
		});

		updateBtn.addActionListener(new ActionListener() {
			// 수정 버튼
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
//					JOptionPane.showMessageDialog(null, "대여 종료일이 수정 되었습니다.");
//				} else {
//					JOptionPane.showMessageDialog(null, "수정에 실패했습니다.");
//				}
			}
		});

		returnBtn.addActionListener(new ActionListener() {
			// 반납 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		exitBtn.addActionListener(new ActionListener() {
			// 나가기 버튼
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				SelectMenu menu = new SelectMenu();
			}
		});

	}
}
