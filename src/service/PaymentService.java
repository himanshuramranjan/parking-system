package service;

import models.payment.Cash;
import models.payment.CreditCard;
import models.payment.PaymentMethod;

public class PaymentService {

    private static volatile PaymentService paymentService;
    private PaymentService() {}

    public static PaymentService getInstance() {
        if(paymentService == null) {
            synchronized (PaymentService.class) {
                if(paymentService == null) {
                    paymentService = new PaymentService();
                }
            }
        }
        return paymentService;
    }

    public boolean payByCash(float amount) {
        PaymentMethod cash = new Cash();
        return cash.initiatePayment(amount);
    }

    public boolean payByCard(String cardNumber, int cvv, float amount) {
        PaymentMethod creditCard = new CreditCard(cardNumber, cvv);
        return creditCard.initiatePayment(amount);
    }
}
