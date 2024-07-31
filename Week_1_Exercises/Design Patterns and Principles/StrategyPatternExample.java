interface PaymentStrategy {
    void pay(double amount);
}

// Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardHolderName;
    private String cardNumber;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardHolderName, String cardNumber, String cvv, String expiryDate) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        // Here, you would normally process the payment through a payment gateway
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String emailAddress;
    private String password;

    public PayPalPayment(String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        // Here, you would normally interact with the PayPal API to process the payment
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

// Implement Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy not set.");
        }
        paymentStrategy.pay(amount);
    }
}

// Test the Strategy Implementation
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Pay using Credit Card
        paymentContext.setPaymentStrategy(new CreditCardPayment("John Doe", "1234567812345678", "123", "12/25"));
        paymentContext.executePayment(500.0);

        // Pay using PayPal
        paymentContext.setPaymentStrategy(new PayPalPayment("john.doe@example.com", "password123"));
        paymentContext.executePayment(300.0);
    }
}
