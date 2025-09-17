package payment_system.payment;

public interface Payment {
	public void pay(int amount);
	public String getPaymentType(); //결제 수단 
}


