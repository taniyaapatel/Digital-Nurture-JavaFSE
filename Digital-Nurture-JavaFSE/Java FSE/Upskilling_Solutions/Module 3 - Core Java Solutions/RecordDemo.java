
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

record Person(String name, int age) {}

public class RecordDemo {
    public static void main(String[] args) {
        Person p1 = new Person("John", 25);
        Person p2 = new Person("Alice", 17);
        Person p3 = new Person("Bob", 30);

        System.out.println("Printed Persons:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        List<Person> l = new ArrayList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);

        System.out.println("\nPersons older than 18 (using stream):");
        List<Person> r = l.stream()
                          .filter(p -> p.age() >= 18)
                          .collect(Collectors.toList());

        for (Person p : r) {
            System.out.println(p);
        }
    }
}
