package example;

import java.math.BigDecimal;
public class OrderService {
    private PaymentProcessor paymentProcessor;
    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    public OrderService() {
        System.out.println("Создался OrderService: " + this);
    }
    public void makeOrder(BigDecimal amount) {
        if (paymentProcessor == null) {
            throw new IllegalStateException("PaymentProcessor не установлен");
        }
        paymentProcessor.processPayment(amount);
    }
}