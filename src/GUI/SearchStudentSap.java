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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JScrollBar;

public class SearchStudentSap {

    JFrame frame;
    private JPanel contentPane;
    private JTextField textFieldSapId;
    private JTextField textFieldSapId_1;
    private JTextField textFieldemail;
    private JTextField textFieldemail_1;
    private JTextArea textArea;
    private JTextField textFieldStudentName;
    private JTextField textFieldFathersName;
    private JTextField textFieldMothersName;
    private JTextField textFieldGender;
    private JTextField textFieldDob;
    private JTextField textFieldAddress;
    private JTextField textFieldBloodGroup;
    private JTextField textFieldDepartment;
    private JTextField textFieldMobileNo;
    private JTextField textFieldPassword;
    private JLabel lblPhoto;

    Connection conn = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SearchStudentSap window = new SearchStudentSap();
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
    public SearchStudentSap() {
        initialize();
        conn = getConnection();
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentregistation", "root",
                    "Rach123gullu@");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void searchStudent(String searchBy, String searchText) {
        textArea.setText(""); // Clear previous text
        lblPhoto.setIcon(null); // Clear previous photo
        PreparedStatement pstmt;
        ResultSet rs;

        try {
            if (searchBy.equals("sap_id")) {
                pstmt = conn.prepareStatement("SELECT * FROM students WHERE sap_id = ?");
                pstmt.setString(1, searchText);
            } else {
                pstmt = conn.prepareStatement("SELECT * FROM students WHERE email = ?");
                pstmt.setString(1, searchText);
            }

            rs = pstmt.executeQuery();

            if (rs.next()) {
                textArea.append("Student Name: " + rs.getString("student_name") + "\n");
                textArea.append("Father's Name: " + rs.getString("father_name") + "\n");
                textArea.append("Mother's Name: " + rs.getString("mother_name") + "\n");
                textArea.append("email: " + rs.getString("email") + "\n");
                textArea.append("Gender: " + rs.getString("gender") + "\n");
                textArea.append("DOB: " + rs.getString("dob") + "\n");
                textArea.append("Address: " + rs.getString("address") + "\n");
                textArea.append("Blood Group: " + rs.getString("blood_group") + "\n");
                textArea.append("Department: " + rs.getString("department") + "\n");
                textArea.append("Mobile No: " + rs.getString("mobile_no") + "\n");
                textArea.append("sap_id: " + rs.getString("sap_id") + "\n");
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
                JOptionPane.showMessageDialog(null, "Student not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String sapId) {
        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE sap_id = ?");
            pstmt.setString(1, sapId);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Student deleted successfully!");
                textArea.setText(""); // Clear text area after deletion
                lblPhoto.setIcon(null); // Clear photo after deletion
            } else {
                JOptionPane.showMessageDialog(null, "Student not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(String sapId, String email, String mobileNo, String studentName, String fathersName,
            String mothersName, String gender, String dob, String address, String bloodGroup, String department,
            String password) {
        try {
            String query = "UPDATE students SET ";
            if (email != null && !email.isEmpty()) {
                query += "email = ?, ";
            }
            if (mobileNo != null && !mobileNo.isEmpty()) {
                query += "mobile_no = ?, ";
            }
            if (studentName != null && !studentName.isEmpty()) {
                query += "student_name = ?, ";
            }
            if (fathersName != null && !fathersName.isEmpty()) {
                query += "father_name = ?, ";
            }
            if (mothersName != null && !mothersName.isEmpty()) {
                query += "mother_name = ?, ";
            }
            if (gender != null && !gender.isEmpty()) {
                query += "gender = ?, ";
            }
            if (dob != null && !dob.isEmpty()) {
                query += "dob = ?, ";
            }
            if (address != null && !address.isEmpty()) {
                query += "address = ?, ";
            }
            if (bloodGroup != null && !bloodGroup.isEmpty()) {
                query += "blood_group = ?, ";
            }
            if (department != null && !department.isEmpty()) {
                query += "department = ?, ";
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
            if (mobileNo != null && !mobileNo.isEmpty()) {
                pstmt.setString(index++, mobileNo);
            }
            if (studentName != null && !studentName.isEmpty()) {
                pstmt.setString(index++, studentName);
            }
            if (fathersName != null && !fathersName.isEmpty()) {
                pstmt.setString(index++, fathersName);
            }
            if (mothersName != null && !mothersName.isEmpty()) {
                pstmt.setString(index++, mothersName);
            }
            if (gender != null && !gender.isEmpty()) {
                pstmt.setString(index++, gender);
            }
            if (dob != null && !dob.isEmpty()) {
                pstmt.setString(index++, dob);
            }
            if (address != null && !address.isEmpty()) {
                pstmt.setString(index++, address);
            }
            if (bloodGroup != null && !bloodGroup.isEmpty()) {
                pstmt.setString(index++, bloodGroup);
            }
            if (department != null && !department.isEmpty()) {
                pstmt.setString(index++, department);
            }
            if (password != null && !password.isEmpty()) {
                pstmt.setString(index++, password);
            }
            pstmt.setString(index++, sapId);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Student information updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Student not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fetchAllStudents() {
        textArea.setText(""); // Clear previous text
        PreparedStatement pstmt;
        ResultSet rs;

        try {
            pstmt = conn.prepareStatement("SELECT * FROM students");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                textArea.append("Student Name: " + rs.getString("student_name") + "\n");
                textArea.append("Father's Name: " + rs.getString("father_name") + "\n");
                textArea.append("Mother's Name: " + rs.getString("mother_name") + "\n");
                textArea.append("email: " + rs.getString("email") + "\n");
                textArea.append("Gender: " + rs.getString("gender") + "\n");
                textArea.append("DOB: " + rs.getString("dob") + "\n");
                textArea.append("Address: " + rs.getString("address") + "\n");
                textArea.append("Blood Group: " + rs.getString("blood_group") + "\n");
                textArea.append("Department: " + rs.getString("department") + "\n");
                textArea.append("Mobile No: " + rs.getString("mobile_no") + "\n");
                textArea.append("sap_id: " + rs.getString("sap_id") + "\n");
                textArea.append("Password: " + rs.getString("password") + "\n\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String studentName, String fathersName, String mothersName, String email, String gender,
            String dob, String address, String bloodGroup, String department, String mobileNo, String sapId,
            String password) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO students (student_name, father_name, mother_name, email, gender, dob, address, blood_group, department, mobile_no, sap_id, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, studentName);
            pstmt.setString(2, fathersName);
            pstmt.setString(3, mothersName);
            pstmt.setString(4, email);
            pstmt.setString(5, gender);
            pstmt.setString(6, dob);
            pstmt.setString(7, address);
            pstmt.setString(8, bloodGroup);
            pstmt.setString(9, department);
            pstmt.setString(10, mobileNo);
            pstmt.setString(11, sapId);
            pstmt.setString(12, password);

            int result = pstmt.executeUpdate();

            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Student added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add student!");
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

        JLabel lblStudentName = new JLabel("Student Name:");
        lblStudentName.setBounds(30, 110, 100, 20);
        contentPane.add(lblStudentName);

        textFieldStudentName = new JTextField();
        textFieldStudentName.setBounds(140, 110, 200, 20);
        contentPane.add(textFieldStudentName);
        textFieldStudentName.setColumns(10);

        JLabel lblFathersName = new JLabel("Father's Name:");
        lblFathersName.setBounds(30, 150, 100, 20);
        contentPane.add(lblFathersName);

        textFieldFathersName = new JTextField();
        textFieldFathersName.setBounds(140, 150, 200, 20);
        contentPane.add(textFieldFathersName);
        textFieldFathersName.setColumns(10);

        JLabel lblMothersName = new JLabel("Mother's Name:");
        lblMothersName.setBounds(30, 190, 100, 20);
        contentPane.add(lblMothersName);

        textFieldMothersName = new JTextField();
        textFieldMothersName.setBounds(140, 190, 200, 20);
        contentPane.add(textFieldMothersName);
        textFieldMothersName.setColumns(10);

        JLabel lblemail = new JLabel("email:");
        lblemail.setBounds(30, 230, 100, 20);
        contentPane.add(lblemail);

        textFieldemail_1 = new JTextField();
        textFieldemail_1.setBounds(140, 230, 200, 20);
        contentPane.add(textFieldemail_1);
        textFieldemail_1.setColumns(10);

        JLabel lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, 270, 100, 20);
        contentPane.add(lblGender);

        textFieldGender = new JTextField();
        textFieldGender.setBounds(140, 270, 200, 20);
        contentPane.add(textFieldGender);
        textFieldGender.setColumns(10);

        JLabel lblDob = new JLabel("DOB (YYYY-MM-DD):");
        lblDob.setBounds(30, 310, 150, 20);
        contentPane.add(lblDob);

        textFieldDob = new JTextField();
        textFieldDob.setBounds(140, 310, 200, 20);
        contentPane.add(textFieldDob);
        textFieldDob.setColumns(10);

        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setBounds(30, 350, 100, 20);
        contentPane.add(lblAddress);

        textFieldAddress = new JTextField();
        textFieldAddress.setBounds(140, 351, 200, 20);
        contentPane.add(textFieldAddress);
        textFieldAddress.setColumns(10);

        JLabel lblBloodGroup = new JLabel("Blood Group:");
        lblBloodGroup.setBounds(30, 390, 100, 20);
        contentPane.add(lblBloodGroup);

        textFieldBloodGroup = new JTextField();
        textFieldBloodGroup.setBounds(140, 391, 200, 20);
        contentPane.add(textFieldBloodGroup);
        textFieldBloodGroup.setColumns(10);

        JLabel lblDepartment = new JLabel("Department:");
        lblDepartment.setBounds(30, 420, 100, 20);
        contentPane.add(lblDepartment);

        textFieldDepartment = new JTextField();
        textFieldDepartment.setBounds(140, 421, 200, 20);
        contentPane.add(textFieldDepartment);
        textFieldDepartment.setColumns(10);

        JLabel lblMobileNo = new JLabel("Mobile No:");
        lblMobileNo.setBounds(30, 450, 100, 20);
        contentPane.add(lblMobileNo);

        textFieldMobileNo = new JTextField();
        textFieldMobileNo.setBounds(140, 451, 200, 20);
        contentPane.add(textFieldMobileNo);
        textFieldMobileNo.setColumns(10);

        JLabel lblSapId = new JLabel("sap_id:");
        lblSapId.setBounds(40, 480, 100, 20);
        contentPane.add(lblSapId);

        textFieldSapId_1 = new JTextField();
        textFieldSapId_1.setBounds(140, 481, 200, 20);
        contentPane.add(textFieldSapId_1);
        textFieldSapId_1.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 510, 100, 20);
        contentPane.add(lblPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(140, 511, 200, 20);
        contentPane.add(textFieldPassword);
        textFieldPassword.setColumns(10);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(360, 54, 100, 20);
        btnSearch.setBackground(new Color(0, 255, 0));
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchBy = textFieldSapId.getText().isEmpty() ? "email" : "sap_id";
                String searchText = textFieldSapId.getText().isEmpty() ? textFieldemail.getText()
                        : textFieldSapId.getText();
                searchStudent(searchBy, searchText);
            }
        });
        contentPane.add(btnSearch);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(497, 54, 100, 20);
        btnDelete.setBackground(new Color(0, 255, 0));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sapId = textFieldSapId.getText();
                deleteStudent(sapId);
            }
        });
        contentPane.add(btnDelete);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(360, 96, 100, 20);
        btnUpdate.setBackground(new Color(0, 255, 0));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sapId = textFieldSapId.getText();
                String email = JOptionPane.showInputDialog("Enter email");
                String mobileNo = JOptionPane.showInputDialog("Enter Mobile Number");
                String studentName = JOptionPane.showInputDialog("Enter Student Name");
                String fathersName = JOptionPane.showInputDialog("Enter Father's Name");
                String mothersName = JOptionPane.showInputDialog("Enter Mother's Name");
                String gender = JOptionPane.showInputDialog("Enter Gender");
                String dob = JOptionPane.showInputDialog("Enter DOB (YYYY-MM-DD)");
                String address = JOptionPane.showInputDialog("Enter Address");
                String bloodGroup = JOptionPane.showInputDialog("Enter Blood Group");
                String department = JOptionPane.showInputDialog("Enter Department");
                String password = JOptionPane.showInputDialog("Enter Password");
                updateStudent(sapId, email, mobileNo, studentName, fathersName, mothersName, gender, dob, address,
                        bloodGroup, department, password);
            }
        });
        contentPane.add(btnUpdate);

        JButton btnFetchAllStudents = new JButton("Fetch All Students");
        btnFetchAllStudents.setBounds(472, 96, 150, 20);
        btnFetchAllStudents.setBackground(new Color(0, 255, 0));
        btnFetchAllStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchAllStudents();
            }
        });
        contentPane.add(btnFetchAllStudents);

        JButton btnAddStudent = new JButton("Add Student");
        btnAddStudent.setBounds(366, 136, 150, 20);
        btnAddStudent.setBackground(new Color(0, 255, 0));
        btnAddStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = textFieldStudentName.getText();
                String fathersName = textFieldFathersName.getText();
                String mothersName = textFieldMothersName.getText();
                String email = textFieldemail_1.getText();
                String gender = textFieldGender.getText();
                String dob = textFieldDob.getText();
                String address = textFieldAddress.getText();
                String bloodGroup = textFieldBloodGroup.getText();
                String department = textFieldDepartment.getText();
                String mobileNo = textFieldMobileNo.getText();
                String sapId = textFieldSapId_1.getText();
                String password = textFieldPassword.getText();
                addStudent(studentName, fathersName, mothersName, email, gender, dob, address, bloodGroup, department,
                        mobileNo, sapId, password);
            }
        });
        contentPane.add(btnAddStudent);

        JButton btnClear = new JButton("Clear");
        btnClear.setBounds(563, 136, 100, 20);
        btnClear.setBackground(new Color(255, 0, 0));
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed1(ActionEvent e) {
                clearFields();
            }

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        contentPane.add(btnClear);

        lblPhoto = new JLabel("");
        lblPhoto.setBounds(735, 0, 150, 184);
        contentPane.add(lblPhoto);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("Tahoma", Font.PLAIN, 13));

        // Adding JScrollPane to the JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(350, 190, 549, 337);
        contentPane.add(scrollPane);

        // Adding JScrollBar to the JScrollPane
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(856, 190, 17, 337);
        scrollPane.setVerticalScrollBar(scrollBar);

        frame.setVisible(true);
    }

    public void clearFields() {
        textFieldSapId.setText("");
        textFieldSapId_1.setText("");
        textFieldemail.setText("");
        textFieldemail_1.setText("");
        textFieldStudentName.setText("");
        textFieldFathersName.setText("");
        textFieldMothersName.setText("");
        textFieldGender.setText("");
        textFieldDob.setText("");
        textFieldAddress.setText("");
        textFieldBloodGroup.setText("");
        textFieldDepartment.setText("");
        textFieldMobileNo.setText("");
        textFieldPassword.setText("");
        textArea.setText("");
        lblPhoto.setIcon(null);
    }
}
