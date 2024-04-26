package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class TeacherAttendence {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JCheckBox chckbxNewCheckBox;
    private JCheckBox chckbxNewCheckBox_1;

    private Connection conn;
    private PreparedStatement pstmt;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	TeacherAttendence window = new TeacherAttendence();
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
    public TeacherAttendence() {
        initialize();
        connectToDB();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 0, 255));
        frame.setBounds(100, 100, 579, 381);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Teacher Attendance");
        lblNewLabel.setBounds(172, 7, 277, 33);
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(115, 1, 334, 57);
        lblNewLabel_1.setIcon(new ImageIcon(TeacherAttendence.class.getResource("/GUI/image/yellow-color-solid-background-1920x1080.png")));
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Date( yyyy-mm-dd)");
        lblNewLabel_2.setBounds(129, 88, 170, 25);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("Present");
        lblNewLabel_3.setBounds(326, 92, 102, 17);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Absent");
        lblNewLabel_4.setBounds(457, 88, 81, 25);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_4);
        
        textField = new JTextField();
        textField.setBounds(163, 147, 96, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setBounds(318, 147, 93, 21);
        chckbxNewCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxNewCheckBox.isSelected()) {
                    chckbxNewCheckBox_1.setSelected(false);
                }
            }
        });
        frame.getContentPane().add(chckbxNewCheckBox);
        
        chckbxNewCheckBox_1 = new JCheckBox("");
        chckbxNewCheckBox_1.setBounds(445, 147, 93, 21);
        chckbxNewCheckBox_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chckbxNewCheckBox_1.isSelected()) {
                    chckbxNewCheckBox.setSelected(false);
                }
            }
        });
        frame.getContentPane().add(chckbxNewCheckBox_1);
        
        JButton btnNewButton = new JButton("SUBMIT");
        btnNewButton.setBounds(172, 219, 112, 33);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveToDatabase();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("CLEAR");
        btnNewButton_1.setBounds(326, 219, 102, 33);
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(btnNewButton_1);
        
        JLabel lblNewLabel_5 = new JLabel("Facultyid :");
        lblNewLabel_5.setBounds(17, 92, 102, 17);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        frame.getContentPane().add(lblNewLabel_5);
        
        textField_1 = new JTextField();
        textField_1.setBounds(23, 147, 96, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
    }

    private void connectToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/teacherattendance", "root", "Rach123gullu@");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToDatabase() {
        String Facultyid = textField_1.getText();
        String date = textField.getText();
        String attendance = "";

        if (chckbxNewCheckBox.isSelected() && !chckbxNewCheckBox_1.isSelected()) {
            attendance = "PRESENT";
        } else if (!chckbxNewCheckBox.isSelected() && chckbxNewCheckBox_1.isSelected()) {
            attendance = "ABSENT";
        } else {
            // If neither checkbox is selected or both are selected
            System.out.println("Please select only one attendance (Present/Absent)");
            return;
        }

        try {
            String query = "INSERT INTO attendance (Facultyid, Date, Present, Absent) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, Facultyid);
            pstmt.setString(2, date);
            pstmt.setString(3, attendance.equals("PRESENT") ? "YES" : "NO");
            pstmt.setString(4, attendance.equals("ABSENT") ? "YES" : "NO");

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data uploaded successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
