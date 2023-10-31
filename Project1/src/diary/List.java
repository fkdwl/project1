package diary;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class List extends JFrame implements MouseListener, ActionListener, ItemListener {

    ArrayList<Checkbox> checkboxes = new ArrayList<Checkbox>();
    ArrayList<TextField> textFields = new ArrayList<TextField>();
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date();
    String now_dt = format.format(now);
  
    
    public List() {
    
        
        JFrame f = new JFrame("To Do List");
        f.setSize(320, 695);
        f.setLayout(new FlowLayout());

        JLabel b1 = new JLabel(now_dt    );
        JLabel b2 = new JLabel("    To Do List !  (오늘의 할 일을 적어보세요!)");
        f.add(b1);
        f.add(b2);

        JPanel z = new JPanel();
        z.setBounds(100, 100, 320, 00);
       // z.setPreferredSize(new Dimension(300, 600));
        z.setLayout(new GridLayout(0, 1));  
        f.add(z);
       
       
        JButton bt1 = new JButton("추가하기");
        f.add(bt1);

        
        //JScrollPane scrollPane = new JScrollPane(f);
        //add(scrollPane, BorderLayout.CENTER);
        //f.add(scrollPane);
        
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // "추가하기" 버튼이 눌렸을 때 처리할 내용을 여기에 추가
                Checkbox newCheckbox = new Checkbox(" ");
                TextField newTextField = new TextField(25);
                JButton newDeleteButton = new JButton("삭제");
                newDeleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // "삭제" 버튼이 눌렸을 때 처리할 내용을 여기에 추가
                        int index = checkboxes.indexOf(newCheckbox);
                        if (index >= 0) {
                            z.remove(newCheckbox);
                            z.remove(newTextField);
                            z.remove(newDeleteButton);
                            checkboxes.remove(index);
                            textFields.remove(index);
                            z.revalidate();
                            z.repaint();
                        }
                    }
                });

                checkboxes.add(newCheckbox);
                textFields.add(newTextField);
                z.add(newCheckbox);
                z.add(newTextField);
                z.add(newDeleteButton);
                z.revalidate();
                z.repaint();
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
