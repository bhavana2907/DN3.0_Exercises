package AdapterPatternExample;

interface PaymentHandler {
    void handlePayment(double amount);
}

class PayPalService {
    public void executePayment(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through PayPal.");
    }
}

class StripeService {
    public void execute(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through Stripe.");
    }
}

class AmazonPayService {
    public void process(double amount) {
        System.out.println("Processing payment of Rs." + amount + " through Amazon Pay.");
    }
}

class PayPalHandlerAdapter implements PaymentHandler {
    private PayPalService payPalService;

    public PayPalHandlerAdapter(PayPalService payPalService) {
        this.payPalService = payPalService;
    }

    public void handlePayment(double amount) {
        payPalService.executePayment(amount);
    }
}

class StripeHandlerAdapter implements PaymentHandler {
    private StripeService stripeService;

    public StripeHandlerAdapter(StripeService stripeService) {
        this.stripeService = stripeService;
    }

    public void handlePayment(double amount) {
        stripeService.execute(amount);
    }
}

class AmazonPayHandlerAdapter implements PaymentHandler {
    private AmazonPayService amazonPayService;

    public AmazonPayHandlerAdapter(AmazonPayService amazonPayService) {
        this.amazonPayService = amazonPayService;
    }

    public void handlePayment(double amount) {
        amazonPayService.process(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PayPalService payPalService = new PayPalService();
        StripeService stripeService = new StripeService();
        AmazonPayService amazonPayService = new AmazonPayService();

        PaymentHandler payPalAdapter = new PayPalHandlerAdapter(payPalService);
        PaymentHandler stripeAdapter = new StripeHandlerAdapter(stripeService);
        PaymentHandler amazonPayAdapter = new AmazonPayHandlerAdapter(amazonPayService);

        payPalAdapter.handlePayment(400.00);
        stripeAdapter.handlePayment(500.00);
        amazonPayAdapter.handlePayment(600.00);
    }
}
