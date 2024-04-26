package GUI;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LOGIN {

    JFrame frame;                 //Instance Variables
    private JTextField textField;
    private JPasswordField textField_1;
    private JButton submitButton;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LOGIN window = new LOGIN();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LOGIN() {
        initialize();  //method
    }

    private void initialize() {
        frame = new JFrame("DIT UNIVERSITY");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(LOGIN.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        frame.setForeground(new Color(0, 255, 128));
        frame.getContentPane().addComponentListener(new ComponentAdapter() {
            public void componentShown(ComponentEvent e) {
            }
        });

        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setBounds(100, 100, 778, 541);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Username / Email");
        lblNewLabel.setBounds(436, 156, 194, 17);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField(10);
        textField.setBounds(433, 177, 273, 41);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password ");
        lblNewLabel_1.setBounds(431, 228, 122, 17);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JPasswordField();
        textField_1.setBounds(436, 255, 273, 41);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        submitButton = new JButton("Login");
        submitButton.setBounds(494, 345, 160, 33);
        submitButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Properties properties = new Properties();
                String username = "";
                String password = "";
                String username2 = "";
                String password2 = "";
                try (FileInputStream input = new FileInputStream("C:\\Users\\rachi\\eclipse-workspace\\MyProject\\src\\GUI\\config.properties")) {
                    properties.load(input);
                    username = properties.getProperty("user");
                    password = properties.getProperty("password");
                    username2 = properties.getProperty("user2");
                    password2 = properties.getProperty("password2");
                } catch (IOException e1) {
                }
                String textuser = textField.getText();
                char[] passwordChars = textField_1.getPassword();
                String textpassword = new String(passwordChars);
                if ((username.equals(textuser) && password.equals(textpassword)) || (username2.equals(textuser) && password2.equals(textpassword))) {
                    ScreenBackground c = new ScreenBackground();
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Credential", "Wrong Password", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set the default button for the JFrame
        frame.getRootPane().setDefaultButton(submitButton);

        // Add key listener to the button
        submitButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitButton.doClick();  // Trigger the button click
                }
            }
        });

        frame.getContentPane().add(submitButton);

        JLabel lblNewLabel_4 = new JLabel("Login as University");
        lblNewLabel_4.setBounds(433, 94, 221, 41);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(436, 328, 273, 67);
        lblNewLabel_5.setIcon(new ImageIcon(LOGIN.class.getResource("/GUI/image/dark-blue-color-solid-background-1920x1080.png")));
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(422, 83, 310, 386);
        lblNewLabel_3.setIcon(new ImageIcon(LOGIN.class.getResource("/GUI/image/light-brown-color-solid-background-1920x1080.png")));
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_6 = new JLabel("DIT UNIVERSITY   ");
        lblNewLabel_6.setBounds(432, 41, 562, 33);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 35));
        frame.getContentPane().add(lblNewLabel_6);
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(LOGIN.class.getResource("/GUI/image/breauty girl.png")));
        lblNewLabel_2.setBounds(-6, -195, 432, 934);
        frame.getContentPane().add(lblNewLabel_2);
}
}