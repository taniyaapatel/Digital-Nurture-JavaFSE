
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsDemo {
    public static void main(String[] args) {
        int n = 100000;
        System.out.println("Launching " + n + " virtual threads...");

        Instant start = Instant.now();
        List<Thread> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final int index = i;
            Thread t = Thread.startVirtualThread(() -> {
                if (index % 20000 == 0) {
                    System.out.println("Virtual thread " + index + " executing.");
                }
            });
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
        System.out.println("All virtual threads finished!");
        System.out.println("Time taken: " + Duration.between(start, end).toMillis() + " ms");
    }
}
