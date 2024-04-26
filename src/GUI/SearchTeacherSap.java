package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JScrollBar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchTeacherSap {

    JFrame frame;
    private JPanel contentPane;
    private JTextField textFieldSapId;
    private JTextField textFieldSapId_1;
    private JTextField textFieldemail;
    private JTextField textFieldemail_1;
    private JTextArea textArea;
    private JTextField textFieldteacherName;
    private JTextField textFieldfathersname;
    private JTextField textFieldMothersName;
    private JTextField textFielddate_of_birth;
    private JTextField textFieldAddress;
    private JTextField textFieldage;
    private JTextField textFieldmobile;
    private JTextField textFieldPassword;
    private JTextField textFieldlanguage;
    private JTextField textFieldqualification;
    private JTextField textFieldqualbranch;
    private JLabel lblPhoto;

    Connection conn = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchTeacherSap window = new SearchTeacherSap();
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
    public SearchTeacherSap() {
        initialize();
        conn = getConnection();
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root",
                    "Rach123gullu@");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void searchteacher(String searchBy, String searchText) {
        textArea.setText(""); // Clear previous text
        lblPhoto.setIcon(null); // Clear previous photo
        PreparedStatement pstmt;
        ResultSet rs;

        try {
            if (searchBy.equals("sap_id")) {
                pstmt = conn.prepareStatement("SELECT * FROM teacher WHERE sap_id = ?");
                pstmt.setString(1, searchText);
            } else {
                pstmt = conn.prepareStatement("SELECT * FROM teacher WHERE email = ?");
                pstmt.setString(1, searchText);
            }

            rs = pstmt.executeQuery();

            if (rs.next()) {
                textArea.append("Teacher Name: " + rs.getString("teacher_name") + "\n");
                textArea.append("Father's Name: " + rs.getString("fathers_name") + "\n");
                textArea.append("Mother's Name: " + rs.getString("mothers_name") + "\n");
                textArea.append("Email: " + rs.getString("email") + "\n");
                textArea.append("Date of Birth: " + rs.getString("date_of_birth") + "\n");
                textArea.append("Address: " + rs.getString("address") + "\n");
                textArea.append("Age: " + rs.getString("age") + "\n");
                textArea.append("Mobile No: " + rs.getString("mobile") + "\n");
                textArea.append("Language: " + rs.getString("language") + "\n");
                textArea.append("Qualification: " + rs.getString("qualification") + "\n");
                textArea.append("Branch: " + rs.getString("branch") + "\n");
                textArea.append("Sap Id: " + rs.getString("sap_id") + "\n");
                textArea.append("Password: " + rs.getString("password") + "\n");

                // Fetch and display photo
                byte[] imgData = rs.getBytes("photo");
                if (imgData != null) {
                    ImageIcon image = new ImageIcon(imgData);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    lblPhoto.setIcon(newImage);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Teacher not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTeacher(String sapId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM teacher WHERE sap_id = ?");
            pstmt.setString(1, sapId);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Teacher deleted successfully!");
                textArea.setText(""); // Clear text area after deletion
                lblPhoto.setIcon(null); // Clear photo after deletion
            } else {
                JOptionPane.showMessageDialog(null, "Teacher not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacher(String sapId, String email, String mobile, String teacherName, String fathersname,
            String mothersName, String date_of_birth, String address, String password) {
        try {
            String query = "UPDATE teacher SET ";
            if (email != null && !email.isEmpty()) {
                query += "email = ?, ";
            }
            if (mobile != null && !mobile.isEmpty()) {
                query += "mobile = ?, ";
            }
            if (teacherName != null && !teacherName.isEmpty()) {
                query += "teacher_name = ?, ";
            }
            if (fathersname != null && !fathersname.isEmpty()) {
                query += "fathers_name = ?, ";
            }
            if (mothersName != null && !mothersName.isEmpty()) {
                query += "mothers_name = ?, ";
            }
            if (date_of_birth != null && !date_of_birth.isEmpty()) {
                query += "date_of_birth = ?, ";
            }
            if (address != null && !address.isEmpty()) {
                query += "address = ?, ";
            }
            if (password != null && !password.isEmpty()) {
                query += "password = ?, ";
            }
            query = query.endsWith(", ") ? query.substring(0, query.length() - 2) : query;
            query += " WHERE sap_id = ?";

            PreparedStatement pstmt = conn.prepareStatement(query);
            int index = 1;
            if (email != null && !email.isEmpty()) {
                pstmt.setString(index++, email);
            }
            if (mobile != null && !mobile.isEmpty()) {
                pstmt.setString(index++, mobile);
            }
            if (teacherName != null && !teacherName.isEmpty()) {
                pstmt.setString(index++, teacherName);
            }
            if (fathersname != null && !fathersname.isEmpty()) {
                pstmt.setString(index++, fathersname);
            }
            if (mothersName != null && !mothersName.isEmpty()) {
                pstmt.setString(index++, mothersName);
            }
            if (date_of_birth != null && !date_of_birth.isEmpty()) {
                pstmt.setString(index++, date_of_birth);
            }
            if (address != null && !address.isEmpty()) {
                pstmt.setString(index++, address);
            }
            if (password != null && !password.isEmpty()) {
                pstmt.setString(index++, password);
            }
            pstmt.setString(index++, sapId);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Teacher information updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Teacher not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchAllTeacher() {
        textArea.setText(""); // Clear previous text
        PreparedStatement pstmt;
        ResultSet rs;

        try {
            pstmt = conn.prepareStatement("SELECT * FROM teacher");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                textArea.append("Teacher Name: " + rs.getString("teacher_name") + "\n");
                textArea.append("Father's Name: " + rs.getString("fathers_name") + "\n");
                textArea.append("Mother's Name: " + rs.getString("mothers_name") + "\n");
                textArea.append("Email: " + rs.getString("email") + "\n");
                textArea.append("Date of Birth: " + rs.getString("date_of_birth") + "\n");
                textArea.append("Address: " + rs.getString("address") + "\n");
                textArea.append("Age: " + rs.getString("age") + "\n");
                textArea.append("Mobile No: " + rs.getString("mobile") + "\n");
                textArea.append("Language: " + rs.getString("language") + "\n");
                textArea.append("Qualification: " + rs.getString("qualification") + "\n");
                textArea.append("Branch: " + rs.getString("branch") + "\n");
                textArea.append("Sap Id: " + rs.getString("sap_id") + "\n");
                textArea.append("Password: " + rs.getString("password") + "\n\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTeacher(String teacherName, String fathersname, String mothersName, String email,
            String date_of_birth, String address, String age, String mobile, String language, String qualification,
            String branch, String sapId, String password) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO teacher (teacher_name, fathers_name, mothers_name, email, date_of_birth, address, age, mobile, language, qualification, branch, sap_id, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, teacherName);
            pstmt.setString(2, fathersname);
            pstmt.setString(3, mothersName);
            pstmt.setString(4, email);
            pstmt.setString(5, date_of_birth);
            pstmt.setString(6, address);
            pstmt.setString(7, age);
            pstmt.setString(8, mobile);
            pstmt.setString(9, language);
            pstmt.setString(10, qualification);
            pstmt.setString(11, branch);
            pstmt.setString(12, sapId);
            pstmt.setString(13, password);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Teacher added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add teacher!");
            }

        } catch (SQLException e) {
            if (e.getSQLState().equals("23000") && e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(null, "Duplicate entry for sap_id!");
            } else {
                e.printStackTrace();
            }
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBackground(new Color(255, 255, 255));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100, 100, 923, 600);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearchBy = new JLabel("Search By:");
        lblSearchBy.setBounds(30, 30, 100, 20);
        contentPane.add(lblSearchBy);

        textFieldSapId = new JTextField();
        textFieldSapId.setBounds(140, 30, 200, 20);
        contentPane.add(textFieldSapId);
        textFieldSapId.setColumns(10);

        textFieldemail = new JTextField();
        textFieldemail.setBounds(140, 70, 200, 20);
        contentPane.add(textFieldemail);
        textFieldemail.setColumns(10);

        JLabel lblteacherName = new JLabel("Teacher Name:");
        lblteacherName.setBounds(30, 110, 100, 20);
        contentPane.add(lblteacherName);

        textFieldteacherName = new JTextField();
        textFieldteacherName.setBounds(140, 110, 200, 20);
        contentPane.add(textFieldteacherName);
        textFieldteacherName.setColumns(10);

        JLabel lblfathersname = new JLabel("Father's Name:");
        lblfathersname.setBounds(30, 150, 100, 20);
        contentPane.add(lblfathersname);

        textFieldfathersname = new JTextField();
        textFieldfathersname.setBounds(140, 150, 200, 20);
        contentPane.add(textFieldfathersname);
        textFieldfathersname.setColumns(10);

        JLabel lblMothersName = new JLabel("Mother's Name:");
        lblMothersName.setBounds(30, 190, 100, 20);
        contentPane.add(lblMothersName);

        textFieldMothersName = new JTextField();
        textFieldMothersName.setBounds(140, 190, 200, 20);
        contentPane.add(textFieldMothersName);
        textFieldMothersName.setColumns(10);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(30, 230, 100, 20);
        contentPane.add(lblemail);

        textFieldemail_1 = new JTextField();
        textFieldemail_1.setBounds(140, 230, 200, 20);
        contentPane.add(textFieldemail_1);
        textFieldemail_1.setColumns(10);

        JLabel lbldate_of_birth = new JLabel("Date of Birth (YYYY-MM-DD):");
        lbldate_of_birth.setBounds(30, 270, 150, 20);
        contentPane.add(lbldate_of_birth);

        textFielddate_of_birth = new JTextField();
        textFielddate_of_birth.setBounds(140, 270, 200, 20);
        contentPane.add(textFielddate_of_birth);
        textFielddate_of_birth.setColumns(10);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, 310, 100, 20);
        contentPane.add(lblAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(140, 311, 200, 20);
        contentPane.add(textFieldAddress);
        textFieldAddress.setColumns(10);

        JLabel lblage = new JLabel("Age:");
        lblage.setBounds(30, 350, 100, 20);
        contentPane.add(lblage);

        textFieldage = new JTextField();
        textFieldage.setBounds(140, 351, 200, 20);
        contentPane.add(textFieldage);
        textFieldage.setColumns(10);

        JLabel lblmobile = new JLabel("Mobile No:");
        lblmobile.setBounds(30, 390, 100, 20);
        contentPane.add(lblmobile);

        textFieldmobile = new JTextField();
        textFieldmobile.setBounds(140, 391, 200, 20);
        contentPane.add(textFieldmobile);
        textFieldmobile.setColumns(10);

        JLabel lblSapId = new JLabel("Sap Id:");
        lblSapId.setBounds(30, 430, 100, 20);
        contentPane.add(lblSapId);

        textFieldSapId_1 = new JTextField();
        textFieldSapId_1.setBounds(140, 431, 200, 20);
        contentPane.add(textFieldSapId_1);
        textFieldSapId_1.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 470, 100, 20);
        contentPane.add(lblPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(140, 471, 200, 20);
        contentPane.add(textFieldPassword);
        textFieldPassword.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(360, 30, 100, 20);
        btnSearch.setBackground(new Color(0, 255, 0));
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchBy = textFieldSapId.getText().isEmpty() ? "email" : "sap_id";
                String searchText = textFieldSapId.getText().isEmpty() ? textFieldemail.getText()
                        : textFieldSapId.getText();
                searchteacher(searchBy, searchText);
            }
        });
        contentPane.add(btnSearch);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(488, 30, 100, 20);
        btnDelete.setBackground(new Color(0, 255, 0));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sapId = textFieldSapId.getText();
                deleteTeacher(sapId);
            }
        });
        contentPane.add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(360, 80, 100, 20);
        btnUpdate.setBackground(new Color(0, 255, 0));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sapId = textFieldSapId.getText();
                String email = JOptionPane.showInputDialog("Enter email");
                String mobile = JOptionPane.showInputDialog("Enter Mobile Number");
                String teacherName = JOptionPane.showInputDialog("Enter Teacher Name");
                String fathersname = JOptionPane.showInputDialog("Enter Father's Name");
                String mothersName = JOptionPane.showInputDialog("Enter Mother's Name");
                String date_of_birth = JOptionPane.showInputDialog("Enter Date of Birth (YYYY-MM-DD)");
                String address = JOptionPane.showInputDialog("Enter Address");
                String password = JOptionPane.showInputDialog("Enter Password");

                updateTeacher(sapId, email, mobile, teacherName, fathersname, mothersName, date_of_birth, address,
                        password);
            }
        });
        contentPane.add(btnUpdate);

        JButton btnFetchAll = new JButton("Fetch All");
        btnFetchAll.setBounds(488, 80, 100, 20);
        btnFetchAll.setBackground(new Color(0, 255, 0));
        btnFetchAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchAllTeacher();
            }
        });
        contentPane.add(btnFetchAll);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(370, 459, 100, 31);
        btnAdd.setBackground(new Color(0, 255, 0));
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String teacherName = textFieldteacherName.getText();
                String fathersname = textFieldfathersname.getText();
                String mothersName = textFieldMothersName.getText();
                String email = textFieldemail_1.getText();
                String date_of_birth = textFielddate_of_birth.getText();
                String address = textFieldAddress.getText();
                String age = textFieldage.getText();
                String mobile = textFieldmobile.getText();
                String language = JOptionPane.showInputDialog("Enter Language");
                String qualification = JOptionPane.showInputDialog("Enter Qualification");
                String branch = JOptionPane.showInputDialog("Enter Branch");
                String sapId = textFieldSapId_1.getText();
                String password = textFieldPassword.getText();

                addTeacher(teacherName, fathersname, mothersName, email, date_of_birth, address, age, mobile,
                        language, qualification, branch, sapId, password);
            }
        });
        contentPane.add(btnAdd);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(528, 459, 100, 34);
        btnClear.setBackground(new Color(0, 255, 0));
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldteacherName.setText("");
                textFieldfathersname.setText("");
                textFieldMothersName.setText("");
                textFieldemail_1.setText("");
                textFielddate_of_birth.setText("");
                textFieldAddress.setText("");
                textFieldage.setText("");
                textFieldmobile.setText("");
                textFieldSapId_1.setText("");
                textFieldPassword.setText("");
            }
        });
        contentPane.add(btnClear);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(360, 130, 500, 300);
        contentPane.add(scroll);

        lblPhoto = new JLabel("");
        lblPhoto.setBounds(720, 0, 150, 130);
        contentPane.add(lblPhoto);

        frame.setVisible(true);
    }
}
