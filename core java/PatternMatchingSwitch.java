
public class PatternMatchingSwitch {
    public static void checkType(Object o) {
        String msg = switch (o) {
            case Integer i -> "It is an Integer: " + i;
            case String s -> "It is a String: " + s;
            case Double d -> "It is a Double: " + d;
            case null -> "It is null!";
            default -> "Unknown type: " + o.toString();
        };
        System.out.println(msg);
    }

    public static void main(String[] args) {
        checkType(100);
        checkType("Hello Java 21");
        checkType(45.67);
        checkType(null);
        checkType(new Object());
    }
}
