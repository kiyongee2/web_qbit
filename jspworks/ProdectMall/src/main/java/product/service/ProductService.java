package product.service;

import java.util.ArrayList;
import java.util.List;

import product.model.Product;
import product.model.ProductDAO;

public class ProductService {
	
	ProductDAO dao = new ProductDAO();
	
	//상품 등록
	public void addProduct(Product product) {
		dao.addProduct(product);
	}
	
	//상품 목록
	public List<Product> getProductList(){
		return dao.getProductList();
	}
	
	//상품 상세
	public Product getProduct(String pid) {
		return dao.getProduct(pid);
	}
	
	//상품 삭제
	public void deleteProduct(String pid) {
		dao.deleteProduct(pid);
	}
	
	//상품 수정
	public void updateProduct(Product product) {
		dao.updateProduct(product);
	}
}
