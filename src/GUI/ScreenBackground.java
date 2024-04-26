package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import java.awt.event.ActionEvent;

public class ScreenBackground {

    JFrame frame;
    private JLabel lblNewLabel_2;
	protected Window registrationStudent1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	ScreenBackground window = new ScreenBackground();
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
    public ScreenBackground() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
   
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame("WELCOME TO DIT UNIVERSITY");
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 912, 579);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 117, 999, 425);
	    lblNewLabel.setIcon(new ImageIcon(ScreenBackground.class.getResource("/GUI/image/WhatsApp Image 2024-03-02 at 23.49.11_bf40de59.jpg")));
	    frame.getContentPane().add(lblNewLabel);
	    
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 192, 119);
		lblNewLabel_1.setForeground(new Color(64, 0, 0));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		lblNewLabel_1.setIcon(new ImageIcon(ScreenBackground.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
		lblNewLabel_1.setToolTipText("");
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Phone No : 1800 1210 41000");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(764, -28, 170, 107);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_1.setVisible(true);
		
		JButton btnNewButton = new JButton("Student  information");
		btnNewButton.setBackground(new Color(128, 255, 0));
		btnNewButton.setBounds(190, 12, 148, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStudentSap bj = new SearchStudentSap();
				  bj.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.getContentPane().add(btnNewButton);
//		frame.setVisible(true);
		
		JButton btnNewButton_1 = new JButton("Teacher Information");
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
//		        
		    	SearchTeacherSap bj = new SearchTeacherSap();
				  bj.frame.setVisible(true);
//				  frame .setVisible(false);
		    	
		    }
		});
		btnNewButton_1.setBounds(348, 10, 127, 28);
		frame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_3 = new JButton("Teacher Attendance\r\n");
        btnNewButton_3.setBackground(new Color(128, 255, 0));
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		// Now create and show the TeacherAttendance frame
		        TeacherAttendence bh = new TeacherAttendence();
		        bh.frame.setVisible(true);
        	}
        });
        btnNewButton_3.setBounds(485, 11, 137, 28);
        frame.getContentPane().add(btnNewButton_3);
        
        JButton btnEnterStudentMarks = new JButton("Enter Student Marks");
        btnEnterStudentMarks.setBackground(new Color(0, 255, 255));
        btnEnterStudentMarks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EnterMarks sl = new EnterMarks();  // Pass the main frame to EnterMarks constructor
                sl.frame.setVisible(true);  // Show the EnterMarks frame
            }
        });
        btnEnterStudentMarks.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnEnterStudentMarks.setBounds(190, 70, 137, 32);
        frame.getContentPane().add(btnEnterStudentMarks);


        
        JButton btnNewButton_4 = new JButton("About\r\n");
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                About sl = new About();		
                sl.frame.setVisible(true);
            }
        });
        btnNewButton_4.setBackground(new Color(0, 255, 255));
        btnNewButton_4.setBounds(330, 69, 97, 33);
        frame.getContentPane().add(btnNewButton_4);
        
        JButton btnNewButton_6 = new JButton("Student Attendance");
        btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnNewButton_6.setBackground(new Color(128, 255, 0));
        btnNewButton_6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		StudentAttendance bj = new StudentAttendance();
        		bj.frame.setVisible(true);
//        		frame .setVisible(false);

        	}
        });
        btnNewButton_6.setBounds(632, 10, 127, 28);
        frame.getContentPane().add(btnNewButton_6);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBackground(new Color(0, 255, 0));
        lblNewLabel_3.setIcon(new ImageIcon(ScreenBackground.class.getResource("/GUI/image/light-brown-color-solid-background-1920x1080.png")));
        lblNewLabel_3.setBounds(184, 228, 709, 51);
        frame.getContentPane().add(lblNewLabel_3);
        
        JButton btnNewButton_2 = new JButton("View Marks");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		marksFetch bj = new marksFetch();
        		bj.frame.setVisible(true);
        		
        	}
        });
        btnNewButton_2.setBackground(new Color(0, 255, 255));
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnNewButton_2.setBounds(432, 70, 97, 33);
        frame.getContentPane().add(btnNewButton_2);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setIcon(new ImageIcon(ScreenBackground.class.getResource("/GUI/image/yellow-color-solid-background-1920x1080.png")));
        lblNewLabel_4.setBackground(new Color(128, 255, 128));
        lblNewLabel_4.setBounds(190, 0, 708, 51);
        frame.getContentPane().add(lblNewLabel_4);
        
        JButton btnNewButton_5 = new JButton("View Student Attendance");
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Attendancereport bj = new Attendancereport();
        		bj.frame.setVisible(true);
        		
        	}
        });
        btnNewButton_5.setBackground(new Color(0, 255, 255));
        btnNewButton_5.setForeground(new Color(0, 0, 0));
        btnNewButton_5.setBounds(531, 70, 180, 33);
        frame.getContentPane().add(btnNewButton_5);
        
        JButton btnNewButton_7 = new JButton("View teacher Attendance");
        btnNewButton_7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		AttendanceReport1 bj = new AttendanceReport1();
        		bj.frame.setVisible(true);
        	}
        });
        btnNewButton_7.setBackground(new Color(0, 255, 255));
        btnNewButton_7.setBounds(713, 70, 180, 33);
        frame.getContentPane().add(btnNewButton_7);
        
        frame.setVisible(true);
        
    }
}