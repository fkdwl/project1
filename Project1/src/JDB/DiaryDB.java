package JDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DiaryDB {

	public static void Main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String user = "c##green";
		String password = "green1234";

		Connection con;

		Scanner sc = new Scanner(System.in);

		String id = sc.next();
		String pw = sc.next();
		String nm = sc.next();
		String ad = sc.nextLine();
		String nb = sc.next();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String inserQuery = "INSERT INTO REGISTER(dept_id,dept_password,dept_name,dept_address,dept_number)"
					+ "VALUES(?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(inserQuery);

			pstm.setString(1, id);
			pstm.setString(2, pw);
			pstm.setString(3, nm);
			pstm.setString(4, ad);
			pstm.setString(5, nb);

			pstm.executeUpdate();

			pstm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}