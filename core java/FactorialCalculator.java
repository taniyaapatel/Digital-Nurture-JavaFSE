
import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            long f = 1;
            for (int i = 1; i <= n; i++) {
                f = f * i;
            }
            System.out.println("Factorial of " + n + " is: " + f);
        }
    }
}
