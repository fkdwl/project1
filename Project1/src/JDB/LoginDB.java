package JDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDB {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
public LoginDB(){
	try {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "c##green";
		String password = "green1234";
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
public int User(String userID, String userPassword) {
	String SQL = "SELECT DEPT_PASSWORD FROM REGISTER WHERE DEPT_ID =?";
	try {
		pstmt = con.prepareStatement(SQL);
		pstmt.setString(1, userID);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals(userPassword))
				return 1;
			else 
				return 0;
		}
		return -1;
	}catch(Exception e) {
		e.printStackTrace();
	}
	return -2;
}
	
	
}
