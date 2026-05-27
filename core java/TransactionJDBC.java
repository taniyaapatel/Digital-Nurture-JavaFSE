
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionJDBC {
    public static void main(String[] args) {
        String u = "jdbc:mysql://localhost:3306/testdb";
        String usr = "root";
        String p = "password";

        Connection c = null;
        try {
            c = DriverManager.getConnection(u, usr, p);

            c.setAutoCommit(false);



            int a1 = 1;
            int a2 = 2;
            double b = 500.0;


            PreparedStatement ps1 = c.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            ps1.setDouble(1, b);
            ps1.setInt(2, a1);
            ps1.executeUpdate();
            ps1.close();


            PreparedStatement ps2 = c.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");
            ps2.setDouble(1, b);
            ps2.setInt(2, a2);
            ps2.executeUpdate();
            ps2.close();


            c.commit();
            System.out.println("Transaction committed successfully. Money transferred.");
        } catch (Exception e) {
            System.out.println("Transaction failed, rolling back. Error: " + e.getMessage());
            if (c != null) {
                try {
                    c.rollback();
                    System.out.println("Rollback done.");
                } catch (Exception ex) {
                    System.out.println("Rollback failed: " + ex.getMessage());
                }
            }
        } finally {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
