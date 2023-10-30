package JDB;

import java.util.ArrayList;

public class DiaryDB {

	public static void main(String[] args) {
		Dao  dao1 = new Dao();
		ArrayList<Vo>list = dao1.list();
		
		for(int i =0; i<list.size();i++) {
			Vo data = (Vo)list.get(i);
			String dept_id = data.getDept_id();
			String dept_password = data.getDept_password();
			String dept_name = data.getDept_name();
			String dept_address = data.getDept_address();
			String dept_number = data.getDept_number();
			
			System.out.println(dept_id + " : " +dept_password  + " : " + dept_name + " : " + dept_address + " : " + 
			dept_number);
		}

	}

}
