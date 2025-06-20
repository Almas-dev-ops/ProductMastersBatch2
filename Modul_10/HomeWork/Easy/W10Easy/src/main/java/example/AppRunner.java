package example;

public class AppRunner {
    private final GreetingService greetingService;
    public AppRunner(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    public void run() {
        greetingService.sayHello();
    }
}