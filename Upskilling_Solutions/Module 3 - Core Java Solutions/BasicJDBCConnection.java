
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        String u = "jdbc:mysql://localhost:3306/testdb";
        String usr = "root";
        String p = "password";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            System.out.println("Connecting to database...");
            Connection c = DriverManager.getConnection(u, usr, p);


            Statement s = c.createStatement();
            ResultSet r = s.executeQuery("SELECT * FROM students");

            while (r.next()) {
                System.out.println("ID: " + r.getInt("id") + ", Name: " + r.getString("name"));
            }

            r.close();
            s.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Database connection failed or table does not exist: " + e.getMessage());
            System.out.println("Note: Please make sure MySQL is running, testdb database and students table exist.");
        }
    }
}
