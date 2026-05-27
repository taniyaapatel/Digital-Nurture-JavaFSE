
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        l.add(7);
        l.add(8);
        l.add(9);
        l.add(10);

        System.out.println("Original list: " + l);

        List<Integer> r = l.stream()
                           .filter(x -> x % 2 == 0)
                           .collect(Collectors.toList());

        System.out.println("Even numbers: " + r);
    }
}
