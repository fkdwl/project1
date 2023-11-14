package Jpackage;

import java.awt.Color;
import java.awt.Dimension;
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
      
      
      JPanel z = new JPanel();  
      z.setPreferredSize(new Dimension(400, 20));  //사이즈
      //z.setBackground(Color.green);  // 배경색
      f.add(z);
      

      JLabel day = new JLabel(now_dt);
      z.add(day);

      
      JLabel b1 = new JLabel("오늘의 일정입니다! 일정을 확인해주세요 :) ");
      z.add(b1);

      /*
      JLabel b2 = new JLabel("");
      f.add(b2);
      
      JLabel b3 = new JLabel("");
      f.add(b3);
*/
      
      JPanel z2 = new JPanel();  
      z2.setPreferredSize(new Dimension(400, 170));  //사이즈
      //z2.setBackground(Color.blue);  // 배경색
      f.add(z2);
      
      
      JTextArea tf = new JTextArea();
      tf.setFont(new Font("Arial-Black",Font.PLAIN,14));
      //tf.setBounds(10,10,380,250);
      z2.add(tf, "Center");
      
      
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

         StringBuilder tasklist = new StringBuilder();
         

         while (rs.next()) {
            String task = rs.getString("TD_LIST");
            tasklist.append(task).append("\n");
         }
         if (tasklist.length() > 0) {
            tf.setText(tasklist.toString());
            
            JOptionPane.showMessageDialog(f, "사용자의 리스트를 불러왔습니다.");
         } else {
            JOptionPane.showMessageDialog(f, "사용자의 리스트가 없습니다.");
         }
         con.close();

         
         
         
      } catch (Exception e1) {
         e1.printStackTrace();
      }
      
      
      JPanel z3 = new JPanel();  
      z3.setPreferredSize(new Dimension(400, 50));  //사이즈
      //z3.setBackground(Color.red);  // 배경색
      f.add(z3);
      
      
      JCheckBox newCheckbox = new JCheckBox("오늘의 일정을 확인했습니다");
      z3.add(newCheckbox);

      JButton bt1 = new JButton("확인");
      z3.add(bt1);
      

      bt1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            boolean isChecked = newCheckbox.isSelected();
            if (isChecked) {
               f.dispose();
            } 
         }
      });
      
      

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