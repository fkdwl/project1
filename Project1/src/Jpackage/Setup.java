package Jpackage;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import JDB.TDDB;

public class Setup {

	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(190, 210);
		f.setLayout(null);

		Button ar = new Button("알람");
		Button im = new Button("배경선택");
		Button logout = new Button("로그아웃");

		ar.setBounds(50, 50, 50, 20);
		im.setBounds(50, 100, 50, 20);

		f.add(logout);

		f.add(ar);
		f.add(im);

		ar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Tell.main(null);

			}

		});

		im.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fileDialog = new FileDialog(f, "이미지 파일 선택", FileDialog.LOAD);
				fileDialog.setVisible(true);

				String directory = fileDialog.getDirectory();
				String filename = fileDialog.getFile();

				if (filename != null) {
					String imagePath = directory + filename;
					try {
						BufferedImage image = ImageIO.read(new File(imagePath));

						f.add(im);
						f.validate();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}

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
