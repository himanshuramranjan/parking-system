package models.payment;

public class CreditCard implements PaymentMethod {

    private String cardNumber;
    private int cvv;

    public CreditCard(String cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public boolean initiatePayment(float amount) {
        return true;
    }
}
