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
        // 프레임 (윈도우) 생성
        Frame f = new Frame("회원가입");
        f.setSize(400, 400); // 프레임 크기 설정
        f.setLayout(null); // 레이아웃을 수동으로 설정

        // 아이디, 비밀번호, 이름, 주소, 번호 등의 라벨과 입력 필드를 생성
        Label lid = new Label("아이디 : ");
        Label lpwd = new Label("비밀번호 : ");
        Label lnm = new Label("이름 : ");
        Label ladr = new Label("주소 : ");
        Label lpn = new Label("번호 : ");
        Button rs = new Button("회원 가입"); // "회원 가입" 버튼
        Button ID = new Button("확인"); // "확인" 버튼
        Button PASSWORD = new Button("확인");
        TextField id = new TextField(10);
        TextField pwd = new TextField(10);
        TextField nm = new TextField(10);
        TextField adr = new TextField(10);
        TextField pn = new TextField(10);

        // 라벨, 텍스트필드, 버튼 등의 위치와 크기를 설정
        lid.setBounds(50, 50, 50, 20);
        id.setBounds(100, 50, 150, 20);
        ID.setBounds(260, 50, 50, 20);

        lpwd.setBounds(50, 100, 50, 20);
        pwd.setBounds(100, 100, 150, 20);
        PASSWORD.setBounds(260,100,50,20);
        
        lnm.setBounds(50, 150, 50, 20);
        nm.setBounds(100, 150, 150, 20);

        ladr.setBounds(50, 200, 50, 20);
        adr.setBounds(100, 200, 150, 20);

        lpn.setBounds(50, 250, 50, 20);
        pn.setBounds(100, 250, 150, 20);

        rs.setBounds(100, 320, 100, 20);

        // 프레임에 라벨, 텍스트필드, 버튼 등을 추가
        f.add(lid);
        f.add(id);
        f.add(ID);
        f.add(lpwd);
        f.add(pwd);
        f.add(PASSWORD);
        f.add(lnm);
        f.add(nm);
        f.add(ladr);
        f.add(adr);
        f.add(lpn);
        f.add(pn);
        f.add(rs);

        // "확인" 버튼에 대한 액션 리스너 추가
        ID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eid = id.getText().trim();
                if (eid.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "잘못 입력하셨습니다.");
                } else {
                    JOptionPane.showMessageDialog(f, "확인되었습니다.");
                }
            }
        });
        
        PASSWORD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String epwd = pwd.getText().trim();
                if (epwd.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "잘못 입력하셨습니다.");
                } else {
                    JOptionPane.showMessageDialog(f, "확인되었습니다.");
                }
            }
        });
        

        // "회원 가입" 버튼에 대한 액션 리스너 추가
        rs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "회원가입 되었습니다.");
                f.dispose(); // 프레임 닫기
            }
        });

        // 프레임의 닫기 버튼(X)을 누를 때 프레임을 닫음
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

        f.setResizable(false); // 프레임 크기 조절 금지
        f.setVisible(true); // 프레임을 화면에 표시
    }
}
