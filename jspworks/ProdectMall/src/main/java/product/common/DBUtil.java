package product.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/jspdb";
	private static final String USER = "javauser";
	private static final String PASSWORD = "pwjava";

	public static Connection getConnection() {
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
