package Jpackage;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Tell extends JFrame implements MouseListener, ActionListener, ItemListener {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Date now = new Date();
	String now_dt = format.format(now);

	public Tell() {

		JFrame f = new JFrame("알림");
		f.setSize(400, 300);
		f.setLayout(new FlowLayout());

		JLabel day = new JLabel(now_dt);
		f.add(day);

		JPanel zp = new JPanel();
		zp.setSize(300, 20);
		JLabel b1 = new JLabel("오늘의 일정입니다! 일정을 확인해주세요 :) ");
		f.add(b1);

		JLabel b2 = new JLabel("");
		f.add(b2);
		JLabel b3 = new JLabel("");
		f.add(b3);

		JCheckBox newCheckbox = new JCheckBox("오늘의 일정을 확인했습니다");
		f.add(newCheckbox);

		JButton bt1 = new JButton("확인");
		f.add(bt1);
		
		JTextArea tf = new JTextArea();
		tf.setFont(new Font("Arial-Black",Font.PLAIN,14));
		tf.setBounds(10,10,380,250);
		f.add(tf);
		
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@localhost:1521/xe";
			String user = "c##green";
			String password = "green1234";
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String selectQuery = "SELECT TD_DAY,TD_LIST FROM TODOLIST";
			pstmt = con.prepareStatement(selectQuery);
			rs = pstmt.executeQuery();

			StringBuilder tasklist = new StringBuilder();
			String alarmTime = null;

			while (rs.next()) {
				String task = rs.getString("TD_LIST");
				alarmTime = rs.getString("TD_DAY");
				tasklist.append(task).append("\n");
			}
			if (tasklist.length() > 0) {
				tf.setText(tasklist.toString());
				
				JOptionPane.showMessageDialog(f, "사용자의 리스트를 불러왔습니다.");
			} else {
				JOptionPane.showMessageDialog(f, "사용자의 리스트가 없습니다.");
			}
			con.close();

			final String finalAlarmTime = alarmTime;

			bt1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean isChecked = newCheckbox.isSelected();
					if (isChecked) {
						f.dispose();
					} 
						
					

				}

			});
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		f.setResizable(false);
		f.setVisible(true);

	}



	public static void main(String[] args) {
		new Tell();

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
