package payment_system.service;

import payment_system.payment.Payment;
import payment_system.repository.PaymentRepository;

public class PaymentService {
	private final PaymentRepository paymentRepository;
	
	//생성자
	public PaymentService(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	//결제 실행
	public void processPayment(Payment payment, int amount) {
		payment.pay(amount);
		paymentRepository.save(payment.getPaymentType(), amount);
	}
}
