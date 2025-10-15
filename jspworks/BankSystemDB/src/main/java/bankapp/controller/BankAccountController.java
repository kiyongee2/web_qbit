package bankapp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bankapp.dto.BankAccount;
import bankapp.dto.Transaction;
import bankapp.service.BankAccountService;

@WebServlet("/bank")
public class BankAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BankAccountService service = new BankAccountService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String nextPage = "";
        
        if("createForm".equals(action)) {
        	nextPage = "/bank/createAccount.jsp";
        }else if("create".equals(action)){ //계좌 개설
        	String accountNumber = request.getParameter("accountNumber");
            String owner = request.getParameter("owner");
            int balance = Integer.parseInt(request.getParameter("balance"));
            try {
	            service.createAccount(accountNumber, owner, balance);
	            request.setAttribute("account", service.getAccount(accountNumber));
	            nextPage = "/bank/accountInfo.jsp";
            }catch(IllegalArgumentException e) {
            	request.setAttribute("error", e.getMessage());
            	nextPage = "/bank/createAccount.jsp";
            }
        }else if("searchForm".equals(action)) {
        	nextPage = "/bank/searchAccount.jsp";
        }else if ("search".equals(action)) { // 계좌 검색
            String accNum = request.getParameter("accountNumber");

            try {
                BankAccount account = service.getAccount(accNum);
                request.setAttribute("account", account);
                nextPage = "/bank/accountInfo.jsp";
            } catch (IllegalArgumentException e) {
                request.setAttribute("error", e.getMessage());
                nextPage = "/bank/main.jsp";
            }
        }else if("deposit".equals(action)) {  //입금
        	String accNum = request.getParameter("accountNumber");
        	int amount = Integer.parseInt(request.getParameter("amount"));
        	
        	service.deposit(accNum, amount);
        	
        	//입금후 info 페이지로 이동
			response.sendRedirect("bank?action=search&accountNumber=" + accNum);
			return;
        }else if("withdraw".equals(action)) { //출금
        	String accNum = request.getParameter("accountNumber");
        	int amount = Integer.parseInt(request.getParameter("amount"));
  
            try {
                service.withdraw(accNum, amount);
                //출금후 info 페이지로 이동
    			response.sendRedirect("bank?action=search&accountNumber=" + accNum);
    			return;
            } catch (IllegalArgumentException e) {
                request.setAttribute("error", e.getMessage());
                nextPage = "/bank/withdraw.jsp";
            }
        }else if(action.equals("history")) {  //거래 내역
        	String accNum = request.getParameter("accountNumber");
        	List<Transaction> list = service.getTransactions(accNum);
        	
        	request.setAttribute("transactions", list);
        	request.setAttribute("account", service.getAccount(accNum));
        	nextPage = "/bank/transactionHistory.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
	}

}
