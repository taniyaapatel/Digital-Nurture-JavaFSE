public class PatternMatchingSwitch {

    public static void checkType(Object o) {
        String msg;

        if (o instanceof Integer i) {
            msg = "It is an Integer: " + i;
        } else if (o instanceof String s) {
            msg = "It is a String: " + s;
        } else if (o instanceof Double d) {
            msg = "It is a Double: " + d;
        } else if (o == null) {
            msg = "It is null!";
        } else {
            msg = "Unknown type: " + o.getClass().getName();
        }

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