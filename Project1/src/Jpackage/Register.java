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
		f.setSize(400, 400);
		f.setLayout(null);

		Label lid = new Label("ID : ");
		Label lpwd = new Label("Password : ");
		Label lnm = new Label("Name : ");
		Label ladr = new Label("Address : ");
		Label lpn = new Label("P-Number : ");
		
		Button rs = new Button("Register");
		Button ID = new Button("ok");
		
		TextField id = new TextField(10);
		TextField pwd = new TextField(10);
		TextField nm = new TextField(10);
		TextField adr = new TextField(10);
		TextField pn = new TextField(10);

		lid.setBounds(50, 50, 50, 20);
		id.setBounds(100, 50, 150, 20);
		ID.setBounds(260,50,50,20);

		lpwd.setBounds(50, 100, 50, 20);
		pwd.setBounds(100, 100, 150, 20);

		lnm.setBounds(50, 150, 50, 20);
		nm.setBounds(100, 150, 150, 20);

		ladr.setBounds(50, 200, 50, 20);
		adr.setBounds(100, 200, 150, 20);
		
		lpn.setBounds(50,250,50,20);
		pn.setBounds(100,250,150,20);
		
		rs.setBounds(100,320,100,20);
		
		f.add(lid);
		f.add(id);
		f.add(ID);
		f.add(lpwd);
		f.add(pwd);
		f.add(lnm);
		f.add(nm);
		f.add(ladr);
		f.add(adr);
		f.add(lpn);
		f.add(pn);
		f.add(rs);
		
		
		ID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "확인되었습니다.");

			}

		});

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
