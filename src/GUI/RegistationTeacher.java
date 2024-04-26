package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.io.FileNotFoundException;
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;

public class RegistationTeacher {

    JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_4;
    private JLabel lblNewLabel_Img;
    private JTextField textField_8;
    private JTextField textField_9;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistationTeacher window = new RegistationTeacher();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RegistationTeacher() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("DIT UNIVERSITY");
        frame.getContentPane().setBackground(new Color(255, 255, 255));

        try {
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(RegistationTeacher.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        } catch (NullPointerException e) {
            System.out.println("Image not found: " + e.getMessage());
        }

        frame.setBounds(100, 100, 681, 535);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblNewLabel_Img = new JLabel("Select Photo");
        lblNewLabel_Img.setBounds(498, 66, 141, 188);
        lblNewLabel_Img.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblNewLabel_Img);

        lblNewLabel_Img.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JFileChooser fileChooser = new JFileChooser();
                    int returnValue = fileChooser.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = fileChooser.getSelectedFile();
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

        JLabel lblNewLabel_1 = new JLabel("Teacher's Name :");
        lblNewLabel_1.setBounds(20, 66, 133, 13);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(163, 65, 274, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Father's  Name :");
        lblNewLabel_2.setBounds(20, 96, 133, 13);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(163, 95, 274, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Mother's Name :");
        lblNewLabel_3.setBounds(20, 125, 133, 13);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_3);

        textField_2 = new JTextField();
        textField_2.setBounds(163, 124, 274, 19);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Email Id : ");
        lblNewLabel_4.setBounds(20, 163, 133, 13);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_4);

        textField_3 = new JTextField();
        textField_3.setBounds(163, 162, 274, 19);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Date Of Birth :");
        lblNewLabel_5.setBounds(20, 241, 124, 13);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_5);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setBounds(163, 239, 62, 21);
        frame.getContentPane().add(comboBox);
        for (int i = 1980; i <= 2010; i++) {
            comboBox.addItem(String.valueOf(i));
        }

        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setBounds(256, 239, 71, 21);
        frame.getContentPane().add(comboBox_1);
        for (Month month : Month.values()) {
            comboBox_1.addItem(month.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
        }

        JComboBox<String> comboBox_2 = new JComboBox<String>();
        comboBox_2.setBounds(358, 239, 79, 21);
        frame.getContentPane().add(comboBox_2);
        for (int i = 1; i <= 31; i++) {
            comboBox_2.addItem(String.format("%02d", i));
        }

        JLabel lblNewLabel_6 = new JLabel("Age :");
        lblNewLabel_6.setBounds(20, 318, 133, 19);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Language :");
        lblNewLabel_7.setBounds(20, 353, 118, 19);
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Hindi ");
        lblNewLabel_8.setBounds(163, 356, 62, 13);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_8);

        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setBounds(212, 351, 33, 21);
        frame.getContentPane().add(chckbxNewCheckBox);

        JLabel lblNewLabel_9 = new JLabel("English");
        lblNewLabel_9.setBounds(257, 350, 70, 19);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_9);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
        chckbxNewCheckBox_1.setBounds(321, 351, 23, 21);
        frame.getContentPane().add(chckbxNewCheckBox_1);
        ButtonGroup gb = new ButtonGroup();

        JLabel lblNewLabel_10 = new JLabel("Qualification :");
        lblNewLabel_10.setBounds(20, 393, 105, 13);
        lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_10);

        textField_5 = new JTextField();
        textField_5.setBounds(163, 392, 135, 19);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);

        JLabel lblNewLabel_11 = new JLabel("Branch :");
        lblNewLabel_11.setBounds(308, 393, 62, 13);
        lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
        frame.getContentPane().add(lblNewLabel_11);

        JComboBox<String> comboBox_4 = new JComboBox<String>();
        comboBox_4.setBounds(380, 391, 71, 21);
        frame.getContentPane().add(comboBox_4);
        comboBox_4.addItem("Mca");
        comboBox_4.addItem("Mba");
        comboBox_4.addItem("B-Tech");
        comboBox_4.addItem("M-Tech");
        comboBox_4.addItem("Pharma");
        comboBox_4.addItem("M-Pharma");
        comboBox_4.addItem("Bsc");
        comboBox_4.addItem("Ba");

       
        JButton btnNewButton1 = new JButton("Submit");
        btnNewButton1.setBounds(163, 444, 121, 33);
        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Choose an image");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "Rach123gullu@");

                        String sql = "INSERT INTO teacher (teacher_name, fathers_name, mothers_name, email, date_of_birth, address, age, mobile, language, qualification, branch, sap_id, password, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                        PreparedStatement pst = con.prepareStatement(sql);

                        pst.setString(1, textField.getText());
                        pst.setString(2, textField_1.getText());
                        pst.setString(3, textField_2.getText());
                        pst.setString(4, textField_3.getText());

                        String dateOfBirth = comboBox.getSelectedItem().toString() + "-"
                                + monthNameToNumber(comboBox_1.getSelectedItem().toString()) + "-" + comboBox_2.getSelectedItem().toString();
                        pst.setString(5, dateOfBirth);

                        pst.setString(6, textField_6.getText());
                        pst.setInt(7, Integer.parseInt(textField_4.getText()));
                        pst.setString(8, textField_7.getText());

                        pst.setString(9, (chckbxNewCheckBox.isSelected() ? "Hindi" : "") + " "
                                + (chckbxNewCheckBox_1.isSelected() ? "English" : ""));
                        pst.setString(10, textField_5.getText());
                        pst.setString(11, comboBox_4.getSelectedItem().toString());

                        pst.setString(12, textField_8.getText()); // sap_id
                        pst.setString(13, textField_9.getText()); // password

                        // Read the selected image file from JFileChooser
                        File selectedFile = fileChooser.getSelectedFile();
                        
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

                        // Set the photo as Blob
                        pst.setBinaryStream(14, bais, baos.toByteArray().length);

                        int rowsAffected = pst.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Record inserted successfully");
                        } else {
                            JOptionPane.showMessageDialog(frame, "No rows affected");
                        }

                        con.close();

                    } catch (ClassNotFoundException | SQLException | NumberFormatException | IOException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(frame, "Error: " + e1.getMessage());
                    }
                }
            }
        });




        btnNewButton1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        frame.getContentPane().add(btnNewButton1);

        JButton btnNewButton_1 = new JButton("Reset ");
        btnNewButton_1.setBounds(321, 445, 116, 31);
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
                textField_8.setText("");
                textField_9.setText("");

                comboBox.setSelectedIndex(0);
                comboBox_1.setSelectedIndex(0);
                comboBox_2.setSelectedIndex(0);
                comboBox_4.setSelectedIndex(0);

                chckbxNewCheckBox.setSelected(false);
                chckbxNewCheckBox_1.setSelected(false);
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        frame.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_12 = new JLabel("Address  :");
        lblNewLabel_12.setBounds(20, 280, 105, 13);
        lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_12);

        textField_6 = new JTextField();
        textField_6.setBounds(163, 279, 274, 19);
        frame.getContentPane().add(textField_6);
        textField_6.setColumns(10);

        JLabel lblNewLabel_13 = new JLabel("Mobile No :");
        lblNewLabel_13.setBounds(235, 323, 86, 13);
        lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_13);

        textField_7 = new JTextField();
        textField_7.setBounds(324, 320, 113, 19);
        frame.getContentPane().add(textField_7);
        textField_7.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(163, 318, 57, 19);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        JLabel lblNewLabel = new JLabel("TEACHER REGISTRATION  FORM");
        lblNewLabel.setBounds(135, 22, 453, 19);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_14 = new JLabel("Sap_Id :");
        lblNewLabel_14.setBounds(26, 202, 118, 29);
        lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_14);
        
        textField_8 = new JTextField();
        textField_8.setBounds(163, 201, 96, 19);
        frame.getContentPane().add(textField_8);
        textField_8.setColumns(10);
        
        JLabel lblNewLabel_15 = new JLabel("password :");
        lblNewLabel_15.setBounds(269, 204, 75, 19);
        lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(lblNewLabel_15);
        
        textField_9 = new JTextField();
        textField_9.setBounds(358, 201, 79, 19);
        frame.getContentPane().add(textField_9);
        textField_9.setColumns(10);
        
        JLabel lblNewLabel_16 = new JLabel("");
        lblNewLabel_16.setIcon(new ImageIcon(RegistationTeacher.class.getResource("/GUI/image/yellow-color-solid-background-1920x1080.png")));
        lblNewLabel_16.setBounds(112, 10, 368, 46);
        frame.getContentPane().add(lblNewLabel_16);
        
        JLabel lblNewLabel_17 = new JLabel("New label");
        lblNewLabel_17.setIcon(new ImageIcon(RegistationTeacher.class.getResource("/GUI/image/colour-bold-teal-500x350.png")));
        lblNewLabel_17.setBounds(498, 66, 133, 154);
        frame.getContentPane().add(lblNewLabel_17);
    }

    public static String monthNameToNumber(String monthName) {
        Month month = Month.from(Month.FEBRUARY);  // Just to initialize the month object
        for (Month m : Month.values()) {
            if (m.getDisplayName(TextStyle.FULL, Locale.ENGLISH).equalsIgnoreCase(monthName)) {
                month = m;
                break;
            }
        }
        return String.valueOf(month.getValue());
    }
}
