
import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String s) {
        super(s);
    }
}

public class CustomExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int a = sc.nextInt();
        try {
            if (a < 18) {
                throw new InvalidAgeException("Age is less than 18!");
            }
            System.out.println("Age is valid.");
        } catch (InvalidAgeException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        }
    }
}
