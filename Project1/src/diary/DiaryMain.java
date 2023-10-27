package diary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Jpackage.Register;

//import app0602.common.StringManager;

public class DiaryMain extends JFrame {

	String[] dayAr = { "Sun", "Mon", "Tue", "Wen", "Thur", "Fri", "Sat" }; // 요일 칸 갯수 및 값 지정
	DateBox[] dateBoxAr = new DateBox[dayAr.length * 6]; // 날짜 칸 갯수 지정
	JPanel p_north;
	JButton bt_prev;
	JLabel lb_title;
	JButton bt_next;
	JPanel p_center; // 날짜 박스 처리할 영역
	Calendar cal; // 날짜 객체
	JButton memo;
	JButton list;
	JPanel p_down;
	JPanel p_down2;
	JLabel lb_title2;

	int yy; // 기준점이 되는 년도
	int mm; // 기준점이 되는 월
	int startDay; // 월의 시작 요일
	int lastDate; // 월의 마지막 날

	// 생성자
	public DiaryMain() {
		// 디자인
		p_north = new JPanel();
		bt_prev = new JButton("이전"); // 이전 버튼
		lb_title = new JLabel("년도 올 예정", SwingConstants.CENTER); // 현재 년도와 월 표기
		bt_next = new JButton("다음"); // 다음 버튼
		p_center = new JPanel();
		JButton set_up = new JButton("설정");

		// 라벨에 폰트 설정
		lb_title.setFont(new Font("Arial-Black", Font.BOLD, 25)); // 현재 년도와 월 표기의 색, 글씨체, 크기 설정
		lb_title.setPreferredSize(new Dimension(100, 30)); // 이전 버튼, 현재 년도 표기, 다음 버튼의 사이 간격 설정

		p_north.add(set_up);
		set_up.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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

		});

		p_north.add(bt_prev);
		p_north.add(lb_title);
		p_north.add(bt_next);
		add(p_north, BorderLayout.NORTH); // 현재 년도와 월 표기 위치 설정 (북쪽으로 위치(위))
		add(p_center);

		// 이전 버튼을 눌렀을 때 전 월로 이동해야함
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMonth(-1);
			}
		});

		// 다음 버튼을 눌렀을 때 다음 달로 이동해야함
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMonth(1);
			}
		});

		// 투 두 리스트와 메모장
		p_down = new JPanel();
		list = new JButton("To do List"); // 투 두 리스트 버튼
		lb_title2 = new JLabel("", SwingConstants.CENTER);
		memo = new JButton("Memo"); // 메모장
		p_center = new JPanel();

		// 버튼 위치
		lb_title2.setPreferredSize(new Dimension(0, 100));

		// 투 두 리스트 창
		list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new List();

			}
		});

		// 메모장
		memo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Memo();
			}
		});

		p_down.add(list);
		p_down.add(memo);
		p_down.add(lb_title2);

		add(p_down, BorderLayout.SOUTH);
		add(p_center);

		getCurrentDate(); // 현재 날짜 객체 생성
		getDateInfo(); // 날짜 객체로부터 정보들 구하기
		setDateTitle(); // 타이틀 라벨에 날짜 표시하기
		createDay(); // 요일 박스 생성
		createDate(); // 날짜 박스 생성
		printDate(); // 상자에 날짜 그리기

		// 메인 화면 창
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 900, 700); // 화면 창 크기
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x(창 닫기) 누르면 창 꺼지는 거
	}

	// 현재날짜 객체 만들기
	public void getCurrentDate() {
		cal = Calendar.getInstance();
	}

	// 시작 요일, 끝 날 등 구하기
	public void getDateInfo() {
		yy = cal.get(Calendar.YEAR);
		mm = cal.get(Calendar.MONTH);
		startDay = getFirstDayOfMonth(yy, mm);
		lastDate = getLastDate(yy, mm);
	}

	// 요일 생성
	public void createDay() {
		for (int i = 0; i < 7; i++) {
			DateBox dayBox = new DateBox(dayAr[i], Color.gray, 120, 25);
			p_center.add(dayBox);
		}
	}

	// 날짜 생성
	public void createDate() {
		for (int i = 0; i < dayAr.length * 6; i++) {
			DateBox dateBox = new DateBox("", Color.LIGHT_GRAY, 120, 70);
			p_center.add(dateBox);
			dateBoxAr[i] = dateBox;
		}
	}

	// 해당 월의 시작 요일 구하기
	// 개발 원리 : 날짜 객체를 해당 월의 1일로 조작한 후, 요일 구하기
	// 사용 방법 : 2021년 2월을 구할시 2021, 1을 넣으면 됨
	public int getFirstDayOfMonth(int yy, int mm) {
		Calendar cal = Calendar.getInstance(); // 날짜 객체 생성
		cal.set(yy, mm, 1);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;// 요일은 1부터 시작으로 배열과 쌍을 맞추기 위해 -1
	}

	// 사용 방법 : 2021년 2월을 구할시 2021, 1을 넣으면 됨
	public int getLastDate(int yy, int mm) {
		Calendar cal = Calendar.getInstance();
		cal.set(yy, mm + 1, 0);
		// 마지막 날을 의미한다.
		return cal.get(Calendar.DATE);
	}

	// 날짜 박스에 날짜 출력하기
	public void printDate() {
		System.out.println("시작 요일" + startDay);
		System.out.println("마지막 일" + lastDate);

		int n = 1;
		for (int i = 0; i < dateBoxAr.length; i++) {
			if (i >= startDay && n <= lastDate) {
				dateBoxAr[i].day = Integer.toString(n);
				dateBoxAr[i].repaint();
				n++;
			} else {
				dateBoxAr[i].day = "";
				dateBoxAr[i].repaint();
			}
		}
	}

	// 달력을 넘기거나 전으로 이동할 때 날짜 객체에 대한 정보도 변경
	public void updateMonth(int data) {
		// 캘린더 객체에 들어있는 날짜를 기준으로 월 정보를 바꿔준다.
		cal.set(Calendar.MONTH, mm + data);
		getDateInfo();
		printDate();
		setDateTitle();
	}

	// 몇년도 몇월인지를 보여주는 타이틀 라벨의 값을 변경
	public void setDateTitle() {
		lb_title.setText(yy + "-" + StringManager.getZeroString(mm + 1));
		lb_title.updateUI();
	}

	public static void main(String[] args) {
		new DiaryMain();
		class Main {
			public Main() {
			}
		}
		new Main();

	}
}
