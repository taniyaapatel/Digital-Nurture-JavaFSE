
import java.lang.reflect.Method;

class Dummy {
    public void greet(String s) {
        System.out.println("Greetings, " + s + "! Called dynamically via Reflection.");
    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        try {

            Class<?> c = Class.forName("Dummy");
            System.out.println("Class loaded: " + c.getName());


            Method[] methods = c.getDeclaredMethods();
            System.out.println("\nMethods found in class:");
            for (Method m : methods) {
                System.out.print("Method Name: " + m.getName() + ", Params: ");
                Class<?>[] pt = m.getParameterTypes();
                for (Class<?> p : pt) {
                    System.out.print(p.getName() + " ");
                }
                System.out.println();
            }


            System.out.println("\nInvoking greet() dynamically:");
            Object inst = c.getDeclaredConstructor().newInstance();
            Method m = c.getDeclaredMethod("greet", String.class);
            m.invoke(inst, "Taniya");

        } catch (Exception e) {
            System.out.println("Reflection failed: " + e.getMessage());
        }
    }
}
