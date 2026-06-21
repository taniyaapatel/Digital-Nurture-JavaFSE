package exercise8;
interface PaymentStrategy { void pay(int a); }
class Context {
    PaymentStrategy s;
    void set(PaymentStrategy s) { this.s = s; }
    void pay(int a) { s.pay(a); }
}
public class StrategyTest {
    public static void main(String[] args) {
        Context c = new Context();
        c.set(a -> System.out.println("Paid " + a));
        c.pay(10);
    }
}
