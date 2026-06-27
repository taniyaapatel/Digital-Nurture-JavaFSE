
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {
    public static void main(String[] args) {

        ExecutorService ex = Executors.newFixedThreadPool(3);
        List<Future<Integer>> fl = new ArrayList<>();


        for (int i = 1; i <= 5; i++) {
            final int index = i;
            Callable<Integer> c = () -> {
                int sum = 0;
                for (int j = 1; j <= index * 10; j++) {
                    sum += j;
                }
                System.out.println("Task " + index + " running on: " + Thread.currentThread().getName());
                return sum;
            };
            fl.add(ex.submit(c));
        }


        System.out.println("\nCollecting results from Future objects:");
        for (int i = 0; i < fl.size(); i++) {
            try {
                int r = fl.get(i).get();
                System.out.println("Result of Task " + (i + 1) + ": " + r);
            } catch (Exception e) {
                System.out.println("Task failed: " + e.getMessage());
            }
        }


        ex.shutdown();
    }
}
