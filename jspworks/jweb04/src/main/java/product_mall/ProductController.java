package product_mall;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/pcontrol") //http://localhost:8080/jweb02/pcontrol?action=list
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductService service;

    public ProductController() {
        service = new ProductService();
    }
	
    //doGet(), doPost() 사용해되 됨
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//action 패턴
		String action = request.getParameter("action");
		String nextPage = "";
		
		if(action.equals("list")) { //상품 목록
			List<Product> productList = service.getProductList();
			request.setAttribute("productList", productList); //모델 생성
			nextPage = "/product_mall/productList.jsp"; //뷰 경로
		}else if(action.equals("info")) {
			String pid = request.getParameter("pid");
			Product product = service.getProduct(pid);
			request.setAttribute("product", product);
			nextPage = "/product_mall/productInfo.jsp";
		}
		//포워딩
		RequestDispatcher rd = 
				request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
}
