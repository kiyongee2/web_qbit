package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/home")
	public String welcomeMethod() {
		String output = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"ko\">\r\n"
				+ "<head>\r\n"
				+ "  <meta charset=\"UTF-8\">\r\n"
				+ "  <title>Bootstrap 5 Hero Section</title>\r\n"
				+ "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<section class=\"bg-light py-5\">\r\n"
				+ "  <div class=\"container text-center\">\r\n"
				+ "    <h1 class=\"display-5 fw-bold\">도서 쇼핑몰에 오신 것을 환영합니다.</h1>\r\n"
				+ "    <h2 class=\"py-5\">Welcome to Web Market</h2>\r\n"
				+ "  </div>\r\n"
				+ "</section>\r\n"
				+ "\r\n"
				+ "<footer class=\"pt-3 mt-4 text-body-secondary border-top\">\r\n"
				+ "	<div class=\"container pt-5\">\r\n"
				+ "	<p class=\" fs-5\">&copy; BookMarket</p>\r\n"
				+ "	</div>\r\n"
				+ "</footer>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>";
		return output;
	}
}
