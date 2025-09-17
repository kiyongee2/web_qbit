package interfaces.payment_db;

public class PaymentService {
	
    private final PaymentRepository paymentRepository;

    // 생성자 주입 (DI)
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // 결제 실행 및 DB 저장
    public void processPayment(Payment payment, int amount) {
        payment.pay(amount);  // 결제 진행
        paymentRepository.save(payment.getPaymentType(), amount); // DB 저장
    }
}

