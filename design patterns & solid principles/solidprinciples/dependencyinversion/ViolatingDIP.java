package solidprinciples.dependencyinversion;
class CreditCardPayment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}
class PaymentProcessor {
    private CreditCardPayment creditCardPayment;

    public PaymentProcessor() {
        this.creditCardPayment = new CreditCardPayment();
    }

    public void processPayment(double amount) {
        creditCardPayment.pay(amount); // Direct dependency
    }
}
public class ViolatingDIP {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(100.0);
    }
}
/*
Tight Coupling: The PaymentProcessor is tightly coupled with CreditCardPayment. If we want to add another payment method (e.g., PayPal), we have to modify the PaymentProcessor class.
dding new payment methods or replacing the existing one requires code changes in multiple places, violating the Open-Closed Principle (OCP).
 */
