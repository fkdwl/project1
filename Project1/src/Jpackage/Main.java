package Jpackage;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import diary.DiaryMain;

public class Main {
	public static void main(String[] args) {
		Frame f = new Frame("로그인");
		f.setSize(400, 100);
		f.setLayout(new FlowLayout());

		Label lid = new Label("아이디 : ", Label.RIGHT);
		Label lpwd = new Label("비밀번호 : ", Label.RIGHT);
		Button lg = new Button("로그인");
		Button rgs = new Button("회원가입");

		TextField id = new TextField(7);
		TextField pwd = new TextField(7);
		pwd.setEchoChar('*');

		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(lg);
		f.add(rgs);

		lg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "로그인 되었습니다.");

			}

		});

		rgs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Register.main(null);
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

		class Register {
			public Register() {
				
			}

		}
	}

}
