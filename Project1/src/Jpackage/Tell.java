package Jpackage;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JDB.TDDB;

public class Tell extends JFrame implements MouseListener, ActionListener, ItemListener {

   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
   Date now = new Date();
   String now_dt = format.format(now);
   
   public Tell() {
      
      JFrame f = new JFrame("알림");
      f.setSize(300, 300);
      f.setLayout(new FlowLayout());
      
      JLabel day = new JLabel(now_dt);
      f.add(day);
      
      JPanel zp = new JPanel();
      zp.setSize(300, 20);
      JLabel b1 = new JLabel("오늘의 일정입니다!   일정을 확인해주세요 :) ");
      f.add(b1);
      
      JLabel b2 = new JLabel("- 아침운동하기");
      f.add(b2);
      JLabel b3 = new JLabel("- 공부하기");
      f.add(b3);

      
      JCheckBox newCheckbox = new JCheckBox("오늘의 일정을 확인했습니다");
      f.add(newCheckbox);
      
      
      JButton bt1 = new JButton("확인");
      f.add(bt1);
      
      bt1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            boolean isChecked = newCheckbox.isSelected();
            if(isChecked) {
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
