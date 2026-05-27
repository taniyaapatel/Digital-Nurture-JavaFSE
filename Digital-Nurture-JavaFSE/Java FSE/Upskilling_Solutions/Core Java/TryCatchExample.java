
import java.util.Scanner;

public class TryCatchExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        try {
            int c = a / b;
            System.out.println("Result of division: " + c);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
        }
    }
}
