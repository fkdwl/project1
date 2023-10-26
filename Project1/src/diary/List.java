package diary;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class List {
	
	JLabel lb_title;
	JPanel p_north;
	
	public List() {
		
		Frame f = new Frame("To Do List");
		f.setSize(400, 600);
		f.setLayout(new FlowLayout());
		
		p_north = new JPanel();
		
		lb_title = new JLabel("To Do List");
		lb_title.setFont(new Font("Arial-Black", Font.BOLD, 25));
		
		Checkbox list1 = new Checkbox(" ", true);
		
		f.add(list1);
		f.setVisible(true);
		
	}

	public static void main(String[] args) {
	
		new List();

	}

}
