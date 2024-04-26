package GUI;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class TeacherFetch {

    JFrame frame;
    private JTable table;
    private String id;

    public TeacherFetch(String sapIdOrEmail) {
        this.id = sapIdOrEmail;
        initialize();
        loadData();
    }

    private void initialize() {
        frame = new JFrame("Dit University");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TeacherFetch.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        frame.setBounds(100, 100, 964, 439);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        frame.setVisible(true);
    }

    private void loadData() {
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";
        String password = "Rach123gullu@";

        try (
            // Create the connection
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Create a prepared statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM teacher where sap_id=?");
        ) {
            pstmt.setString(1, id);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();
            
            // Create a table model to hold the data
            DefaultTableModel model = new DefaultTableModel();
            
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
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}