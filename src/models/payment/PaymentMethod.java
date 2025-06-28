package models.payment;

public interface PaymentMethod {
    boolean initiatePayment(float amount);
}
