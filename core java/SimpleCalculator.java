
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.print("Choose operation (+, -, *, /): ");
        char c = sc.next().charAt(0);
        double r = 0;
        boolean ok = true;
        if (c == '+') {
            r = a + b;
        } else if (c == '-') {
            r = a - b;
        } else if (c == '*') {
            r = a * b;
        } else if (c == '/') {
            if (b != 0) {
                r = a / b;
            } else {
                System.out.println("Error: division by zero");
                ok = false;
            }
        } else {
            System.out.println("Invalid operation");
            ok = false;
        }
        if (ok) {
            System.out.println("Result: " + r);
        }
    }
}
