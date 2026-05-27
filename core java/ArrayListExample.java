
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student names (type 'exit' to finish):");
        while (true) {
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("exit")) {
                break;
            }
            l.add(s);
        }
        System.out.println("\nAll entered names:");
        for (String s : l) {
            System.out.println(s);
        }
    }
}
