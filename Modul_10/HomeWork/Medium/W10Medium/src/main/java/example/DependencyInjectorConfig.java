package example;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
public class DependencyInjectorConfig {
    @Bean
    public PaymentProcessor visaPaymentProcessor() {
        return new VisaCardPaymentProcessor();
    }
    @Bean
    public PaymentProcessor masterCardPaymentProcessor() {
        return new MasterCardPaymentProcessor();
    }
    @Bean
    public PaymentProcessor bitcoinPaymentProcessor() {
        return new BitcoinPaymentProcessor();
    }
    @Bean
    public PaymentProcessor plovCoinPaymentProcessor() {
        return new PlovCoinPaymentProcessor();
    }
    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public OrderService orderService() {
// по умолчанию выберем Visa
        OrderService service = new OrderService();
        service.setPaymentProcessor(visaPaymentProcessor()); // внедряем вручную
        return service;
    }
}