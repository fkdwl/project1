package Jpackage;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class Main {
	public static void main(String[] args) {
		Frame f = new Frame("login");
		f.setSize(500, 100);
		f.setLayout(new FlowLayout());

		Label lid = new Label("ID : ", Label.RIGHT);
		Label lpwd = new Label("Password : ", Label.RIGHT);
		Button lg = new Button("Login");
		Button rgs = new Button("Register");

		TextField id = new TextField(5);
		TextField pwd = new TextField(5);
		pwd.setEchoChar('*');

		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(lg);
		f.add(rgs);
		f.setVisible(true);

	}

}