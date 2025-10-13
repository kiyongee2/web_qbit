package product.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import product.common.DBUtil;

public class ProductDAO {
	//상품 등록
	public void addProduct(Product product) {
		String sql = "insert into product (pid, pname, maker, price, regdate) "
				+ "values (?, ?, ?, ?, ?)"; 
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, product.getPid());
				pstmt.setString(2, product.getPname());
				pstmt.setString(3, product.getMaker());
				pstmt.setInt(4, product.getPrice());
				pstmt.setString(5, product.getRegdate());
				pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//상품 목록 보기
	public List<Product> getProductList(){
		List<Product> list = new ArrayList<>();
		String sql = "select * from product"; 
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				Product product = new Product(
					rs.getString("pid"),
					rs.getString("pname"),
					rs.getString("maker"),
					rs.getInt("price"),
					rs.getString("regdate")
				);
				list.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//상품 상세 보기
	public Product getProduct(String pid) {
		Product product = null;
		String sql = "select * from product where pid = ?"; 
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, pid);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				product = new Product(
					rs.getString("pid"),
					rs.getString("pname"),
					rs.getString("maker"),
					rs.getInt("price"),
					rs.getString("regdate")
				);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	//상품 삭제
	public void deleteProduct(String pid) {
		String sql = "delete from product where pid = ?"; 
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, pid);
				pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//상품 수정
	public void updateProduct(Product product) {
		String sql = "update product set pname=?, maker=?, price=?, regdate=? "
				+ "where pid = ?"; 
		
		try(Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
				pstmt.setString(1, product.getPname());
				pstmt.setString(2, product.getMaker());
				pstmt.setInt(3, product.getPrice());
				pstmt.setString(4, product.getRegdate());
				pstmt.setString(5, product.getPid());
				pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
