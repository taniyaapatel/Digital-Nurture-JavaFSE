
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);
        int g;
        System.out.println("Guess a number between 1 and 100!");
        do {
            System.out.print("Enter your guess: ");
            g = sc.nextInt();
            if (g > n) {
                System.out.println("Too high!");
            } else if (g < n) {
                System.out.println("Too low!");
            } else {
                System.out.println("Correct! You got it!");
            }
        } while (g != n);
    }
}
