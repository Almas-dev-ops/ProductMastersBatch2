package example;

import java.math.BigDecimal;
public class PlovCoinPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Оплачиваю через PlovCoin: " + amount + " PLC");
    }
}