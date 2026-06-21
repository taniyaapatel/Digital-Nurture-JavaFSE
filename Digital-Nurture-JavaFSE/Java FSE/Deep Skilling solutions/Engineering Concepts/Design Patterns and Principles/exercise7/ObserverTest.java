package exercise7;
import java.util.*;
interface Observer { void update(double p); }
class StockMarket {
    List<Observer> obs = new ArrayList<>();
    void add(Observer o) { obs.add(o); }
    void setPrice(double p) { for(Observer o:obs) o.update(p); }
}
public class ObserverTest {
    public static void main(String[] args) {
        StockMarket s = new StockMarket();
        s.add(p -> System.out.println("Price: " + p));
        s.setPrice(100.5);
    }
}
