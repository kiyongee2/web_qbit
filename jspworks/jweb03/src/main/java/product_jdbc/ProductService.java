package product_jdbc;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
	ProductDAO dao = new ProductDAO();
	
	public List<Product> getProductList(){
		return dao.getProductList();
	}
}
