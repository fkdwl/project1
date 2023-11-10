package diary;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextComponent;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class List extends JFrame implements MouseListener, ActionListener, ItemListener {

   ArrayList<Checkbox> checkboxes = new ArrayList<Checkbox>();
   ArrayList<TextField> textFields = new ArrayList<TextField>();
   ArrayList<String> arrList = new ArrayList<String>();

   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
   Date now = new Date();
   String now_dt = format.format(now);

   private String userID;
   Choice yearChoice;
   Choice monthChoice;
   Choice dayChoice;
   protected TextComponent list;
   int sum = 0;

   public void setUserID(String userID) {
      this.userID = userID;
   }

   public List() {

      Frame f = new Frame("To Do List");
      f.setSize(320, 618);
      f.setLayout(new FlowLayout());
      // f.setLocationRelativeTo(null);

      JPanel z = new JPanel(); // 년,월,일 선택 리스트
      // z.setSize(300, 300);
      z.setPreferredSize(new Dimension(300, 35)); // 사이즈
      // z.setBounds(100, 100, 300, 100);
      z.setBackground(Color.white); // 배경색
      f.add(z);

      // 년도, 월 선택 리스트
      yearChoice = new Choice();
      monthChoice = new Choice();
      dayChoice = new Choice();

      for (int k = 1; k <= 31; k++) {
         String a = Integer.toString(k);
         dayChoice.addItem(a);
      }

      for (int k = 2000; k < 3000; k++) {
         String a = Integer.toString(k);
         yearChoice.addItem(a);
      }
      // 월
      for (int k = 1; k <= 12; k++) {
         String a = Integer.toString(k);
         monthChoice.addItem(a);
      }

      yearChoice.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            updateCalendar(yearChoice.getSelectedItem(), monthChoice.getSelectedItem(),
                  dayChoice.getSelectedItem());
         }
      });

      monthChoice.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            updateCalendar(yearChoice.getSelectedItem(), monthChoice.getSelectedItem(),
                  dayChoice.getSelectedItem());
         }
      });

      dayChoice.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
            updateCalendar(yearChoice.getSelectedItem(), monthChoice.getSelectedItem(),
                  dayChoice.getSelectedItem());
         }
      });

      z.add(yearChoice);
      // yearChoice.setLocation(10, 5);
      yearChoice.setSize(60, 30);

      z.add(monthChoice);
      monthChoice.setLocation(75, 5);
      monthChoice.setSize(40, 30);

      z.add(dayChoice);
      dayChoice.setSize(60, 30);

      // 라벨 적는 칸
      JPanel z2 = new JPanel();
      z2.setPreferredSize(new Dimension(300, 50)); // 사이즈
      z2.setBackground(Color.white); // 배경색
      f.add(z2);

      JLabel b1 = new JLabel("     오늘 날짜  :  " + now_dt);
      JLabel b2 = new JLabel("    To Do List !  (오늘의 할 일을 적어보세요!)");
      z2.add(b1);
      z2.add(b2);

      // 추가하기, 저장 버튼 위치
      JPanel z3 = new JPanel();
      z3.setPreferredSize(new Dimension(300, 40)); // 사이즈
      z3.setBackground(Color.white); // 배경색
      f.add(z3);

      JButton bt1 = new JButton("추가하기");
      JButton bt2 = new JButton("저장");
      z3.add(bt1);
      z3.add(bt2);

      // 추가하기, 저장 버튼 위치
      JPanel z4 = new JPanel();
      z4.setPreferredSize(new Dimension(300, 1000)); // 사이즈
      z4.setBackground(Color.white); // 배경색
      f.add(z4);

      TextField list = new TextField(10);

      bt1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // "추가하기" 버튼이 눌렸을 때 처리할 내용을 여기에 추가
            if (e.getActionCommand().equals("추가하기")) {
               if (sum < 13) {
                  Checkbox newCheckbox = new Checkbox(" ");
                  TextField newTextField = new TextField(25);
                  JButton newDeleteButton = new JButton("삭제");
                  sum++;

                  newDeleteButton.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                        // "삭제" 버튼이 눌렸을 때 처리할 내용을 여기에 추가
                        int index = checkboxes.indexOf(newCheckbox);
                        if (index >= 0) {
                           z4.remove(newCheckbox);
                           z4.remove(newTextField);
                           z4.remove(newDeleteButton);
                           checkboxes.remove(index);
                           textFields.remove(index);
                           z4.revalidate();
                           z4.repaint();
                           sum--;
                           if (sum < 13) {
                              bt1.setEnabled(true); // 다시 "추가하기" 버튼 활성화
                           }
                        }
                     }
                  });

                  for (int i = 0; i >= 50; i++) {
                     arrList.add("newTextField");
                     System.out.println(arrList.get(0));
                  }

                  checkboxes.add(newCheckbox);
                  textFields.add(newTextField);
                  z4.add(newCheckbox);
                  z4.add(newTextField);
                  z4.add(newDeleteButton);
                  z4.revalidate();
                  z4.repaint();
               }
               if (sum >= 13) {
                  bt1.setEnabled(false); // 13개 이상 생성 시 "추가하기" 버튼 비활성화
               }
            }
         }
      });

      bt2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("저장")) {
               String elt = list.getText().trim();
               try {
                  String driver = "oracle.jdbc.driver.OracleDriver";
                  String url = "jdbc:oracle:thin:@localhost:1521/xe";
                  String user = "c##green";
                  String password = "green1234";
                  Class.forName(driver);
                  Connection conn = DriverManager.getConnection(url, user, password);

                  for (int i = 0; i < checkboxes.size(); i++) {
                     Checkbox checkbox = checkboxes.get(i);
                     TextField textField = textFields.get(i);
                     String task = textField.getText();

                     if (checkbox.getState()) {
                        String insertQuery = "INSERT INTO TODOLIST(TD_LIST) " + "VALUES(?)";
                        PreparedStatement pstm = conn.prepareStatement(insertQuery);
                        pstm.setString(1, task);
                        pstm.executeUpdate();
                     }
                  }
                  conn.close();
                  JOptionPane.showMessageDialog(f, "저장 되었습니다.");

               } catch (Exception e1) {
                  e1.printStackTrace();
               }
            }

         }

      });

      f.setResizable(false);
      f.setVisible(true);

      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            f.dispose();
         }
      });

   }

   protected void updateCalendar(String selectedItem, String selectedItem2, String selectedItem3) {
      // TODO Auto-generated method stub

   }

   public static void main(String[] args) {
      new List();

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