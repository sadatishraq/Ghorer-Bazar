package Classes;

import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHome extends JFrame implements ActionListener,IAdminHome {

    private JFrame frame;
    private JLabel adminProLbl;
    private JButton userData;
    private JButton previous0;
    private JButton exitButton;
    private JTextArea display;
    // private JLabel iad;
    private User x;
    private Container c;

    public AdminHome(User a)
    {
        x=a;

        frame = new JFrame("Admin Home");
        ImageIcon framelogo = new ImageIcon("Images/icon.png");
        ImageIcon adminprofile  = new ImageIcon("Images/adminprofile.jpg");

        c = frame.getContentPane();
        c.setBackground(Color.WHITE);





        adminProLbl = new JLabel(adminprofile);
        adminProLbl.setBounds(372,10,256,256);
        frame.add(adminProLbl);





        userData= new JButton("User Data");
        userData.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 25));
        userData.setBounds(525, 410, 150, 50);
        userData.setFocusable(false);
        userData.setBackground(Color.decode("#4682B4"));
        userData.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userData.setBorder(BorderFactory.createEtchedBorder());
        userData.addActionListener(this);
        frame.add(userData);


        previous0 = new JButton ("Logout");
        previous0.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 25));
        previous0.setBounds(325, 410, 150, 50);
        previous0.setFocusable(false);
        previous0.setBackground(Color.decode("#4682B4"));
        previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        previous0.addActionListener(this);
        frame.add(previous0);


        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 25));
        exitButton.setBounds(425, 470, 150, 50);
        exitButton.setFocusable(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setBackground(Color.decode("#4682B4"));
        exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        exitButton.addActionListener(this);
        frame.add(exitButton);


        display = new JTextArea (1, 1);
        display.setBounds(430,266,150,50);
        display.setBackground(Color.WHITE);
        display.setFont(new Font("Times New Roman",Font.BOLD,25));
        String name= a.getname();
        display.setText(name);
        display.setEditable(false);
        frame.add(display);




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 737);
        frame.setIconImage(framelogo.getImage());
        frame.setResizable(false);
        frame.setLayout (null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==exitButton)
        {
            System.exit(0);
        }
        else if (e.getSource()==previous0)
        {
            frame.setVisible(false);
            new AdminLogin();
        }
        else if (e.getSource()==userData)
        {
            frame.setVisible(false);
            new UserData(x);
        }
    }

}
