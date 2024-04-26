package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class About {

    JFrame frame;
    private JTextArea textArea;
    private JLabel photoLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                About window = new About();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public About() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 811, 600);
        frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(About.class.getResource("/GUI/image/DIT_University_Dehradun_Logo.jpg")));
        lblNewLabel.setBounds(623, 0, 174, 162);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("About University :");
        lblNewLabel_1.setForeground(new Color(0, 0, 255));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_1.setBounds(10, 10, 240, 31);
        frame.getContentPane().add(lblNewLabel_1);
        
        JTextArea txtrHuihuhuihuDopjdoiewjedSihjdoihjew = new JTextArea();
        txtrHuihuhuihuDopjdoiewjedSihjdoihjew.setBackground(new Color(255, 255, 0));
        txtrHuihuhuihuDopjdoiewjedSihjdoihjew.setForeground(new Color(255, 0, 0));
        txtrHuihuhuihuDopjdoiewjedSihjdoihjew.setText(" It is a private institution that has partnerships with ASSOCHAM \r\n India, FICCI, and CII. DIT University and its degrees are\r\n recognized by the UGC,New Delhi, and by the Nepal Engineering\r\n  Council. DIT University is a member of the Association of Indian\r\n  Universities. The Pharmacy Council of India has approved the B.");
        txtrHuihuhuihuDopjdoiewjedSihjdoihjew.setBounds(0, 51, 623, 111);
        frame.getContentPane().add(txtrHuihuhuihuDopjdoiewjedSihjdoihjew);
        
        JTextArea txtrWhatIsThe = new JTextArea();
        txtrWhatIsThe.setText(" Q.What is the rank of dit college in India?\r\n DIT University was ranked #195 and #179 by the NIRF in the 'Engineering' category for \r\n 2021 and 2022, respectively. However, the institute was not ranked in the year 2023\r\n\r\n\r\n\r\n Q.What is the mode of admission in DIT Dehradun?\r\n 1) Merit based counseling on rank of Joint Entrance Examination(JEE).\r\n 2) Direct Admission for XII Std Board Toppers (See Remarks)- 10% Seats. 3) Merit \r\n  based counseling on XII Std aggregate marks.\r\n\r\n\r\n Q.What are the placements for Dehradun Technical university?\r\n DIT University Placements 2022 School - Wise\r\n School\tTotal No.of students\tPlacement %\r\n School of Computing\t621\t96%\r\n School of Engineering\t236\t84%\r\n School of Management\t38\t100%\r\n School of Architecture Design & Planning\t103\t73%\r\n");
        txtrWhatIsThe.setBackground(new Color(128, 255, 255));
        txtrWhatIsThe.setBounds(0, 162, 797, 391);
        frame.getContentPane().add(txtrWhatIsThe);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(About.class.getResource("/GUI/image/dark-blue-color-solid-background-1920x1080.png")));
        lblNewLabel_2.setBackground(new Color(0, 255, 255));
        lblNewLabel_2.setBounds(0, 0, 623, 50);
        frame.getContentPane().add(lblNewLabel_2);

     
    }
}
