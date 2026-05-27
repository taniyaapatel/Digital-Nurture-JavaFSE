
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class StudentDAO {
    private String u = "jdbc:mysql://localhost:3306/testdb";
    private String usr = "root";
    private String p = "password";

    private Connection getConn() throws Exception {
        return DriverManager.getConnection(u, usr, p);
    }

    public void insertStudent(int id, String name) {
        try {
            Connection c = getConn();
            String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
            System.out.println("Student inserted successfully.");
            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Failed to insert student: " + e.getMessage());
        }
    }

    public void updateStudent(int id, String name) {
        try {
            Connection c = getConn();
            String sql = "UPDATE students SET name = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("Student updated successfully.");
            ps.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Failed to update student: " + e.getMessage());
        }
    }
}

public class InsertUpdateJDBC {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        dao.insertStudent(101, "Taniya");
        dao.updateStudent(101, "Taniya Sen");
    }
}
