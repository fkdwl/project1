package JDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DiaryDB2 {
    public static void main(String[] args) {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521/xe";
        String user = "c##green";
        String password = "green1234";

        Scanner sc = new Scanner(System.in);

        
        String id = sc.next();
        String pw = sc.next();
        String name = sc.next();
        String address = sc.nextLine();
        String phoneNumber = sc.next();

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);

            String insertQuery = "INSERT INTO Register(dept_id,dept_password,dept_name,dept_address,dept_number) "
            		+ "VALUES(?, ?, ?, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(insertQuery);

            pstm.setString(1, id);
            pstm.setString(2, pw);
            pstm.setString(3, name);
            pstm.setString(4, address);
            pstm.setString(5, phoneNumber);

            pstm.executeUpdate();

            pstm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
