package bankapp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/bank")
public class BankController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Map<String, BankAccount> accounts = new HashMap<>();
	
    public BankController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String nextPage = "";
       
        if(action.equals("accountForm")) { //계좌 개설 폼
        	nextPage = "/bank/accountForm.jsp";
        }else if (action.equals("create")) { // 계좌 개설
            String accountNumber = request.getParameter("accountNumber");
            String owner = request.getParameter("owner");
            
            if(!BankAccount.isValidAccountNumber(accountNumber)) {
            	String error = "유효하지 않은 계좌번호 형식입니다. (예: 123-456-7890)";
            	request.setAttribute("error", error);
            	nextPage = "/bank/accountForm.jsp";  // 다시 개설 폼으로 이동
            }else if(accounts.containsKey(accountNumber)) {
            	request.setAttribute("error", "이미 등록된 계좌입니다.");
            	nextPage = "/bank/accountForm.jsp"; 
            }else {
            	BankAccount account = new BankAccount(accountNumber, owner);
                accounts.put(accountNumber, account);
                request.setAttribute("account", account);
                nextPage = "/bank/accountInfo.jsp";
            }
        }else if(action.equals("deposit")) { //입금
        	String accountNumber = request.getParameter("accountNumber");
        	int amount = Integer.parseInt(request.getParameter("amount"));
        	
        	BankAccount account = accounts.get(accountNumber);
        	if(account != null) {
        		if(amount <= 0) {
                    // 잘못된 금액
                    String error = "입금 금액은 0원보다 커야 합니다.";
                    request.setAttribute("error", error);
                } else {
                    account.setBalance(account.getBalance() + amount);
                    account.addTransaction(TransactionType.입금, amount);
                }
                request.setAttribute("account", account);
        	}
        	nextPage = "/bank/accountInfo.jsp";
        }else if(action.equals("withdraw")) { //출금
        	String accountNumber = request.getParameter("accountNumber");
        	int amount = Integer.parseInt(request.getParameter("amount"));
        	
        	BankAccount account = accounts.get(accountNumber);
        	if(account != null) {
        		if(amount <= 0) {
                    String error = "출금 금액은 0원보다 커야 합니다.";
                    request.setAttribute("error", error);
                } else if(account.getBalance() < amount) {
                    // 잔액 부족
                    String error = "잔액이 부족합니다.";
                    request.setAttribute("error", error);
                } else {
                    account.setBalance(account.getBalance() - amount);
                    account.addTransaction(TransactionType.출금, amount);
                }
                request.setAttribute("account", account);
        	}
        	nextPage = "/bank/accountInfo.jsp";
        }else if(action.equals("history")) {
        	String accountNumber = request.getParameter("accountNumber");
        	BankAccount account = accounts.get(accountNumber);
        	if(account != null) {
        		request.setAttribute("transactions", account.getTransactions());
        	}
        	nextPage = "/bank/transactionHistory.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(nextPage);
        rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
