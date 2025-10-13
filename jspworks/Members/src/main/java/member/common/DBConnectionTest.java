package member.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionTest {
	private static final String URL = "jdbc:mysql://localhost:3306/jspdb";
	private static final String USER = "javauser";
	private static final String PASSWORD = "pwjava";

	public static void main(String[] args) {
		
		try{
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println(conn + "DB 접속 성공!!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
