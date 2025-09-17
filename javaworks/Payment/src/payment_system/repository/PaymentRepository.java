package payment_system.repository;

public interface PaymentRepository {
	public void save(String paymentType, int amount);
}
