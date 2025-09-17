package payment_system.payment;

public class KakaoPayPayment implements Payment{

	@Override
	public void pay(int amount) {
		System.out.println(amount + "원을 카카오페이로 결제했습니다.");
	}

	@Override
	public String getPaymentType() {
		return "KakaoPay";
	}

}
