package payment_system.payment;

public class CreditCardPayment implements Payment{

	@Override
	public void pay(int amount) {
		System.out.println(amount + "원을 신용카드로 결제했습니다.");
	}

	@Override
	public String getPaymentType() {
		return "CreditCard";
	}

}
