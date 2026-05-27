
public class JavapDemo {
    public void displayMessage() {
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println("Sum inside method: " + c);
    }

    public static void main(String[] args) {
        JavapDemo d = new JavapDemo();
        d.displayMessage();

        System.out.println("\n=== INSTRUCTIONS TO RUN javap ===");
        System.out.println("1. Compile this class: javac JavapDemo.java");
        System.out.println("2. Run javap tool: javap -c JavapDemo");
        System.out.println("\nExpected typical bytecode output for displayMessage():");
        System.out.println("   0: bipush        10");
        System.out.println("   2: istore_1");
        System.out.println("   3: bipush        20");
        System.out.println("   5: istore_2");
        System.out.println("   6: iload_1");
        System.out.println("   7: iload_2");
        System.out.println("   8: iadd");
        System.out.println("   9: istore_3");
    }
}
