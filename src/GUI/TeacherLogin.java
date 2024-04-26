package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherLogin {

    JFrame frame;
    private JTextField textField;
    private JPasswordField textField_1;
    private JButton submitButton;
    private JButton signUpButton;
    private Connection conn;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TeacherLogin window = new TeacherLogin();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TeacherLogin() {
        initialize();
        connectToDB();
    }

    private void connectToDB() {
        try {
            String url = "jdbc:mysql://localhost:3306/university";
            String username = "root";
            String password = "Rach123gullu@";

            conn = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initialize() {
        frame = new JFrame("DIT UNIVERSITY");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TeacherLogin.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        frame.setForeground(new Color(0, 255, 128));
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 680, 541);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(false);

        JLabel lblNewLabel = new JLabel("Sap_id/ Email");
        lblNewLabel.setBounds(53, 132, 194, 33);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField(10);
        textField.setBounds(53, 175, 273, 41);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password ");
        lblNewLabel_1.setBounds(53, 226, 122, 17);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JPasswordField();
        textField_1.setBounds(53, 263, 273, 41);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        submitButton = new JButton("Login");
        submitButton.setBounds(99, 350, 160, 33);
        submitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        frame.getContentPane().add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sapIdOrEmail = textField.getText();
                String password = new String(textField_1.getPassword());

                try {
                    String query = "SELECT * FROM teacher WHERE (sap_id = ? OR email = ?) AND password = ?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, sapIdOrEmail);
                    pst.setString(2, sapIdOrEmail);
                    pst.setString(3, password);

                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                    	System.out.println("Login Successful");
                        openScreen2(sapIdOrEmail);
                    } else {
                        // Invalid login
                        JOptionPane.showMessageDialog(null, "Invalid login");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        // Sign Up button
        signUpButton = new JButton("Sign up");
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openRegistrationTeacher();
            }
        });
        signUpButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        signUpButton.setBounds(223, 432, 103, 21);
        frame.getContentPane().add(signUpButton);

        frame.getRootPane().setDefaultButton(submitButton);

        JLabel lblNewLabel_4 = new JLabel("Login as Teacher");
        lblNewLabel_4.setBounds(38, 81, 221, 41);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(56, 334, 273, 63);
        lblNewLabel_5.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GUI/image/dark-blue-color-solid-background-1920x1080.png")));
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("DIT UNIVERSITY   ");
        lblNewLabel_6.setBounds(31, 38, 562, 33);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 35));
        frame.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GUI/image/istockphoto-1139495117-612x612.jpg")));
        lblNewLabel_2.setBounds(346, 38, 335, 536);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(TeacherLogin.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        lblNewLabel_3.setBounds(451, 0, 215, 100);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_8 = new JLabel("You don't Have an Account    ?");
        lblNewLabel_8.setBounds(53, 438, 160, 13);
        frame.getContentPane().add(lblNewLabel_8);
    }

    private void openRegistrationTeacher() {
        RegistationTeacher ca = new RegistationTeacher();
        ca.frame.setVisible(true);
    }

    private void openScreen2(String sapIdOrEmail) {
        Screen2 registrationStudent1 = new Screen2(sapIdOrEmail);
        registrationStudent1.frame.setVisible(true);
        frame.setVisible(false);
    }
}
