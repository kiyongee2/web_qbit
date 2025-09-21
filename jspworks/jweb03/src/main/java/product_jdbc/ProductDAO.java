package product_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	//상품 목록 보기
	public List<Product> getProductList(){
		List<Product> list = new ArrayList<>();
		String sql = "select from product"; 
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				Product product = new Product(
					rs.getString("pid"),
					rs.getString("pname"),
					rs.getString("maker"),
					rs.getInt("price"),
					rs.getString("date")
				);
				list.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
}
