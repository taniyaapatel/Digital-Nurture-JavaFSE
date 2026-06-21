package exercise6;
interface Image { void display(); }
class RealImage implements Image { public void display() { System.out.println("Displaying"); } }
class ProxyImage implements Image {
    RealImage r;
    public void display() { if(r==null) r = new RealImage(); r.display(); }
}
public class ProxyTest {
    public static void main(String[] args) { new ProxyImage().display(); }
}
