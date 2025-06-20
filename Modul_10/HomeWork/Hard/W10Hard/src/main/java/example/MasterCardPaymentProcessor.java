package example;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component("masterCardProcessor")

public class MasterCardPaymentProcessor implements PaymentProcessor {
    @Override
    public void processPayment(BigDecimal amount) {
        System.out.println("Оплачиваю через MasterCard ĸарту: " + amount);
    }
}
