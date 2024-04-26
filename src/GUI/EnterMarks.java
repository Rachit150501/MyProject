package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.Color;

public class EnterMarks {

    JFrame frame;
    private JTextField textField;
    private JComboBox<String> comboBox;
    private JTextField sub1;
    private JTextField sub2;
    private JTextField sub3;
    private JTextField sub4;
    private JTextField sub5;
    private JTextField Mrk1;
    private JTextField Mrk2;
    private JTextField Mrk3;
    private JTextField Mrk4;
    private JTextField Mrk5;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EnterMarks window = new EnterMarks();
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
    public EnterMarks() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Enter Marks");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 620, 483);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter Student Marks :");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(10, 20, 283, 25);
        frame.getContentPane().add(lblNewLabel);

        JLabel rollno = new JLabel("rollno");
        rollno.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rollno.setBounds(27, 70, 74, 25);
        frame.getContentPane().add(rollno);

        textField = new JTextField();
        textField.setBounds(160, 75, 149, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel(" Semester");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(23, 120, 67, 13);
        frame.getContentPane().add(lblNewLabel_2);

        String[] semester = {"First Sem", "Second Sem", "Third Sam", "Fourth Sam", "Fiveth Sam", "Six Sam", "Seven Sam", "Eight Sam"};
        comboBox = new JComboBox<>(semester);
        comboBox.setBounds(160, 118, 149, 21);
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel_3 = new JLabel("Enter Subject");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_3.setBounds(64, 171, 101, 13);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Enter Marks");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel_4.setBounds(319, 171, 101, 25);
        frame.getContentPane().add(lblNewLabel_4);

        sub1 = new JTextField();
        sub1.setBounds(74, 206, 96, 19);
        frame.getContentPane().add(sub1);
        sub1.setColumns(10);

        sub2 = new JTextField();
        sub2.setColumns(10);
        sub2.setBounds(74, 235, 96, 19);
        frame.getContentPane().add(sub2);

        sub3 = new JTextField();
        sub3.setColumns(10);
        sub3.setBounds(74, 264, 96, 19);
        frame.getContentPane().add(sub3);

        sub4 = new JTextField();
        sub4.setColumns(10);
        sub4.setBounds(74, 293, 96, 19);
        frame.getContentPane().add(sub4);

        sub5 = new JTextField();
        sub5.setColumns(10);
        sub5.setBounds(74, 331, 96, 19);
        frame.getContentPane().add(sub5);

        Mrk1 = new JTextField();
        Mrk1.setColumns(10);
        Mrk1.setBounds(307, 206, 96, 19);
        frame.getContentPane().add(Mrk1);

        Mrk2 = new JTextField();
        Mrk2.setColumns(10);
        Mrk2.setBounds(307, 235, 96, 19);
        frame.getContentPane().add(Mrk2);

        Mrk3 = new JTextField();
        Mrk3.setColumns(10);
        Mrk3.setBounds(307, 264, 96, 19);
        frame.getContentPane().add(Mrk3);

        Mrk4 = new JTextField();
        Mrk4.setColumns(10);
        Mrk4.setBounds(307, 293, 96, 19);
        frame.getContentPane().add(Mrk4);

        Mrk5 = new JTextField();
        Mrk5.setColumns(10);
        Mrk5.setBounds(307, 331, 96, 19);
        frame.getContentPane().add(Mrk5);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection conn = getConnection();
                    String rollno = textField.getText();
                    String semester = (String) comboBox.getSelectedItem();

                    String Q1 = "INSERT INTO subject1 (rollno, semester, sub1, sub2, sub3, sub4, sub5) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    String Q2 = "INSERT INTO marks (rollno, semester, Mrk1, Mrk2, Mrk3, Mrk4, Mrk5) VALUES (?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement pstmt1 = conn.prepareStatement(Q1);
                    PreparedStatement pstmt2 = conn.prepareStatement(Q2);

                    pstmt1.setString(1, rollno);
                    pstmt1.setString(2, semester);
                    pstmt1.setString(3, sub1.getText());
                    pstmt1.setString(4, sub2.getText());
                    pstmt1.setString(5, sub3.getText());
                    pstmt1.setString(6, sub4.getText());
                    pstmt1.setString(7, sub5.getText());

                    pstmt2.setString(1, rollno);
                    pstmt2.setString(2, semester);
                    pstmt2.setInt(3, isValidInt(Mrk1.getText()));
                    pstmt2.setInt(4, isValidInt(Mrk2.getText()));
                    pstmt2.setInt(5, isValidInt(Mrk3.getText()));
                    pstmt2.setInt(6, isValidInt(Mrk4.getText()));
                    pstmt2.setInt(7, isValidInt(Mrk5.getText()));

                    pstmt1.executeUpdate();
                    pstmt2.executeUpdate();

                    textField.setText("");
                    comboBox.setSelectedIndex(0);
                    sub1.setText("");
                    sub2.setText("");
                    sub3.setText("");
                    sub4.setText("");
                    sub5.setText("");
                    
                    Mrk1.setText("");
                    Mrk2.setText("");
                    Mrk3.setText("");
                    Mrk4.setText("");
                    Mrk5.setText("");

                    conn.close();
                    JOptionPane.showMessageDialog(null,"Data inserted successfully");   
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnNewButton.setBounds(135, 388, 110, 33);
        frame.getContentPane().add(btnNewButton);

        JButton btnSubmit = new JButton("Clear");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                comboBox.setSelectedIndex(0);
                sub1.setText("");
                sub2.setText("");
                sub3.setText("");
                sub4.setText("");
                sub5.setText("");
                
                Mrk1.setText("");
                Mrk2.setText("");
                Mrk3.setText("");
                Mrk4.setText("");
                Mrk5.setText("");
            }
        });
        btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnSubmit.setBounds(318, 388, 102, 33);
        frame.getContentPane().add(btnSubmit);
    }

    private int isValidInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;  // Or you can return a default value
        }
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/studentmarks";
            String user = "root";
            String password = "Rach123gullu@";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
