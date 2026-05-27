
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReading {
    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new FileReader("output.txt"));
            String l;
            System.out.println("Reading contents of output.txt:");
            while ((l = r.readLine()) != null) {
                System.out.println(l);
            }
            r.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
