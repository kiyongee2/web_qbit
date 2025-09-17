package payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//결제 내역 저장 인터페이스
interface PaymentRepository {
 void save(String paymentType, int amount);
}

//DB 저장 구현체 (여기서는 JDBC 기반 예시)
class JdbcPaymentRepository implements PaymentRepository {
 @Override
 public void save(String paymentType, int amount) {
     // 실제 DB 저장 로직 (단순 예시)
     System.out.println("DB에 저장됨: " + paymentType + " - " + amount + "원");
    
     /*try (Connection conn = DriverManager.getConnection(
    		 "jdbc:mysql://localhost:3306/javadb", "root", "1234")) {
         String sql = "INSERT INTO payment (payment_type, amount) VALUES (?, ?)";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, paymentType);
         pstmt.setInt(2, amount);
         pstmt.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }*/
 }
}

