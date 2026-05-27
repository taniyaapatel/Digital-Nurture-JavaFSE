
public class ModuleSystemDemo {
    public static void main(String[] args) {
        System.out.println("=== Java Module System Demo ===");
        System.out.println("Two modules are created in the 'modules' subdirectory:");
        System.out.println("1. com.utils: Exports com.utils package.");
        System.out.println("2. com.greetings: Requires com.utils package and calls com.utils.Helper.greet().");
        System.out.println("\nTo compile and run the modules from command line:");
        System.out.println("1. Compile com.utils:");
        System.out.println("   javac -d mods/com.utils modules/com.utils/module-info.java modules/com.utils/com/utils/Helper.java");
        System.out.println("2. Compile com.greetings:");
        System.out.println("   javac --module-path mods -d mods/com.greetings modules/com.greetings/module-info.java modules/com.greetings/com/greetings/Main.java");
        System.out.println("3. Run the application:");
        System.out.println("   java --module-path mods -m com.greetings/com.greetings.Main");
    }
}
