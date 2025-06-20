package example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.math.BigDecimal;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                AnnotationConfigApplicationContext(DependencyInjectorConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        orderService.makeOrder(BigDecimal.valueOf(15));

        PaymentProcessor masterCard = context.getBean("masterCardPaymentProcessor",
                PaymentProcessor.class);
        orderService.setPaymentProcessor(masterCard);
        orderService.makeOrder(BigDecimal.valueOf(20));

        PaymentProcessor bitcoin = context.getBean("bitcoinPaymentProcessor",
                PaymentProcessor.class);
        orderService.setPaymentProcessor(bitcoin);
        orderService.makeOrder(BigDecimal.valueOf(0.0025));

        PaymentProcessor plovCoin = context.getBean("plovCoinPaymentProcessor",
                PaymentProcessor.class);
        orderService.setPaymentProcessor(plovCoin);
        orderService.makeOrder(BigDecimal.valueOf(1000));
    }
}