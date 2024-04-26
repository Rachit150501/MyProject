package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;



public class RegistrationStudent {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JRadioButton radioButtonMale;
    private JRadioButton radioButtonFemale;
    private JRadioButton radioButtonOther;
    private JTextField textField_6;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_7;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox_1;
    private JTextField textField_9;
    private JPasswordField passwordField;
    private File selectedFile;
    private JTextField textField_101;
    private JTextField textField_8;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistrationStudent window = new RegistrationStudent();
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
    public RegistrationStudent() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("DIT UNIVERSITY");
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationStudent.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        frame.setBounds(100, 100, 681, 558);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel_Img = new JLabel("Select Photo");
        lblNewLabel_Img.setBounds(498, 66, 141, 188);
        frame.getContentPane().add(lblNewLabel_Img, BorderLayout.CENTER);

        lblNewLabel_Img.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        selectedFile = fileChooser.getSelectedFile();
                        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
                        Image image = imageIcon.getImage();
                        Image newImage = image.getScaledInstance(lblNewLabel_Img.getWidth(), lblNewLabel_Img.getHeight(), Image.SCALE_SMOOTH);
                        ImageIcon newImageIcon = new ImageIcon(newImage);
                        lblNewLabel_Img.setIcon(newImageIcon);
                        lblNewLabel_Img.setText(""); // Remove the "Select Photo" text
                    }
                }
            }
        });

        JLabel lblNewLabel = new JLabel("Student Registration Form 2024");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(148, 10, 356, 36);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Student Name : ");
        lblNewLabel_1.setBounds(10, 70, 112, 13);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(138, 69, 272, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Father's Name : ");
        lblNewLabel_2.setBounds(10, 112, 112, 13);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(138, 111, 272, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Mother's Name :");
        lblNewLabel_3.setBounds(10, 155, 112, 13);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setBounds(138, 154, 272, 19);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Email Id :");
        lblNewLabel_4.setBounds(10, 187, 106, 13);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_4);

        textField_3 = new JTextField();
        textField_3.setBounds(138, 183, 272, 19);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Gender :");
        lblNewLabel_5.setBounds(10, 221, 88, 13);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_5);

        JLabel labelMale = new JLabel("Male");
        labelMale.setBounds(163, 221, 77, 13);
        labelMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(labelMale);

        radioButtonMale = new JRadioButton("");
        radioButtonMale.setBounds(138, 219, 27, 21);
        radioButtonMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(radioButtonMale);

        JLabel labelFemale = new JLabel("Female");
        labelFemale.setBounds(231, 221, 54, 13);
        labelFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(labelFemale);

        radioButtonFemale = new JRadioButton("");
        radioButtonFemale.setBounds(204, 219, 28, 21);
        radioButtonFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(radioButtonFemale);

        JLabel labelOther = new JLabel("Other");
        labelOther.setBounds(318, 215, 45, 25);
        labelOther.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(labelOther);

        radioButtonOther = new JRadioButton("");
        radioButtonOther.setBounds(291, 219, 21, 21);
        frame.getContentPane().add(radioButtonOther);

        ButtonGroup gb = new ButtonGroup();
        gb.add(radioButtonOther);
        gb.add(radioButtonFemale);
        gb.add(radioButtonMale);

        JLabel lblNewLabel_9 = new JLabel("dob :");
        lblNewLabel_9.setBounds(10, 251, 112, 13);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_9);

        textField_4 = new JTextField();
        textField_4.setBounds(138, 250, 65, 19);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(231, 250, 65, 19);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(333, 250, 77, 19);
        frame.getContentPane().add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_10 = new JLabel("Address :");
        lblNewLabel_10.setBounds(10, 326, 106, 13);
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_10);

        textField_7 = new JTextField();
        textField_7.setBounds(138, 325, 272, 19);
        frame.getContentPane().add(textField_7);
        textField_7.setColumns(10);

        JLabel lblNewLabel_11 = new JLabel("Blood Group :");
        lblNewLabel_11.setBounds(10, 361, 112, 13);
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_11);

        comboBox = new JComboBox();
        comboBox.setBounds(138, 357, 71, 21);
        comboBox.setToolTipText("");
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(comboBox);
        comboBox.addItem("(A+)");
        comboBox.addItem("(A-)");
        comboBox.addItem("(B+)");
        comboBox.addItem("(B-)");
        comboBox.addItem("(AB+)");
        comboBox.addItem("(AB-)");
        comboBox.addItem("(O+)");
        comboBox.addItem("(O-)");

        JLabel lblNewLabel_12 = new JLabel("Department :");
        lblNewLabel_12.setBounds(10, 390, 106, 13);
        lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_12);

        comboBox_1 = new JComboBox();
        comboBox_1.setBounds(138, 388, 77, 21);
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(comboBox_1);
        comboBox_1.addItem("Mca");
        comboBox_1.addItem("Mba");
        comboBox_1.addItem("B-Tech");
        comboBox_1.addItem("M-Tech");
        comboBox_1.addItem("Pharma");
        comboBox_1.addItem("M-Pharma");
     // ... (Previous code remains unchanged)

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBounds(152, 446, 117, 42);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistation", "root", "Rach123gullu@");

                    String sql = "INSERT INTO students (student_name, father_name, mother_name, email, gender, dob, address, blood_group, department, mobile_no, photo, sap_id, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    PreparedStatement pst = con.prepareStatement(sql);

                    pst.setString(1, textField.getText());
                    pst.setString(2, textField_1.getText());
                    pst.setString(3, textField_2.getText());
                    pst.setString(4, textField_3.getText());

                    String gender = "";
                    if (radioButtonMale.isSelected()) {
                        gender = "Male";
                    } else if (radioButtonFemale.isSelected()) {
                        gender = "Female";
                    } else if (radioButtonOther.isSelected()) {
                        gender = "Other";
                    }
                    pst.setString(5, gender);

                    String dob = textField_6.getText() + "-" + String.format("%02d", Integer.parseInt(textField_5.getText())) + "-" + String.format("%02d", Integer.parseInt(textField_4.getText()));
                    pst.setString(6, dob);

                    pst.setString(7, textField_7.getText());
                    pst.setString(8, comboBox.getSelectedItem().toString());
                    pst.setString(9, comboBox_1.getSelectedItem().toString());
                    pst.setString(10, textField_9.getText());

                    // Resize the image
                    BufferedImage originalImage = ImageIO.read(selectedFile);
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage resizedImage = new BufferedImage(100, 100, type);
                    Graphics2D g = resizedImage.createGraphics();
                    g.drawImage(originalImage, 0, 0, 100, 100, null);
                    g.dispose();

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(resizedImage, "jpg", baos);
                    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

                    pst.setBinaryStream(11, bais, baos.toByteArray().length);

                    pst.setString(12, textField_8.getText());
                    pst.setString(13, passwordField.getText());

                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(frame, "Record inserted successfully");
                    } else {
                    	 JOptionPane.showMessageDialog(frame, "No rows affected");
                    }

                    con.close();

                } catch (ClassNotFoundException | SQLException | IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

  

       btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Reset");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_1.setText("");
                textField_2.setText("");
                textField_3.setText("");
                textField_4.setText("");
                textField_5.setText("");
                textField_6.setText("");
                textField_7.setText("");
                textField_9.setText("");

                radioButtonMale.setSelected(false);
                radioButtonFemale.setSelected(false);
                radioButtonOther.setSelected(false);

                comboBox.setSelectedIndex(0);
                comboBox_1.setSelectedIndex(0);
            }
        });
        btnNewButton_1.setBounds(287, 446, 112, 42);
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        frame.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_6 = new JLabel("Mobile  No :");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel_6.setBounds(224, 361, 88, 13);
        frame.getContentPane().add(lblNewLabel_6);

        textField_9 = new JTextField();
        textField_9.setBounds(317, 360, 93, 19);
        frame.getContentPane().add(textField_9);
        textField_9.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("Sap_Id :");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_7.setBounds(10, 290, 65, 21);
        frame.getContentPane().add(lblNewLabel_7);

        textField_8 = new JTextField();
        textField_8.setBounds(138, 292, 76, 19);
        frame.getContentPane().add(textField_8);
        textField_8.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Password :");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_8.setBounds(231, 292, 81, 13);
        frame.getContentPane().add(lblNewLabel_8);

        passwordField = new JPasswordField();
        passwordField.setBounds(324, 289, 86, 19);
        frame.getContentPane().add(passwordField);

        JLabel lblNewLabel_13 = new JLabel("");
        lblNewLabel_13.setIcon(new ImageIcon(RegistrationStudent.class.getResource("/GUI/image/yellow-color-solid-background-1920x1080.png")));
        lblNewLabel_13.setBounds(163, 10, 330, 36);
        frame.getContentPane().add(lblNewLabel_13);

        JLabel lblNewLabel_14 = new JLabel("");
        lblNewLabel_14.setIcon(new ImageIcon(RegistrationStudent.class.getResource("/GUI/image/colour-bold-teal-500x350.png")));
        lblNewLabel_14.setBounds(498, 66, 141, 188);
        frame.getContentPane().add(lblNewLabel_14);

        frame.setVisible(true);
    }

    public static String monthNameToNumber(String monthName) {
        Month month = Month.from(Month.FEBRUARY);
        for (Month m : Month.values()) {
            if (m.getDisplayName(TextStyle.FULL, Locale.ENGLISH).equalsIgnoreCase(monthName)) {
                month = m;
                break;
            }
        }
        return String.valueOf(month.getValue());
    }
}
