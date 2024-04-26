package GUI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Window;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Screen1 {

    JFrame frame;
    private JLabel lblNewLabel_2;
    private Connection conn;
    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Screen1 window = new Screen1(null);
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     * @param sapIdOrEmail 
     */
    public Screen1(String sapIdOrEmail) {
        initialize(sapIdOrEmail);
    }

    private void initialize(String sapIdOrEmail) {
    	System.out.println("this is called");
    	connectToDB();
        frame = new JFrame("WELCOME TO DIT UNIVERSITY");
        frame.getContentPane().setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 912, 579);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 118, 999, 424);
        lblNewLabel.setIcon(new ImageIcon(Screen1.class.getResource("/GUI/image/WhatsApp Image 2024-04-09 at 20.17.55_7e380a6f.jpg")));
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(0, 0, 192, 119);
        lblNewLabel_1.setForeground(new Color(64, 0, 0));
        lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        lblNewLabel_1.setIcon(new ImageIcon(Screen1.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        lblNewLabel_1.setToolTipText("");
        frame.getContentPane().add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Phone No : 1800 1210 41000");
        lblNewLabel_2.setBounds(728, 10, 170, 33);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        frame.getContentPane().add(lblNewLabel_2);

        JButton btnNewButton = new JButton("Student Information");
        btnNewButton.setBounds(190, 12, 192, 27);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBackground(new Color(0, 0, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	StudentFetch sf = new StudentFetch(sapIdOrEmail);
                // Add your student information code here
            }
        });
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Student Marks");
        btnNewButton_1.setBounds(386, 11, 182, 28);
        btnNewButton_1.setBackground(new Color(0, 0, 255));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
          	              // Add your teacher login code here
            	marksFetch sl = new  marksFetch ();        
             sl.frame.setVisible(true);
             }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Attendance Report");
        btnNewButton_2.setBounds(571, 10, 151, 28);
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Attendancereport sl = new  Attendancereport();        
                sl.frame.setVisible(true);
//                frame.setVisible(false);
            }
        });
        btnNewButton_2.setBackground(new Color(0, 0, 255));
        frame.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("About University");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		About sl = new  About();        
                sl.frame.setVisible(true);
        		
        	}
        });
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_3.setBackground(new Color(255, 255, 0));
        btnNewButton_3.setBounds(191, 68, 191, 27);
        frame.getContentPane().add(btnNewButton_3);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon(Screen1.class.getResource("/GUI/image/light-brown-color-solid-background-1920x1080.png")));
        lblNewLabel_3.setBackground(new Color(0, 255, 0));
        lblNewLabel_3.setBounds(193, 0, 705, 60);
        frame.getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setBackground(new Color(255, 128, 64));
        lblNewLabel_4.setIcon(new ImageIcon(Screen1.class.getResource("/GUI/image/081aed2e7ddc029f940021ddb22145fc - Copy.jpg")));
        lblNewLabel_4.setBounds(190, 59, 708, 60);
        frame.getContentPane().add(lblNewLabel_4);

        frame.setVisible(true);
    }
    private void searchStudentBySapId(String sapId) {
        try {
            // Create a SQL statement
            Statement statement = conn.createStatement();

            // SQL query to search for a student by SAP ID
            String sql = "SELECT * FROM students WHERE sap_id = '" + sapId + "'";

            // Execute the query
            ResultSet resultSet = statement.executeQuery(sql);
            // Check if result set has any data
            if (resultSet.next()) {
                // Retrieve student details from the result set
            	
                String studentName = resultSet.getString("student_name");
//                Name.setText(studentName);
                String rollNo = resultSet.getString("father_name");
//                Roll.setText(rollNo);
                System.out.println(studentName + rollNo );
//                Adress.setText(address);
//                Sap.setText(sap);
            } else {
                // No data found
                System.out.println("No student found with SAP ID: " + sapId);
            }

            // Close the statement and result set
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error occurred while searching for the student.");
        }
    }
    private void connectToDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/studentregistation";
            String username = "root";
            String password = "Rach123gullu@";

            conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
