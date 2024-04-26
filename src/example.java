

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class example {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	example  window = new example ();
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
    public example () {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400); // Changed frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Image JLabel
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(example .class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        lblNewLabel_2.setBounds(310, 10, 116, 71);
        lblNewLabel_2.setVisible(true);
        frame.getContentPane().add(lblNewLabel_2);  // Add the JLabel to the JFrame's content pane

        JLabel lblNewLabel = new JLabel("Create UserName ");
        lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
        lblNewLabel.setBounds(71, 71, 167, 13);
        frame.getContentPane().add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(71, 106, 241, 19);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Password ");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(71, 135, 167, 19);
        frame.getContentPane().add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(71, 164, 241, 19);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        btnNewButton.setBounds(128, 203, 135, 39);
        frame.getContentPane().add(btnNewButton);
        frame.setVisible(true);
        JLabel lblNewLabel_6 = new JLabel("DIT UNIVERSITY   ");
        lblNewLabel_6.setBounds(35, 38, 562, 33);
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 35));
        frame.getContentPane().add(lblNewLabel_6);
        lblNewLabel_2.setVisible(true);


    }
}
