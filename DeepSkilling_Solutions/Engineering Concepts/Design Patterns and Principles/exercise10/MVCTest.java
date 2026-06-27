package exercise10;
class Model { String name = "John"; }
class View { void print(String n) { System.out.println(n); } }
class Controller {
    Model m; View v;
    Controller(Model m, View v) { this.m=m; this.v=v; }
    void update() { v.print(m.name); }
}
public class MVCTest {
    public static void main(String[] args) { new Controller(new Model(), new View()).update(); }
}
