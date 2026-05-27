
public class DecompileDemo {
    public static void main(String[] args) {
        System.out.println("Decompile Demo");
        int a = 100;
        if (a > 50) {
            System.out.println("Greater than 50");
        } else {
            System.out.println("50 or less");
        }

        System.out.println("\n=== INSTRUCTIONS TO DECOMPILE A CLASS ===");
        System.out.println("1. Compile this class: javac DecompileDemo.java");
        System.out.println("2. You will get DecompileDemo.class in the folder.");
        System.out.println("3. Download a decompiler tool like JD-GUI (http://java-decompiler.github.io/) or CFR.");
        System.out.println("4. Open DecompileDemo.class inside the decompiler.");
        System.out.println("5. You will see reverse engineered Java code matching this file!");
    }
}
