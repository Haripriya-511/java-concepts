package solidprinciples.dependencyinversion;
interface PaymentMethod {
    void pay(double amount);
}
class CreditCard implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+" using Credit Card");
    }
}
class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
class PaymentProcessor1 {
    private final PaymentMethod paymentMethod;
    public PaymentProcessor1(PaymentMethod paymentMethod){
        this.paymentMethod=paymentMethod;
    }
    public void processPayment(double amount){
        paymentMethod.pay(amount);
    }
}
public class DependencyInversionExample {
    public static void main(String[] args) {
        PaymentMethod creditCard = new CreditCard();
        PaymentMethod payPal = new PayPalPayment();

        PaymentProcessor1 processor1 = new PaymentProcessor1(creditCard);
        processor1.processPayment(100.0);
        PaymentProcessor1 processor2 = new PaymentProcessor1(payPal);
        processor2.processPayment(200.0);
    }
}
/*
Abstractions over Implementation: The PaymentProcessor depends on the PaymentMethod interface, not on specific implementations (CreditCardPayment, PayPalPayment).
Flexibility: Adding a new payment method (e.g., UPIPayment) requires only creating a new implementation of PaymentMethod. No changes are needed in the PaymentProcessor.
Easy to Test: Mocking the PaymentMethod interface is straightforward for testing the PaymentProcessor.
Reduced Coupling: High-level and low-level modules are decoupled, making the system easier to maintain and extend.

 */
