package exercise9;
interface Command { void exec(); }
class Light { void on() { System.out.println("ON"); } }
class OnCommand implements Command { Light l; OnCommand(Light l){this.l=l;} public void exec(){l.on();} }
public class CommandTest {
    public static void main(String[] args) { new OnCommand(new Light()).exec(); }
}
