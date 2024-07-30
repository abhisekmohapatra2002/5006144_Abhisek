
public class AdapterPatternExample {

    interface PaymentProcessor {
        void processPayment(double amount);
    }

    static class PayPal {
        public void sendPayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }

    static class Stripe {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through Stripe.");
        }
    }

    static class Square {
        public void processTransaction(double amount) {
            System.out.println("Processing payment of $" + amount + " through Square.");
        }
    }

    static class PayPalAdapter implements PaymentProcessor {
        private PayPal payPal;

        public PayPalAdapter(PayPal payPal) {
            this.payPal = payPal;
        }

        @Override
        public void processPayment(double amount) {
            payPal.sendPayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment(double amount) {
            stripe.makePayment(amount);
        }
    }

    static class SquareAdapter implements PaymentProcessor {
        private Square square;

        public SquareAdapter(Square square) {
            this.square = square;
        }

        @Override
        public void processPayment(double amount) {
            square.processTransaction(amount);
        }
    }

    public static void main(String[] args) {
        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor squareProcessor = new SquareAdapter(new Square());

        payPalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(200.0);
        squareProcessor.processPayment(300.0);
    }
}


/*
output :- 
-------
Processing payment of $100.0 through PayPal.
Processing payment of $200.0 through Stripe.
Processing payment of $300.0 through Square.

*/

