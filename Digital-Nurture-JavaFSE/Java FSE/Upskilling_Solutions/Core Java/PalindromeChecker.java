
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String clean = sb.toString();

        boolean pal = true;
        int l = 0;
        int r = clean.length() - 1;
        while (l < r) {
            if (clean.charAt(l) != clean.charAt(r)) {
                pal = false;
                break;
            }
            l++;
            r--;
        }

        if (pal) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }
    }
}
