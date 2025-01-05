package Classes;

import Interface.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame implements ActionListener,IAdminLogin 
{

    private JLabel uname, upass,title,pic;
    private JTextField tname;
    private JPasswordField tpass;
    private JButton signin, back;
    private User u1, u2,u3;
    private User users[];
    private Container c;

    public AdminLogin() 
	{

        u1 = new User("Aungkon", "1234");
        u2 = new User("Himaloy", "1234");
        u3 = new User("Arnab","1234");
        users = new User[4];
        users[0] = u1;
        users[1] = u2;
        users[2] = u3;

        ImageIcon framelogo     = new ImageIcon("Images/icon.png");
        setIconImage(framelogo.getImage());


        ImageIcon icon =new ImageIcon("Images/admin.png");
        pic=new JLabel(icon);
        pic.setBounds(50,111,478,478);
        this.add(pic);




        setTitle("Ghore Bazar-Admin Login");
        setSize(1000, 737);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);


        title = new JLabel("Admin Login");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(680, 120);
        c.add(title);



        uname = new JLabel("Admin Username : ");
        uname.setFont(new Font("Arial", Font.PLAIN, 18));
        uname.setSize(164, 30);
        uname.setLocation(600, 250);
        c.add(uname);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 18));
        tname.setSize(186, 30);
        tname.setLocation(752, 250);
        c.add(tname);

        upass = new JLabel("Admin Password  : ");
        upass.setFont(new Font("Arial", Font.PLAIN, 18));
        upass.setSize(164, 30);
        upass.setLocation(600, 300);
        c.add(upass);

        tpass = new JPasswordField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 18));
        tpass.setSize(186, 30);
        tpass.setLocation(752, 300);
        c.add(tpass);

        signin = new JButton("Login");
        signin.setBackground(Color.ORANGE);
        signin.setOpaque(true);
        signin.setFont(new Font("Arial", Font.PLAIN, 25));
        signin.setSize(100, 30);
        signin.setLocation(784, 400);
        signin.addActionListener(this);
        c.add(signin);

        back = new JButton("Back");
        back.setFont(new Font("Arial", Font.PLAIN, 25));
        back.setSize(100, 30);
        back.setLocation(654, 400);
        back.setBackground(new Color(130, 182, 217));
        back.setOpaque(true);
        back.addActionListener(this);
        c.add(back);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signin) {
            String user = tname.getText();
            String pass = tpass.getText();

            int flag = 0;

            if (user.isEmpty() == false && pass.isEmpty() == false) {
                for (int i = 0; i < users.length; i++) {
                    if (users[i] != null) {
                        if (user.equals(users[i].getname()) && pass.equals(users[i].getPassword())) {
                            flag = 1;
                            break;
                        }
                    }
                }
                if (flag == 1) {
                    User x= this.searchUser(user);
                    new AdminHome(x);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or password!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fill up each field.");
            }
        } else if (e.getSource() == back) {
            new CustomerLogin();
            setVisible(false);
        }

    }

    public User searchUser(String user)
    {
        User a = null;

        for(int i=0; i<users.length; i++)
        {
            if(users[i]!=null)
            {
                if(users[i].getname().equals(user))
                {
                    a = users[i];
                    break;
                }
            }
        }
        return a;
    }

}
