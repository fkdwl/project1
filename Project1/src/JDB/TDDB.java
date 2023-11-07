package JDB;

import java.awt.Font;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class TDDB {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public TDDB() {
		JFrame f = new JFrame("TODOLIST");
		f.setSize(400, 300);
		f.setLayout(null);
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

			String selectQuery = "SELECT TD_LIST FROM TODOLIST";
			pstmt = con.prepareStatement(selectQuery);
			rs = pstmt.executeQuery();

			StringBuilder taskList = new StringBuilder();

			while (rs.next()) {
				String task = rs.getString("TD_LIST");
				System.out.println(task);
				taskList.append(task).append("\n");
			}
			
			if (taskList.length() > 0) {
				tf.setText(taskList.toString());
				JOptionPane.showMessageDialog(f, "사용자의 리스트를 불러왔습니다.");
			} else {
				JOptionPane.showMessageDialog(f, "사용자의 리스트가 없습니다.");
			}
			con.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		f.setResizable(false);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
			new TDDB();	
		
		
	}
}

