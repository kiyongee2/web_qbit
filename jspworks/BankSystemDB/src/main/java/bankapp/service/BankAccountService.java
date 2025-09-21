package bankapp.service;

import java.util.List;

import bankapp.dao.BankAccountDAO;
import bankapp.dto.BankAccount;
import bankapp.dto.Transaction;

public class BankAccountService {
	
	BankAccountDAO dao = new BankAccountDAO();
	
	//계좌 생성
	public void createAccount(String accountNumber, String owner, int balance) {
		// 1. 계좌번호 형식 검사
		if (!BankAccount.isValidAccountNumber(accountNumber)) {
			throw new IllegalArgumentException("유효하지 않은 계좌번호 형식입니다. (예: 123-456-7890)");
		}
		
		// 2. 중복 계좌 검사
		if (dao.getAccount(accountNumber) != null) {
			throw new IllegalArgumentException("이미 존재하는 계좌번호입니다.");
		}
		
		BankAccount account = new BankAccount(accountNumber, owner, balance);
		dao.createAccount(account);
	}
	
	//계좌 번호 조회
	public BankAccount getAccount(String accountNumber) {
		BankAccount account = dao.getAccount(accountNumber);
		if (account == null) {
			throw new IllegalArgumentException("존재하지 않는 계좌번호입니다.");
		}
		return account;
	}
	
	//입금
	public void deposit(String accountNumber, int amount) {
		// 유효성 검사
		if (amount <= 0) {
			throw new IllegalArgumentException("입금 금액은 0보다 커야 합니다.");
		}
		
		getAccount(accountNumber);
		dao.deposit(accountNumber, amount);
	}
	
	//출금
	public void withdraw(String accountNumber, int amount) {
		// 유효성 검사
		if (amount <= 0) {
			throw new IllegalArgumentException("출금 금액은 0보다 커야 합니다.");
		}
		
		BankAccount account = getAccount(accountNumber);
		if (account.getBalance() < amount) {
			throw new IllegalArgumentException("잔액이 부족합니다.");
		}
		
		dao.withdraw(accountNumber, amount);
	}
	
	//거래 내역
	public List<Transaction> getTransactions(String accountNumber){
		getAccount(accountNumber); // 존재 여부 확인
		return dao.getTransactions(accountNumber);
	}
}
