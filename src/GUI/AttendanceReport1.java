package GUI;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class AttendanceReport1 {

    JFrame frame;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	AttendanceReport1 window = new AttendanceReport1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AttendanceReport1() {
        initialize();
        loadData();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Teacher Attendance");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Attendancereport.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(false);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
    }

    /**
     * Load data from the database.
     */
    private void loadData() {
        try {
            // JDBC connection parameters
            String url = "jdbc:mysql://localhost:3306/teacherattendance";
            String user = "root"; // Replace with your database username
            String password = "Rach123gullu@"; // Replace with your database password

            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Create the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Create a statement
            Statement stmt = conn.createStatement();
            
            // Execute the query
            String query = "SELECT * FROM attendance";
            ResultSet rs = stmt.executeQuery(query);
            
            // Create a table model to hold the data
            // For simplicity, we'll use a DefaultTableModel
            // You can create a custom table model for better control
            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
            
            // Retrieve the metadata
            java.sql.ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
            
            // Add columns to the table model
            for (int i = 1; i <= numColumns; i++) {
                model.addColumn(rsmd.getColumnName(i));
            }
            
            // Add rows to the table model
            while (rs.next()) {
                Object[] row = new Object[numColumns];
                for (int i = 1; i <= numColumns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                model.addRow(row);
            }
            
            // Set the table model to the table
            table.setModel(model);
            
            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
