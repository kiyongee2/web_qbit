package payment_system.repository;

public class JdbcPaymentRepository implements PaymentRepository{

	@Override
	public void save(String paymentType, int amount) {
		System.out.println("DB에 저장됨: " + paymentType + " - " + amount + "원");
	}

}
