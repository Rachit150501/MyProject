package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JOptionPane;

public class marksFetch {

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
                    marksFetch window = new marksFetch();
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
    public marksFetch() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Marks Fetch");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 572, 495);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Fetch Student Marks :");
        lblNewLabel.setBounds(10, 20, 250, 25);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(lblNewLabel);

        JLabel sapId = new JLabel("rollno");
        sapId.setBounds(27, 70, 74, 25);
        sapId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(sapId);

        textField = new JTextField();
        textField.setBounds(100, 75, 150, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel(" Semester");
        lblNewLabel_2.setBounds(280, 70, 80, 25);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_2);

        String[] semester = {"First Sem", "Second Sem", "Third Sem", "Fourth Sem", "Fifth Sem", "Sixth Sem", "Seventh Sem", "Eighth Sem"};
        comboBox = new JComboBox<>(semester);
        comboBox.setBounds(360, 75, 120, 21);
        frame.getContentPane().add(comboBox);

        JLabel lblNewLabel_3 = new JLabel("Subject");
        lblNewLabel_3.setBounds(132, 131, 80, 25);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Marks");
        lblNewLabel_4.setBounds(316, 131, 80, 25);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_4);

        sub1 = new JTextField();
        sub1.setBounds(100, 179, 97, 19);
        sub1.setEditable(false);
        frame.getContentPane().add(sub1);
        sub1.setColumns(10);

        sub2 = new JTextField();
        sub2.setBounds(100, 208, 97, 19);
        sub2.setEditable(false);
        sub2.setColumns(10);
        frame.getContentPane().add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(100, 242, 96, 19);
        sub3.setEditable(false);
        sub3.setColumns(10);
        frame.getContentPane().add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(100, 271, 96, 19);
        sub4.setEditable(false);
        sub4.setColumns(10);
        frame.getContentPane().add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(100, 310, 96, 19);
        sub5.setEditable(false);
        sub5.setColumns(10);
        frame.getContentPane().add(sub5);

        Mrk1 = new JTextField();
        Mrk1.setBounds(296, 179, 97, 19);
        Mrk1.setEditable(false);
        frame.getContentPane().add(Mrk1);
        Mrk1.setColumns(10);

        Mrk2 = new JTextField();
        Mrk2.setBounds(296, 208, 97, 19);
        Mrk2.setEditable(false);
        Mrk2.setColumns(10);
        frame.getContentPane().add(Mrk2);

        Mrk3 = new JTextField();
        Mrk3.setBounds(296, 242, 97, 19);
        Mrk3.setEditable(false);
        Mrk3.setColumns(10);
        frame.getContentPane().add(Mrk3);

        Mrk4 = new JTextField();
        Mrk4.setBounds(296, 271, 96, 19);
        Mrk4.setEditable(false);
        Mrk4.setColumns(10);
        frame.getContentPane().add(Mrk4);

        Mrk5 = new JTextField();
        Mrk5.setBounds(296, 310, 96, 19);
        Mrk5.setEditable(false);
        Mrk5.setColumns(10);
        frame.getContentPane().add(Mrk5);

        JButton btnFetch = new JButton("Fetch");
        btnFetch.setBounds(132, 369, 120, 25);
        btnFetch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchMarksAndSubjects();
            }
        });
        btnFetch.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnFetch);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(296, 369, 100, 25);
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        btnClear.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(btnClear);
    }

    private void fetchMarksAndSubjects() {
        try (Connection conn = getConnection()) {
            String sapIdVal = textField.getText();
            String semesterVal = (String) comboBox.getSelectedItem();

            // Fetch marks data
            String marksQuery = "SELECT * FROM marks WHERE rollno = ? AND semester = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(marksQuery)) {
                pstmt.setString(1, sapIdVal);
                pstmt.setString(2, semesterVal);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        Mrk1.setText(Integer.toString(rs.getInt("Mrk1")));
                        Mrk2.setText(Integer.toString(rs.getInt("Mrk2")));
                        Mrk3.setText(Integer.toString(rs.getInt("Mrk3")));
                        Mrk4.setText(Integer.toString(rs.getInt("Mrk4")));
                        Mrk5.setText(Integer.toString(rs.getInt("Mrk5")));
                    } else {
                        Mrk1.setText("");
                        Mrk2.setText("");
                        Mrk3.setText("");
                        Mrk4.setText("");
                        Mrk5.setText("");
                    }
                }
            }

            // Fetch subject data
            String subQuery = "SELECT sub1, sub2, sub3, sub4, sub5 FROM subject1 WHERE rollno = ? AND semester = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(subQuery)) {
                pstmt.setString(1, sapIdVal);
                pstmt.setString(2, semesterVal);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        sub1.setText(rs.getString("sub1"));
                        sub2.setText(rs.getString("sub2"));
                        sub3.setText(rs.getString("sub3"));
                        sub4.setText(rs.getString("sub4"));
                        sub5.setText(rs.getString("sub5"));
                    } else {
                        sub1.setText("");
                        sub2.setText("");
                        sub3.setText("");
                        sub4.setText("");
                        sub5.setText("");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error fetching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
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

    private Connection getConnection() {
        Connection conn = null;
        try {
            String url = "jdbc:mysql://localhost:3306/studentmarks";
            String user = "root";
            String password = "Rach123gullu@";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Database connection error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
