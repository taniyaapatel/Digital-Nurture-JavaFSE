
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        l.add("Banana");
        l.add("Apple");
        l.add("Orange");
        l.add("Grape");

        System.out.println("Before sorting: " + l);


        Collections.sort(l, (a, b) -> a.compareTo(b));

        System.out.println("After sorting: " + l);
    }
}
