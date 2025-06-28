package models.payment;

public class Cash implements PaymentMethod {
    @Override
    public boolean initiatePayment(float amount) {
        System.out.println("Paying the amount for cash " + amount);
        return true;
    }
}
