
import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        double[] a = new double[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        double s = 0;
        for (int i = 0; i < n; i++) {
            s += a[i];
        }
        double av = s / n;
        System.out.println("Sum: " + s);
        System.out.println("Average: " + av);
    }
}
