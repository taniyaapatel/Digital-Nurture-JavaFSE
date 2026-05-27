
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to write to output.txt: ");
        String s = sc.nextLine();
        try {
            FileWriter w = new FileWriter("output.txt");
            w.write(s);
            w.close();
            System.out.println("Successfully wrote data to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
