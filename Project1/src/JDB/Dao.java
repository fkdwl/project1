package JDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "c##diary";
	String password = "green1234";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public  ArrayList<Vo> list() {
		// TODO Auto-generated method stub
		ArrayList<Vo>list = new ArrayList<Vo>();
		
		try {
			connDB();
			
			String query = "SELECT * FROM Register";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String dept_id = rs.getString("dept_id");
				String dept_password = rs.getString("dept_password");
				String dept_name = rs.getString("dept_name");
				String dept_address = rs.getString("dept_address");
				String dept_number = rs.getString("dept_number");
				
				Vo data = new Vo(dept_id, dept_password, dept_name, dept_address, dept_number);
				list.add(data);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading susccess.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement();
			System.out.println("statement create success.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
