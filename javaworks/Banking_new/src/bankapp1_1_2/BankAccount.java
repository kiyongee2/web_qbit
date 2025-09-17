package bankapp1_1_2;

public class BankAccount {
	private String accountNumber;   //계좌 번호
	private String owner; //계좌주
	private int balance;  //잔고
	private Transaction[] transactions;  //거래 배열
	private int transactionCount; //현재 거래수
	
	//생성자
	public BankAccount(String accountNumber, String owner) {
		this.accountNumber = accountNumber;
		this.owner = owner;
		this.balance = 0;
		transactions = new Transaction[100];
		this.transactionCount = 0;
	}
	
	//거래 추가
	public void addTransaction(TransactionType type, int amount) {
		transactions[transactionCount] = new Transaction(type, amount);
		transactionCount++;
	}
	
	public void getTransactionHistory() { //거래 내역 조회
		
		if(transactionCount == 0) {
			System.out.println("거래 내역이 없습니다.");
		}
		
		//거래 내역
		for(int i = 0; i < transactionCount; i++) {
			String typeStr = (transactions[i].type == TransactionType.입금) ? 
					"입금" : "출금";
			System.out.println(" | " + typeStr + " | " + 
					transactions[i].amount + "원");
		}
	}
	
	public void deposit(int amount) { //입금
		if(amount <= 0) {
			System.out.println("유효한 금액을 입력하세요.");
		}
		else {
			this.balance += amount; //잔액 + 입금액
			System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " +
			          this.balance + "원");
			
			addTransaction(TransactionType.입금, amount); //입금 거래
		}
	}
	
	public void withdraw(int amount) { //출금
		if(amount <= 0) {
			System.out.println("유효한 금액을 입력하세요.");
		}else if(amount > balance) {
			System.out.println("잔액이 부족합니다.");
		}else {
			this.balance -= amount; //잔액 - 출금액
			System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " +
			          this.balance + "원");
			
			addTransaction(TransactionType.출금, amount); //출금 거래
		}
	}
	
	public void displayInfo() { //계좌 정보 출력
		System.out.println("계좌 정보");
		System.out.println("   계좌 번호: " + accountNumber);
		System.out.println("   계좌주: " + owner);
		System.out.println("   잔고: " + balance);
	}
}

