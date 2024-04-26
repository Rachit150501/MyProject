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
import javax.swing.JPasswordField;

public class MainScreen {

    JFrame frame;
    private JLabel lblNewLabel_2;
	protected Window registrationStudent1;
	private JFrame firstFrame;
	 private JFrame firstFrame1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	MainScreen window = new MainScreen();
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
    public MainScreen() {
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
		frame.setVisible(false);

		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 116, 999, 458);
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
		lblNewLabel_2.setBounds(728, 10, 170, 33);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_1.setVisible(true);
		
		JButton btnNewButton = new JButton("Student Login");
		btnNewButton.setBounds(190, 12, 192, 27);
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Open the Student Registration window
//				RegistrationStudent ca = new RegistrationStudent();
				StudentLogins sl = new StudentLogins();
//				registrationStudent1.setVisible(true);
//				frame.setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
		
		JButton btnNewButton_1 = new JButton("Teacher Login");
		btnNewButton_1.setBounds(386, 11, 182, 28);
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Open the Teacher Login window
		        TeacherLogin t2 = new TeacherLogin();
		        t2.frame.setVisible(true);
//		        frame.setVisible(false);             //its off the first frame
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(159, 133, 716, 52);
        lblNewLabel_3.setIcon(new ImageIcon(ScreenBackground.class.getResource("/GUI/image/light-brown-color-solid-background-1920x1080.png")));
        frame.getContentPane().add(lblNewLabel_3);
        
        JButton btnNewButton_2 = new JButton("University Login");
        btnNewButton_2.setBounds(578, 10, 140, 27);
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2.setBackground(new Color(255, 0, 0));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LOGIN sl = new  LOGIN();		
        		sl.frame.setVisible(true);
//				frame.setVisible(false);
        	
        		
        	}
        });
        frame.getContentPane().add(btnNewButton_2);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(190, 0, 708, 52);
        lblNewLabel_5.setIcon(new ImageIcon(MainScreen.class.getResource("/GUI/image/yellow-color-solid-background-1920x1080.png")));
        frame.getContentPane().add(lblNewLabel_5);
        
        JButton btnNewButton_3 = new JButton("About university");
        btnNewButton_3.setBounds(192, 62, 182, 31);
        btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		

        		About sl = new  About();		
        		sl.frame.setVisible(true);
//				frame.setVisible(false);
        		
        	}
        });
        btnNewButton_3.setBackground(new Color(0, 255, 0));
        frame.getContentPane().add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("Admission Open");
        btnNewButton_4.setBounds(376, 62, 170, 31);
        btnNewButton_4.setBackground(new Color(0, 255, 0));
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		RegistrationStudent sl = new  RegistrationStudent();		
        		sl.frame.setVisible(true);
        	}
        });
        btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        frame.getContentPane().add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton("Teacher Application ");
        btnNewButton_5.setBounds(556, 62, 170, 31);
        btnNewButton_5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		

        		RegistationTeacher sl = new  RegistationTeacher();		
        		sl.frame.setVisible(true);
        	}
        });
        btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_5.setBackground(new Color(0, 255, 0));
        frame.getContentPane().add(btnNewButton_5);
        
        frame.setVisible(true);
        
    }
}