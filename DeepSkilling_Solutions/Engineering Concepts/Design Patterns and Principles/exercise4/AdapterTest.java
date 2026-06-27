package exercise4;
interface PaymentProcessor { void pay(); }
class Stripe { void makePayment() { System.out.println("Stripe"); } }
class StripeAdapter implements PaymentProcessor {
    Stripe s = new Stripe();
    public void pay() { s.makePayment(); }
}
public class AdapterTest {
    public static void main(String[] args) { new StripeAdapter().pay(); }
}
