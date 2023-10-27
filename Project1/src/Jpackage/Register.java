package Jpackage;


import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class Register {

	public static void main(String[] args) {
		Frame f = new Frame("Register");
		f.setSize(500, 500);
		f.setLayout(null);

		Label lid = new Label("ID : ");
		Label lpwd = new Label("Password : ", Label.LEFT);
		Label lnm = new Label("Name : ");
		Label ladr = new Label("Address : ");
		Button rs = new Button("Register");

		TextField id = new TextField(8);
		TextField pwd = new TextField(8);
		TextField nm = new TextField(8);
		TextField adr = new TextField(8);

		lid.setBounds(50, 50, 50, 20);
		id.setBounds(100, 50, 150, 20);

		lpwd.setBounds(50, 80, 50, 20);
		pwd.setBounds(100, 80, 150, 20);

		lnm.setBounds(50, 110, 50, 20);
		nm.setBounds(100, 110, 150, 20);

		ladr.setBounds(50, 140, 50, 20);
		adr.setBounds(100, 140, 150, 20);
		
		rs.setBounds(50,170,100,20);
		
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(lnm);
		f.add(nm);
		f.add(ladr);
		f.add(adr);
		f.add(rs);

		rs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "회원가입 되었습니다.");

			}

		});

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
