package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/mvc01")
public class DataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//변수
		String season = "가을";
		
		//배열
		String[] seasons = {"봄", "여름", "가을", "겨울"};
		
		request.setAttribute("season", season);
		request.setAttribute("seasons", seasons);
		
		// List
		List<String> fruits = Arrays.asList("사과", "바나나", "딸기");
		request.setAttribute("fruits", fruits);
		
		// map
		Map<String, Object> cars = new HashMap<>();
		cars.put("brand", "EV6");
		cars.put("year", 2025);
		request.setAttribute("cars", cars);
		
		RequestDispatcher rd = request.getRequestDispatcher("/mvc/mvc01.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
