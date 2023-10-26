package diary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
public class fff extends Frame implements ActionListener, WindowListener {
 Panel p;        //객체 생성
 Button input, exit;      //객체 생성
 TextArea ta;       //객체 생성
 
 public fff(){
   
   super("성적처리 프로그램 ");    //프레임 출력
   p=new Panel();      //객체 생성 및 초기화
   
   input = new Button("입력");   //입력을 찍는  객체 생성
   exit = new Button("종료");   //종료를 찍는 객체 생성
   ta = new TextArea();    //글을 적는 객체 생성 및 초기화
   
   //이벤트 소스를 리스너에 연결
   input.addActionListener(this);  //텍스트를 쓰고 입력 버튼을 눌러야 실행 되도록하는 매개채
   exit.addActionListener(this);  //텍스트를 쓰고 종료 버튼을 눌러야 실행 되도록 하는 매개채
   
   p.add(input);  //입력 버튼을 Panel에 추가
   p.add(exit);  //종료 버튼을 Panel에 추가
  
   add(p, BorderLayout.NORTH);    //입력 버튼과 종료 버튼은 북쪽에 출력
   add(ta, BorderLayout.CENTER);   //텍스트지역은 가운데에 출력
   
   addWindowListener(this);    //이벤트가 발생할 때 어떤 행동을 해줄건지 매개채
   setBounds(900, 400, 700, 200);   //창이 뜨는 위치, 창의 크기 조절
   setVisible(true);      //출력
  }
 public void actionPerformed(ActionEvent ae) { //매개변수를 액션이벤트로 받고
  String name;        //객체 생성
  name = ae.getActionCommand();    //ActionEvent안의 메소드 getActionCommad를 불러서 name에 넣는다.
  if (name.equals("입력"))      //입력을 누른다면
   ta.append("버튼이 입력되었습니다.\n");   //버튼을 입력된다
  else {          //아니면
   ta.append("프로그램을 종료합니다.\n");   //다른버튼은 프로그램을 종료합니다를 출력한다
   try {         //try~catch는 예외처리이다
    Thread.sleep(2000);     //2초동안 잠시 정지시킨다
   } catch (Exception e) {
   }
   System.exit(0);       //종료
  }
 }
 public static void main(String[] args) {
  new fff();      //객체생성
 }
 @Override
 public void windowActivated(WindowEvent arg0) {   //windewActivated의 메소드들
  // TODO Auto-generated method stub
  
 }
 @Override
 public void windowClosed(WindowEvent arg0) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void windowClosing(WindowEvent arg0){
  // TODO Auto-generated method stub
  
  System.exit(0); 
 
 }
 @Override
 public void windowDeactivated(WindowEvent arg0) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void windowDeiconified(WindowEvent arg0) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void windowIconified(WindowEvent arg0) {
  // TODO Auto-generated method stub
  
 }
 @Override
 public void windowOpened(WindowEvent arg0) {
  // TODO Auto-generated method stub
  
 }
 
}


