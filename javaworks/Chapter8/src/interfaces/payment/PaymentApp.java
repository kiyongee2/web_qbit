package interfaces.payment;

//결제 인터페이스 (규약)
interface Payment {
 void pay(int amount);
}

//신용카드 결제 구현
class CreditCardPayment implements Payment {
 
	@Override
	public void pay(int amount) {
     System.out.println(amount + "원을 신용카드로 결제했습니다.");
	}
}

//카카오페이 결제 구현
class KakaoPayPayment implements Payment {
	
	@Override
	public void pay(int amount) {
	    System.out.println(amount + "원을 카카오페이로 결제했습니다.");
	}
}

//실제 사용
public class PaymentApp {
 public static void main(String[] args) {
	 
     Payment payment1 = new CreditCardPayment();
     Payment payment2 = new KakaoPayPayment();

     payment1.pay(10000);  // 신용카드 결제
     payment2.pay(5000);   // 카카오페이 결제
 }
}


