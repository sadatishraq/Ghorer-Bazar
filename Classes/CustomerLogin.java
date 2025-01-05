package Classes;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomerLogin implements ActionListener
{
    private JFrame lgnFrame;
    private JLabel imgLbl,unameLbl,passLbl,titleLbl;
    private JButton lgnBtn,regBtn,extBtn,adminBtn;
    private JTextField uidFld;
    private JPasswordField passFld;
    private ImageIcon icon,img,on,off,adminIcon;
    private Container c;

    private JToggleButton toggleButton;

    public CustomerLogin()
    {
        lgnFrame = new JFrame("Ghorer Bazar-Login");


        c = lgnFrame.getContentPane();
        c.setBackground(Color.WHITE);


        icon = new ImageIcon("Images/icon.png");
        img = new ImageIcon("Images/logo.png");
        adminIcon = new ImageIcon("Images/adminIcon.jpg");


        adminBtn =new JButton(adminIcon);
        adminBtn.setBounds(933,5,48,48);
        adminBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminBtn.setToolTipText("Admin Panel");
        adminBtn.addActionListener(this);


        imgLbl = new JLabel(img);
        imgLbl.setBounds(30,00,530,700);

        titleLbl = new JLabel("Login");
        titleLbl.setBounds(676,200,85,50);
        titleLbl.setFont(new Font("Segoe UI", 1, 30));

        unameLbl = new JLabel("Username : ");
        unameLbl.setBounds(600,270,85,30);
        unameLbl.setFont(new Font("Segoe UI", 1, 15));

        passLbl = new JLabel("Password  : ");
        passLbl.setBounds(600,310,85,30);
        passLbl.setFont(new Font("Segoe UI", 1, 15));

        uidFld = new JTextField();
        uidFld.setBounds(685,270,150,30);
        uidFld.setFont(new Font("Segoe UI", 1, 15));
        uidFld.setToolTipText("Enter your username here");

        passFld = new JPasswordField();
        passFld.setBounds(685,310,150,30);
        passFld.setFont(new Font("Segoe UI", 1, 15));
        passFld.setToolTipText("Enter your password here");


        lgnBtn = new JButton("Login");
        lgnBtn.setBounds(600,365,85,30);
        lgnBtn.setFont(new Font("Segoe UI", 1, 19));
        lgnBtn.setBorder(new LineBorder(new Color(51, 50, 108), 1));
        lgnBtn.setBackground(Color.decode("#a8c2c1"));
        lgnBtn.addActionListener(this);
        lgnBtn.setFocusable(false);
        lgnBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        regBtn = new JButton("Register");
        regBtn.setBounds(750,365,85,30);
        regBtn.setFont(new Font("Segoe UI", 1, 19));
        regBtn.setBorder(new LineBorder(new Color(51, 50, 108), 1));
        regBtn.setBackground(Color.decode("#a8c2c1"));
        regBtn.setFocusable(false);
        regBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        regBtn.addActionListener(this);

        extBtn = new JButton("Exit");
        extBtn.setBounds(675,400,85,30);
        extBtn.setFont(new Font("Segoe UI", 1, 19));
        extBtn.setBorder(new LineBorder(new Color(51, 50, 108), 1));
        extBtn.setBackground(Color.decode("#a8c2c1"));
        extBtn.setFocusable(false);
        extBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        extBtn.addActionListener(this);


        lgnFrame.add(titleLbl);
        lgnFrame.add(adminBtn);
        lgnFrame.add(unameLbl);
        lgnFrame.add(passLbl);
        lgnFrame.add(imgLbl);
        lgnFrame.add(uidFld);
        lgnFrame.add(passFld);
        lgnFrame.add(lgnBtn);
        lgnFrame.add(regBtn);
        lgnFrame.add(extBtn);





        on = new ImageIcon("Images/on.jpg");
        off = new ImageIcon("Images/off.jpg");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(835, 316, 30, 17);
        toggleButton.setBackground(Color.WHITE);
        toggleButton.setForeground(Color.WHITE);
        toggleButton.setOpaque(true);
        toggleButton.setBorder(BorderFactory.createEmptyBorder());
        toggleButton.setFocusable(false);
        toggleButton.setToolTipText("Show Password");
        toggleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton.setVisible(true);
        lgnFrame.add(toggleButton);
        toggleButton.addActionListener(this);











        lgnFrame.setSize(1000,737);
        lgnFrame.setLocationRelativeTo(null);
        lgnFrame.setLayout(null);
        lgnFrame.setVisible(true);
        lgnFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lgnFrame.setResizable(false);
        lgnFrame.setIconImage(icon.getImage());


    }




    @Override
    public void actionPerformed(ActionEvent e)
    {



        if (e.getSource() == toggleButton)
        {
            if (toggleButton.isSelected()) {
                toggleButton.setIcon(on);
                passFld.setEchoChar((char) 0);
            } else {
                toggleButton.setIcon(off);
                passFld.setEchoChar('*');
            }
        }


        if(e.getSource()==regBtn)
        {

            new CustomerRegistration();
            lgnFrame.setVisible(false);

        }

        if(e.getSource()==adminBtn)
        {

            new AdminLogin();
            lgnFrame.setVisible(false);

        }

        else if(e.getSource()==lgnBtn)
        {
            String user = uidFld.getText();
            String pass = passFld.getText();
            if (user.isEmpty()|| pass.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }


            else {

                try {
                    String userNameS = "User Name : " + user;
                    String passwordS = "Password : " + pass;
                    BufferedReader reader = new BufferedReader(new FileReader("data\\userdata.txt"));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++) {
                        String line = Files.readAllLines(Paths.get("data\\userdata.txt")).get(i);
                        if (line.equals(userNameS)) {
                            String line2 = Files.readAllLines(Paths.get("data\\userdata.txt")).get((i + 1));
                            if (line2.equals(passwordS)) {
                                lgnFrame.setVisible(false);
                                new CustomerDashboard(user);
                                break;
                            }
                        }
                    }
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        }


        else if(e.getSource()==extBtn)
        {
            System.exit(0);
        }


    }

}