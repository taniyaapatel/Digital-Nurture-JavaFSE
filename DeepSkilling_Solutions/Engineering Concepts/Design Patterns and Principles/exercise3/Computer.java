package exercise3;
public class Computer {
    private String cpu;
    private Computer(Builder b) { this.cpu = b.cpu; }
    public static class Builder {
        private String cpu;
        public Builder setCpu(String c) { this.cpu = c; return this; }
        public Computer build() { return new Computer(this); }
    }
    public static void main(String[] args) {
        Computer c = new Computer.Builder().setCpu("Intel").build();
        System.out.println(c.cpu);
    }
}
