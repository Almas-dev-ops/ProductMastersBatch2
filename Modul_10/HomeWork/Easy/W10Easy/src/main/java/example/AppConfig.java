package example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {
//    @Bean
//    public GreetingService greetingService() {
//
//        return new RussianGreetingService();
//    }
    @Bean
    public GreetingService greetingService() {

        return new EnglishGreetingService();
    }
    @Bean
    public AppRunner appRunner() {
        return new AppRunner(greetingService());
    }
}