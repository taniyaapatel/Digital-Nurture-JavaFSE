package exercise5;
interface Notifier { void send(); }
class Email implements Notifier { public void send() { System.out.println("Email"); } }
class SMSDecorator implements Notifier {
    Notifier w; SMSDecorator(Notifier w) { this.w = w; }
    public void send() { w.send(); System.out.println("SMS"); }
}
public class DecoratorTest {
    public static void main(String[] args) { new SMSDecorator(new Email()).send(); }
}
