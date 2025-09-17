package interfaces.payment_db;

public class PaymentApp {
	public static void main(String[] args) {
		// DB 저장소 준비
        PaymentRepository repo = new JdbcPaymentRepository();
        PaymentService service = new PaymentService(repo);

        // 결제 수단 준비
        Payment card = new CreditCardPayment();
        Payment kakao = new KakaoPayPayment();

        // 결제 실행
        service.processPayment(card, 10000);
        service.processPayment(kakao, 5000);
	}
} 
