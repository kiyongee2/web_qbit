package payment_system;

import payment_system.payment.CreditCardPayment;
import payment_system.payment.KakaoPayPayment;
import payment_system.payment.Payment;
import payment_system.repository.JdbcPaymentRepository;
import payment_system.repository.PaymentRepository;
import payment_system.service.PaymentService;

public class PaymentApp {

	public static void main(String[] args) {
		// DB 저장소
		PaymentRepository repo = new JdbcPaymentRepository();
		PaymentService service = new PaymentService(repo);
		
		//결제 수단 준비
		Payment card = new CreditCardPayment();
		Payment kakao = new KakaoPayPayment();
		
		//결재 실행
		service.processPayment(card, 10000);
		service.processPayment(kakao, 5000);
	}

}
