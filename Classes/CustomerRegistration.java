package Classes;

import Interface.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CustomerRegistration extends JFrame implements ActionListener,ICustomerRegistration{

    private JFrame regFrame;
    private JLabel label1;
    private JLabel userName;
    private JLabel userPass;
    private JLabel email;
    private JLabel confirmUserPass;
    private JTextField tfUName;
    private JPasswordField pfUPass;
    private JPasswordField cpfUPass;
    private JTextField tfemail;
    private JButton regBtn,backBtn,extBtn;
    private ImageIcon on,off,icon;
    private JToggleButton toggleButton1,toggleButton2;
    private Container c;

    public CustomerRegistration()
    {
        regFrame = new JFrame("Ghorer Bazar-Registration");

        c = regFrame.getContentPane();
        c.setBackground(Color.WHITE);

        icon = new ImageIcon("Images/icon.png");
        setIconImage(icon.getImage());





        label1 = new JLabel("Registration");
        label1.setFont(new Font("Segoe UI",1,30));
        label1.setBounds(412, 80, 176, 50);
        regFrame.add(label1);


        userName = new JLabel("Username : ");
        userName.setBounds(382, 180, 86, 30);
        userName.setFont(new Font("Segoe UI",1,15));
        regFrame.add(userName);


        userPass = new JLabel("Password : ");
        userPass.setBounds(382, 220, 186, 30);
        userPass.setFont(new Font("Segoe UI",1,15));
        regFrame.add(userPass);


        confirmUserPass = new JLabel("Confirm Password : ");
        confirmUserPass.setBounds(320, 260, 200, 30);
        confirmUserPass.setFont(new Font("Segoe UI",1,15));
        regFrame.add(confirmUserPass);


        tfUName = new JTextField();
        tfUName.setBounds(468, 180, 150, 30);
        tfUName.setFont(new Font("Segoe UI", 1, 15));
        tfUName.setBorder(BorderFactory.createLineBorder(Color.decode("#3A4A62"), 1));
        tfUName.setToolTipText("Enter your name here");
        regFrame.add(tfUName);


        pfUPass = new JPasswordField();
        pfUPass.setBounds(468, 220, 150, 30);
        pfUPass.setFont(new Font("Segoe UI", 1, 15));
        pfUPass.setBorder(BorderFactory.createLineBorder(Color.decode("#3A4A62"), 1));
        pfUPass.setEchoChar('*');
        pfUPass.setToolTipText("Enter your password here");
        regFrame.add(pfUPass);



        on = new ImageIcon("Images/on.jpg");
        off = new ImageIcon("Images/off.jpg");
        toggleButton1 = new JToggleButton(off);
        toggleButton1.setBounds(618, 226, 30, 17);
        toggleButton1.setBackground(Color.WHITE);
        toggleButton1.setForeground(Color.WHITE);
        toggleButton1.setOpaque(true);
        toggleButton1.setBorder(BorderFactory.createEmptyBorder());
        toggleButton1.setFocusable(false);
        toggleButton1.setToolTipText("Show Password");
        toggleButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton1.setVisible(true);
        regFrame.add(toggleButton1);
        toggleButton1.addActionListener(this);


        cpfUPass = new JPasswordField();
        cpfUPass.setBounds(468, 260, 150, 30);
        cpfUPass.setFont(new Font("Segoe UI", 1, 15));
        cpfUPass.setBorder(BorderFactory.createLineBorder(Color.decode("#3A4A62"), 1));
        cpfUPass.setEchoChar('*');
        cpfUPass.setToolTipText("Re-write your password here");
        regFrame.add(cpfUPass);


        on = new ImageIcon("Images/on.jpg");
        off = new ImageIcon("Images/off.jpg");
        toggleButton2 = new JToggleButton(off);
        toggleButton2.setBounds(618, 266, 30, 17);
        toggleButton2.setBackground(Color.WHITE);
        toggleButton2.setForeground(Color.WHITE);
        toggleButton2.setOpaque(true);
        toggleButton2.setBorder(BorderFactory.createEmptyBorder());
        toggleButton2.setFocusable(false);
        toggleButton2.setToolTipText("Show Password");
        toggleButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        toggleButton2.setVisible(true);
        regFrame.add(toggleButton2);
        toggleButton2.addActionListener(this);





        email = new JLabel("Email : ");
        email.setBounds(414, 300, 150, 30);
        email.setFont(new Font("Segoe UI",1,15));
        regFrame.add(email);


        tfemail = new JTextField();
        tfemail.setBounds(468, 300, 150, 30);
        tfemail.setFont(new Font("Segoe UI", 1, 15));
        tfemail.setBorder(BorderFactory.createLineBorder(Color.decode("#3A4A62"), 1));
        tfemail.setToolTipText("Your Email Adress?");
        regFrame.add(tfemail);




        backBtn = new JButton("Back");
        backBtn.setBounds(390,380,85,30);
        backBtn.setFont(new Font("Segoe UI", 1, 19));
        backBtn.setBorder(new LineBorder(new Color(51, 50, 108), 1));
        backBtn.setBackground(Color.decode("#a8c2c1"));
        backBtn.addActionListener(this);
        backBtn.setFocusable(false);
        backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backBtn.addActionListener(this);
        regFrame.add(backBtn);

        regBtn = new JButton("Register");
        regBtn.setBounds(540,380,85,30);
        regBtn.setFont(new Font("Segoe UI", 1, 19));
        regBtn.setBorder(new LineBorder(new Color(51, 50, 108), 1));
        regBtn.setBackground(Color.decode("#a8c2c1"));
        regBtn.setFocusable(false);
        regBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        regBtn.addActionListener(this);
        regFrame.add(regBtn);

        extBtn = new JButton("Exit");
        extBtn.setBounds(465,415,85,30);
        extBtn.setFont(new Font("Segoe UI", 1, 19));
        extBtn.setBorder(new LineBorder(new Color(51, 50, 108), 1));
        extBtn.setBackground(Color.decode("#a8c2c1"));
        extBtn.setFocusable(false);
        extBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        extBtn.addActionListener(this);
        regFrame.add(extBtn);


        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.setSize(1000, 737);
        regFrame.setIconImage(icon.getImage());
        regFrame.setResizable(false);
        regFrame.setLayout (null);
        regFrame.setLocationRelativeTo(null);
        regFrame.setVisible(true);
    }

    public static void main(String[] args) {

        new CustomerRegistration();
    }
    @Override
    public void actionPerformed(ActionEvent e) {




        if (e.getSource() == toggleButton1)
        {
            if (toggleButton1.isSelected()) {
                toggleButton1.setIcon(on);
                pfUPass.setEchoChar((char) 0);
            } else {
                toggleButton1.setIcon(off);
                pfUPass.setEchoChar('*');
            }
        }



        if (e.getSource() == toggleButton2)
        {
            if (toggleButton2.isSelected()) {
                toggleButton2.setIcon(on);
                cpfUPass.setEchoChar((char) 0);
            } else {
                toggleButton2.setIcon(off);
                cpfUPass.setEchoChar('*');
            }
        }





        if (e.getSource()==backBtn)
        {
            new CustomerLogin();
            regFrame.setVisible(false);
        }
        else if(e.getSource()==extBtn)
        {
            System.exit(0);
        }
        else if(e.getSource()==regBtn)
        {
            String username = tfUName.getText();
            String pass = pfUPass.getText();
            String confirmPass = cpfUPass.getText();
            String sEmail = tfemail.getText();

            if (username.isEmpty()==false && pass.isEmpty()==false && sEmail.isEmpty()==false && sEmail.isEmpty()==false)
            {

                if (confirmPass.equals(pass))
                {
                    try {
                        File file = new File("data\\userdata.txt");
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        FileWriter fw = new FileWriter(file, true);
                        BufferedWriter bw = new BufferedWriter(fw);
                        PrintWriter pw = new PrintWriter(bw);

                        LocalDateTime myDateObj = LocalDateTime.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                        String timeAndDate = myDateObj.format(myFormatObj);

                        pw.println("User Name : " + username);
                        pw.println("Password : " + pass);
                        pw.println("Email : " + sEmail);
                        pw.println("Time & Date : " + timeAndDate);
                        pw.println("===============================================");
                        pw.close();

                        JOptionPane.showMessageDialog(null, "New User Created Successfully.", "User created",JOptionPane.INFORMATION_MESSAGE);
                        tfUName.setText(null);
                        pfUPass.setText(null);
                        cpfUPass.setText(null);
                        tfemail.setText(null);
                        regFrame.setVisible(false);
                        new CustomerLogin();
                    }

                    catch (Exception ex) {
                        System.out.print(ex);
                        JOptionPane.showMessageDialog(null,"Something Went wrong");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Password didn't match");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Please enter valid information in the fields");
            }

        }

    }

}
