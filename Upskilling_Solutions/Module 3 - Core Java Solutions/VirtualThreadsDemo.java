import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsDemo {

    public static void main(String[] args) {

        int n = 1000; // reduced for normal threads

        System.out.println("Launching " + n + " threads...");

        Instant start = Instant.now();

        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            final int index = i;

            Thread t = new Thread(() -> {
                if (index % 200 == 0) {
                    System.out.println("Thread " + index + " executing.");
                }
            });

            t.start();
            list.add(t);
        }

        for (Thread t : list) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        Instant end = Instant.now();

        System.out.println("All threads finished!");
        System.out.println("Time taken: "
                + Duration.between(start, end).toMillis()
                + " ms");
    }
}