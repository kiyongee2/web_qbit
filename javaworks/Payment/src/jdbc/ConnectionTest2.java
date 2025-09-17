package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest2 {
	public static void main(String[] args) {
		//try ~ with ~ resource문
		try(Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/javadb", 
				"javauser", 
				"pwjava")){
			
			System.out.println(conn + "DB 접속 성공!!");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
 
