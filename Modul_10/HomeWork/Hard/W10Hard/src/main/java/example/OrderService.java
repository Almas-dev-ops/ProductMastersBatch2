package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
@Service
public class OrderService {
    private final PaymentProcessor paymentProcessor;

    //Внедряем нужную реализацию по имени бина
    @Autowired
    public OrderService(@Qualifier("bitcoinProcessor") PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
        System.out.println("Создан OrderService: " + this);
    }
    public void makeOrder(BigDecimal amount) {
        paymentProcessor.processPayment(amount);
    }
}