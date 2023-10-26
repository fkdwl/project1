package diary;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class List {
	
	JPanel p_center;
	JLabel lb_title;
	JPanel p_north;
	private Button btn;
	private TextField tfMsg;
	TextField id, pwd;
	
	public List() {
		
		Frame f = new Frame("To Do List");
		f.setSize(270, 500);
		f.setLayout(new FlowLayout());
		p_center = new JPanel();
		
		Label q1 = new Label("To Do List !  (오늘의 할 일을 적어주세요!)");
		f.add(q1);
		
		// 1.
		Checkbox list1 = new Checkbox(" ", true);
		f.add(list1);
		id = new TextField(25);
	 
	    f.add(id);
		
	    // 2.
	    Checkbox list2 = new Checkbox(" ");
		f.add(list2);
		
		id = new TextField(25);
	    f.add(id);
	    
	    // 3.
	    Checkbox list3 = new Checkbox(" ");
		f.add(list3);
		
		id = new TextField(25);
	    f.add(id);
	    
	    // 4.
	    Checkbox list4 = new Checkbox(" ");
		f.add(list4);
		
		id = new TextField(25);
	    f.add(id);
	    
	    // 5.
	    Checkbox list5 = new Checkbox(" ");
		f.add(list5);
		
		id = new TextField(25);
	    f.add(id);
	    
	    // 6.
	    Checkbox list6 = new Checkbox(" ");
		f.add(list6);
		
		id = new TextField(25);
	    f.add(id);
	    
	    // 7.
	    Checkbox list7 = new Checkbox(" ");
		f.add(list7);
		
		id = new TextField(25);
	    f.add(id);
	    
	    // 8.
	    Checkbox list8 = new Checkbox(" ");
		f.add(list8);
		
		id = new TextField(25);
	    f.add(id);
	    
	   
	    
	    
		// 창 닫기 
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
		
		
		
		/*
		f.setLayout(null);
		p_north = new JPanel();.
		
		lb_title = new JLabel("To Do List", SwingConstants.CENTER);
		lb_title.setFont(new Font("Arial-Black", Font.BOLD, 25));
		lb_title.setPreferredSize(new Dimension(100, 30));
		
		
		Label lid = new Label("ID : ", Label.RIGHT);
	    lid.setBounds(20, 20, 50, 50);
	    Label lpwd = new Label("PWD : ", Label.RIGHT);
	    lpwd.setBounds(20, 50, 50, 50);
		
	    id = new TextField(10);
	    id.setBounds(80, 35, 120, 20);
	    pwd = new TextField(10);
	    pwd.setBounds(80, 65, 120, 20);
	    
	    tfMsg = new TextField();
	    tfMsg.setBounds(80, 95, 120, 20);
		
	    
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
		
		*/
		f.setVisible(true);
		f.setResizable(false);  // 화면 크기 고정

		
		p_north.add(lb_title);
		//add(p_north, BorderLayout.NORTH);  // 현재 년도와 월 표기 위치 설정 (북쪽으로 위치(위))
		//add(p_center);
		f.add(list1);
		//f.add(lid);
		//f.add(lpwd);
		
	    f.add(pwd);
	    f.add(btn);
	    f.add(tfMsg);
		f.add(list1);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
	
		new List();

	}
}
	