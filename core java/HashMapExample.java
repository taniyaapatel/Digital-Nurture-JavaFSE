
import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> m = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student details (ID and Name). Type -1 for ID to finish.");
        while (true) {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            if (id == -1) {
                break;
            }
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            m.put(id, name);
        }

        System.out.print("\nEnter ID to search: ");
        int searchId = sc.nextInt();
        if (m.containsKey(searchId)) {
            System.out.println("Found Name: " + m.get(searchId));
        } else {
            System.out.println("ID not found!");
        }
    }
}
