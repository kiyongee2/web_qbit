package product;

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
		
		if(action.equals("list")) { //목록 보기
			List<Product> productList = service.getProductList();
			request.setAttribute("productList", productList);
			nextPage = "/product/productList.jsp";
		}else if(action.equals("info")) { //상세 보기
			String pid = request.getParameter("pid");
			Product product = service.getProduct(pid);
			request.setAttribute("product", product);
			nextPage = "/product/productInfo.jsp";
		}else if(action.equals("addForm")) { //등록 폼
			nextPage = "/product/addProduct.jsp"; 
		}else if(action.equals("add")) {  //등록 처리
			String pid = request.getParameter("pid");
			String pname = request.getParameter("pname");
			String maker = request.getParameter("maker");
			int price = Integer.parseInt(request.getParameter("price"));
			String regdate = request.getParameter("regdate");
			
			Product product = new Product(pid, pname, maker, price, regdate);
			
			service.addProduct(product);
			
			//등록후 목록 페이지로 이동
			response.sendRedirect("/product?action=list");
			return; //즉시 종료
		}else if(action.equals("delete")) {
			String pid = request.getParameter("pid");
			
			service.deleteProduct(pid);
			response.sendRedirect("/product?action=list");
			return; //즉시 종료
		}else if(action.equals("updateForm")) {
			String pid = request.getParameter("pid");
			Product product = service.getProduct(pid);
			request.setAttribute("product", product);
			
			nextPage = "/product/updateProduct.jsp"; 
		}else if(action.equals("update")) {
			String pid = request.getParameter("pid");
			String pname = request.getParameter("pname");
			String maker = request.getParameter("maker");
			int price = Integer.parseInt(request.getParameter("price"));
			String regdate = request.getParameter("regdate");
			
			Product product = new Product(pid, pname, maker, price, regdate);
			
			service.updateProduct(product);
			
			//수정후 상세 페이지로 이동
			response.sendRedirect("/product?action=list&pid=" + pid);
			return;
		}
		
		RequestDispatcher rd = 
				request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}

}
