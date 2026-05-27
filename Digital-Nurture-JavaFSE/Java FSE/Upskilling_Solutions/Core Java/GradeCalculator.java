
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks (out of 100): ");
        int m = sc.nextInt();
        char g;
        if (m >= 90 && m <= 100) {
            g = 'A';
        } else if (m >= 80 && m < 90) {
            g = 'B';
        } else if (m >= 70 && m < 80) {
            g = 'C';
        } else if (m >= 60 && m < 70) {
            g = 'D';
        } else {
            g = 'F';
        }
        System.out.println("Assigned Grade: " + g);
    }
}
