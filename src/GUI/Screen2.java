package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Screen2 {

    JFrame frame;
    private JLabel lblNewLabel_2;
	protected Window registrationStudent1;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                	Screen2 window = new Screen2();
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public Screen2(String sapIdOrEmail) {
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
		lblNewLabel.setBounds(0, 117, 999, 425);
	    lblNewLabel.setIcon(new ImageIcon(StudentLogins.class.getResource("/GUI/image/WhatsApp Image 2024-04-09 at 20.22.31_d6d7fefe.jpg")));
	    frame.getContentPane().add(lblNewLabel);
	    
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 192, 119);
		lblNewLabel_1.setForeground(new Color(64, 0, 0));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_1.setIcon(new ImageIcon(ScreenBackground.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
		lblNewLabel_1.setToolTipText("");
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Phone No : 1800 1210 41000");
		lblNewLabel_2.setBounds(728, 10, 170, 33);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_1.setVisible(true);
		
		JButton btnNewButton = new JButton("Teacher information");
		btnNewButton.setBounds(190, 12, 192, 27);
		btnNewButton.setBackground(new Color(255, 128, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				public void actionPerformed(ActionEvent e) {
            	TeacherFetch sf = new TeacherFetch(sapIdOrEmail);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
		
		JButton btnNewButton_1 = new JButton("Teacher Attendance");
		btnNewButton_1.setBounds(386, 11, 170, 28);
		btnNewButton_1.setBackground(new Color(255, 128, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Open the Teacher Registration window
		    	AttendanceReport1 sj = new AttendanceReport1();
		    	sj.frame.setVisible(true);
//		        frame.setVisible(false);
		    }
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Student Attendance");
        btnNewButton_2.setBounds(566, 10, 159, 30);
        btnNewButton_2.setBackground(new Color(255, 128, 255));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Attendancereport sj = new Attendancereport();
		    	sj.frame.setVisible(true);
//		        frame.setVisible(false);
        	}
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        frame.getContentPane().add(btnNewButton_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(190, 0, 708, 50);
        lblNewLabel_3.setIcon(new ImageIcon(Screen2.class.getResource("/GUI/image/yellow-color-solid-background-1920x1080.png")));
        frame.getContentPane().add(lblNewLabel_3);
        
        JButton btnNewButton_4 = new JButton("Mark Attendance");
        btnNewButton_4.setBounds(190, 60, 192, 33);
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		StudentAttendance sj = new StudentAttendance();
		    	sj.frame.setVisible(true);
//		        frame.setVisible(false);
        		
        	}
        });
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_4.setBackground(new Color(0, 128, 255));
        frame.getContentPane().add(btnNewButton_4);
        
        JButton btnNewButton_3 = new JButton("Enter Student Marks");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 EnterMarks sl = new EnterMarks();  // Pass the main frame to EnterMarks constructor
                 sl.frame.setVisible(true);  // Show the EnterMarks frame
        	}
        });
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_3.setBackground(new Color(0, 0, 255));
        btnNewButton_3.setBounds(386, 61, 185, 33);
        frame.getContentPane().add(btnNewButton_3);
        
        JButton btnNewButton_5 = new JButton("About University");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		About sj = new About();
		    	sj.frame.setVisible(true);
        		
        	}
        });
        btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_5.setBackground(new Color(0, 0, 255));
        btnNewButton_5.setBounds(738, 60, 160, 33);
        frame.getContentPane().add(btnNewButton_5);
        
        JButton btnNewButton_6 = new JButton("View marks");
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		marksFetch sj = new marksFetch();
		    	sj.frame.setVisible(true);
        		
        	}
        });
        btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton_6.setBackground(new Color(0, 0, 255));
        btnNewButton_6.setBounds(581, 60, 144, 33);
        frame.getContentPane().add(btnNewButton_6);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(marksFetch.class.getResource("/GUI/image/081aed2e7ddc029f940021ddb22145fc - Copy.jpg")));
        lblNewLabel_4.setBounds(190, 49, 708, 69);
        frame.getContentPane().add(lblNewLabel_4);
        
        frame.setVisible(true);
        
    }
	
	 private void searchStudentBySapId(String sapId) {
	        try {
	            Connection conn = null;
				// Create a SQL statement
	            Statement statement = conn.createStatement();

	            // SQL query to search for a student by SAP ID
	            String sql = "SELECT * FROM teacher WHERE sap_id = '" + sapId + "'";

	            // Execute the query
	            ResultSet resultSet = statement.executeQuery(sql);
	            // Check if result set has any data
	            if (resultSet.next()) {
	                // Retrieve student details from the result set
	            	
	                String studentName = resultSet.getString("student_name");
//	                Name.setText(studentName);
	                String rollNo = resultSet.getString("father_name");
//	                Roll.setText(rollNo);
	                System.out.println(studentName + rollNo );
//	                Adress.setText(address);
//	                Sap.setText(sap);
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
	            String url = "jdbc:mysql://localhost:3306/university";
	            String username = "root";
	            String password = "Rach123gullu@";

	            Connection conn = DriverManager.getConnection(url, username, password);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

