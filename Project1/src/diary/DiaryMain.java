package diary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import JDB.LoginDB;
import Jpackage.Register;
import Jpackage.Setup;
import Jpackage.Simplememo;

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

	Choice yearChoice;
	Choice monthChoice;

	int yy; // 기준점이 되는 년도
	int mm; // 기준점이 되는 월
	int startDay; // 월의 시작 요일
	int lastDate; // 월의 마지막 날

	private boolean isLoggedIn = false;

	// 생성자
	public DiaryMain() {
		// 디자인
		p_north = new JPanel();
		bt_prev = new JButton("이전"); // 이전 버튼
		lb_title = new JLabel("년도 올 예정", SwingConstants.CENTER); // 현재 년도와 월 표기
		bt_next = new JButton("다음"); // 다음 버튼
		p_center = new JPanel();
		JButton login = new JButton("로그인");
		JButton logout = new JButton("로그아웃");
		JButton set_up = new JButton("설정");

		// 라벨에 폰트 설정
		lb_title.setFont(new Font("Arial-Black", Font.BOLD, 25)); // 현재 년도와 월 표기의 색, 글씨체, 크기 설정
		lb_title.setPreferredSize(new Dimension(100, 30)); // 이전 버튼, 현재 년도 표기, 다음 버튼의 사이 간격 설정

		// 년도, 월 선택 리스트
		yearChoice = new Choice();
		monthChoice = new Choice();

		for (int k = 2000; k < 3000; k++) {
			String a = Integer.toString(k);
			yearChoice.addItem(a);
		}
		// 월
		for (int k = 1; k <= 12; k++) {
			String a = Integer.toString(k);
			monthChoice.addItem(a);
		}

		yearChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateCalendar(yearChoice.getSelectedItem(), monthChoice.getSelectedItem());
			}
		});

		monthChoice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				updateCalendar(yearChoice.getSelectedItem(), monthChoice.getSelectedItem());
			}
		});

		add(yearChoice);
		yearChoice.setLocation(10, 5);
		yearChoice.setSize(60, 30);

		add(monthChoice);
		monthChoice.setLocation(75, 5);
		monthChoice.setSize(40, 30);

		p_north.add(login);

		// 로그인 버튼 구현
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 프레임(윈도우) 생성
				Frame f = new Frame("로그인");
				f.setSize(400, 100);
				f.setLayout(new FlowLayout());

				// 아이디, 비밀번호, 로그인 , 회원가입 에 대한 라벨과 버튼 생성
				Label lid = new Label("아이디 : ", Label.RIGHT);
				Label lpwd = new Label("비밀번호 : ", Label.RIGHT);
				Button lg = new Button("로그인");
				Button rgs = new Button("회원가입");
				TextField id = new TextField(7);
				TextField pwd = new TextField(7);
				// 패스워드 입력시 ****로 설정
				pwd.setEchoChar('*');

				// 프레임에 라벨, 버튼, 텍스트필드 등을 추가
				f.add(lid);
				f.add(id);
				f.add(lpwd);
				f.add(pwd);
				f.add(lg);
				f.add(rgs);

				// "로그인" 버튼 에 대한 액션 추가
				lg.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						String elg = id.getText().trim();// 아이디 입력 값 가져오기
						String epwd = pwd.getText().trim();// 비밀번호 입력 값 가져오기
						if (elg.isEmpty() || epwd.isEmpty()) {
							JOptionPane.showMessageDialog(f, "아이디 또는 비밀번호를 입력해주세요");
						} else {
							LoginDB loginDB = new LoginDB();
							int loginResult = loginDB.User(elg, epwd);

							if (loginResult == 1) {
								JOptionPane.showMessageDialog(f, "로그인 되었습니다.");
								f.dispose();
								isLoggedIn = true;
								updateUI();
							} else if (loginResult == 0) {
								JOptionPane.showMessageDialog(f, "아이디 또는 비밀번호가 일치 하지 않습니다.");
							} else if (loginResult == -1) {
								JOptionPane.showMessageDialog(f, "사용자가 존재하지 않습니다.");
							} else {
								JOptionPane.showMessageDialog(f, "로그인 중 오류가 발생했습니다.");
							}

						}

						logout.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								isLoggedIn = false; // 로그아웃 상태로 변경
								updateUI(); // UI 업데이트
								JOptionPane.showMessageDialog(f, "로그아웃 하셨습니다.");
							}
						});

						// 메모장
						memo.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Simplememo memow = new Simplememo();
								memow.setVisible(true);

							}
						});

						// 투 두 리스트 창
						list.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								new List();

							}
						});

						// 설정 창 구현
						set_up.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Setup.main(null);
							}
						});

					}

					private void updateUI() {
						// TODO Auto-generated method stub
						if (isLoggedIn) {
							login.setVisible(false);
							logout.setVisible(true);
						} else {
							login.setVisible(true);
							logout.setVisible(false);
						}
					}
				});

				rgs.addActionListener(new ActionListener() { // 로그인 버튼 누른 후 회원가입창 구현
					@Override
					public void actionPerformed(ActionEvent e) {
						Register.main(null);// "Register" 클래스 호출

					}
				});

				f.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						f.dispose(); // 창을 닫을때 로그인 창 닫기
					}
				});
				f.setResizable(false); // 프레임 조절 금지
				f.setVisible(true); // 프레임 화면에 표시
			}

		});
		p_north.add(bt_prev);
		p_north.add(lb_title);
		p_north.add(bt_next);
		p_north.add(logout);
		add(set_up);
		set_up.setLocation(800, 5);
		set_up.setSize(60, 30);
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
		memo = new JButton("일기장"); // 일기장
		p_center = new JPanel();

		// 버튼 위치
		lb_title2.setPreferredSize(new Dimension(0, 100));

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
			if (i == 6) {
				DayBox2 dayBox2 = new DayBox2(dayAr[i], Color.gray, 120, 25);
				p_center.add(dayBox2);
			} else if (i == 0) {
				DayBox3 dayBox3 = new DayBox3(dayAr[i], Color.gray, 120, 25);
				p_center.add(dayBox3);
			} else {
				DayBox dayBox = new DayBox(dayAr[i], Color.gray, 120, 25);
				p_center.add(dayBox);
			}
		}
	}

	// 날짜 생성
	public void createDate() {
		for (int i = 0; i < dayAr.length * 6; i++) {
			DateBox dateBox = new DateBox("", Color.LIGHT_GRAY, 120, 70);
			p_center.add(dateBox);
			dateBoxAr[i] = dateBox;
			dateBox.updateDate(""); // 날짜 업데이트
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
		int dayOfWeek = startDay; // 시작 요일부터 시작

		Calendar cal = Calendar.getInstance();
		int today = cal.get(Calendar.DAY_OF_MONTH); // 현재 날짜
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH);

		for (int i = 0; i < dateBoxAr.length; i++) {
			if (i >= startDay && n <= lastDate) {
				dateBoxAr[i].updateDate(Integer.toString(n));

				// 토요일 (요일 번호 6)인 경우 텍스트 색을 파란색으로 설정
				if (i % 7 == 6) {
					dateBoxAr[i].setForeground(Color.BLUE);
				}
				// 일요일 (요일 번호 1)인 경우 텍스트 색을 빨간색으로 설정
				else if (i % 7 == 0) {
					dateBoxAr[i].setForeground(Color.RED);
				} else {
					dateBoxAr[i].setForeground(Color.BLACK); // 나머지 날짜는 검정색으로 설정
				}

				// 오늘인 경우 텍스트 색을 노란색으로 설정
				if (n == today && yy == currentYear && mm == currentMonth) {
					dateBoxAr[i].setBackground(Color.YELLOW);
				} else {
					dateBoxAr[i].setBackground(Color.LIGHT_GRAY);
				}

				n++;
				dayOfWeek = (dayOfWeek + 1) % 7; // 다음 날짜의 요일 계산
			} else {
				dateBoxAr[i].updateDate("");
				dateBoxAr[i].setForeground(Color.BLACK);
				dateBoxAr[i].setBackground(Color.LIGHT_GRAY);
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

	public void updateCalendar(String selectedYear, String selectedMonth) {
		int year = Integer.parseInt(selectedYear);
		int month = Integer.parseInt(selectedMonth) - 1;
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		getDateInfo();
		printDate();
		setDateTitle();
	}

	public static void main(String[] args) {
		new DiaryMain();

	}
}
