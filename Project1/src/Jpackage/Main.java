package Jpackage;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Main {
	public static void main(String[] args) {
		Frame f = new Frame("login");
		f.setSize(500, 80);
		f.setLayout(new FlowLayout());
		
		Label lid = new Label("ID : " , Label.RIGHT);
		Label lpwd = new Label("Password : ", Label.RIGHT);
		
		TextField id = new TextField(20);
		TextField pwd = new TextField(20);
		pwd.setEchoChar('*');
		
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.setVisible(true);
		
	}

}
