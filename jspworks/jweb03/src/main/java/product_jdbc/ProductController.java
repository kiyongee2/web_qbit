package product_jdbc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductService service;
       
    public ProductController() {
        service = new ProductService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//action 패턴
		String action = request.getParameter("action");
		String nextPage = "";
		
		if(action.equals("list")) {
			List<Product> productList = service.getProductList();
			request.setAttribute("productList", productList);
			nextPage = "/product_jdbc/productList.jsp";
		}
		
		RequestDispatcher rd = 
				request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
