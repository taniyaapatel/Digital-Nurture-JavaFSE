
public class OperatorPrecedence {
    public static void main(String[] args) {
        int r = 10 + 5 * 2;
        System.out.println("Expression: 10 + 5 * 2");
        System.out.println("Result: " + r);
        System.out.println("Explanation: Multiplication (*) has higher precedence than addition (+). So, 5 * 2 is evaluated first (10), and then 10 + 10 is evaluated (20).");

        int r2 = (10 + 5) * 2;
        System.out.println("\nExpression: (10 + 5) * 2");
        System.out.println("Result: " + r2);
        System.out.println("Explanation: Parentheses () have the highest precedence, so 10 + 5 is evaluated first (15), and then 15 * 2 is evaluated (30).");
    }
}
