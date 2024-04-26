import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HighestMarksStudent {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    static final String USER = "root";
    static final String PASS = "Rach123gullu@";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT name FROM students WHERE marks = (SELECT MAX(marks) FROM students)";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Student with highest marks: " + name);
            } else {
                System.out.println("No records found");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (Exception se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (Exception se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye Rachit!");
    }
}
