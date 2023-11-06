package Jpackage;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Setup {

   public static void main(String[] args) {
      Frame f = new Frame();
      f.setSize(150,200);
      f.setLayout(null);
      Button tl = new Button("Todo list");
      Button ar = new Button("알람");
      Button im = new Button("배경선택");
      
      tl.setBounds(50,50,50,20);
      ar.setBounds(50,100,50,20);
      im.setBounds(50,150,50,20);
      
      f.add(tl);
      f.add(ar);
      f.add(im);
      
      
      f.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            f.dispose();
         }
      });
      
      f.setResizable(false);
      f.setVisible(true);
   }

}
