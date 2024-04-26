package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection connection;
    Statement statement;

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql:///StudentMarks", "root", "Rach123gullu@");
            this.statement = this.connection.createStatement();
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }
}
