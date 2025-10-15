package bankapp.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BankAccount {
	//계좌 번호 정규식 패턴 
	private static final String ACCOUNT_PATTERN = 
						"^\\d{2,4}-\\d{2,4}-\\d{4,8}$"; 
	private String accountNumber; //계좌 번호 
	private String owner; //계좌주 
	private int balance; //잔고 
	
	public BankAccount() {}   //기본 생성자
	
	public BankAccount(String accountNumber, String owner, int balance) { 
		this.accountNumber = accountNumber; 
		this.owner = owner; 
		this.balance = balance; 
	} 
	
	//계좌 번호 유효성 검사 
	public static boolean isValidAccountNumber(String accountNumber) { 
		return Pattern.matches(ACCOUNT_PATTERN, accountNumber); 
	} 
	
	//setter, getter 
	public String getAccountNumber() { return accountNumber; } 
	
	public void setAccountNumber(String accountNumber) { 
		this.accountNumber = accountNumber; 
	} 
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getBalance() { return balance; } 
	
	public void setBalance(int balance) { 
		this.balance = balance; 
	} 
}
