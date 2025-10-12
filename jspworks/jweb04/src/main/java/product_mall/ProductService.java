package product_mall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProductService {
	
	Map<String, Product> products = new HashMap<>();
	
	//상품 생성
	public ProductService() {
		Product p1 = new Product("p101", "Galaxy S25", "삼성 전자",
				1500000, "2025. 2. 25");
		Product p2 = new Product("p201", "iPhone 17", "애플(Apple)",
				1200000, "2025. 9. 19");
		Product p3 = new Product("p102", "LG Gram", "LG 전자",
				2000000, "2025. 4. 5");
		
		//Product 저장
		products.put("p101", p1);
		products.put("p201", p2);
		products.put("p102", p3); 
	}
	
	//상품 목록 보기
	public List<Product> getProductList(){
		return new ArrayList<>(products.values());
	}
	
	//상품 1건 보기
	public Product getProduct(String pid) {
		return products.get(pid);
	}
}







