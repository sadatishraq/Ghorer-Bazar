package Classes;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDashboard extends JFrame implements ActionListener 
{

    private Container c;
    private JLabel title, groceryLbl, clothingLbl, lprofile;
    private JButton logout, profile, grocery,clothing;
    private String f;


    public CustomerDashboard(String user) 
	{
        ImageIcon framelogo     = new ImageIcon("Images/icon.png");
        setIconImage(framelogo.getImage());

        f=user;

        Icon groceryIcon = new ImageIcon("Images/grocery.png");
        Icon clothingIcon = new ImageIcon("Images/clothing.png");
        Icon logoutIcon = new ImageIcon("Images/logout.jpg");
        Icon proIcon = new ImageIcon("Images/profile.jpg");
        Icon banner = new ImageIcon("Images/banner.png");

        setTitle("Ghorer Bazar");
        setBounds(0, 0, 1000, 737);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        title = new JLabel(banner);
        title.setBounds(250, 0, 500, 117);
        title.setFont(new Font("forte", Font.PLAIN, 40));
        c.add(title);

        logout = new JButton(logoutIcon);
        logout.setBounds(5, 5, 48, 48);
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.addActionListener(this);
        c.add(logout);

        profile = new JButton(proIcon);
        profile.setBounds(933, 5, 48, 48);
        profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        profile.addActionListener(this);
        c.add(profile);


        lprofile = new JLabel (user);
        lprofile.setBounds(844, 9, 80, 30);
        lprofile.setFont(new Font("Segoe UI", 1, 15));
        lprofile.setForeground(Color.decode("#006216"));
        lprofile.setBackground(Color.WHITE);
        lprofile.setHorizontalAlignment(JLabel.RIGHT);
        lprofile.setOpaque(true);
        c.add(lprofile);


        grocery = new JButton(groceryIcon);
        grocery.setBounds(150, 200, 300, 300);
        grocery.addActionListener(this);
        c.add(grocery);

        groceryLbl = new JLabel("Groceries");
        groceryLbl.setBounds(256, 505, 120, 30);
        groceryLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(groceryLbl);



        clothing = new JButton(clothingIcon);
        clothing.setBounds(550, 200, 300, 300);
        clothing.addActionListener(this);
        c.add(clothing);

        clothingLbl = new JLabel("Clothing");
        clothingLbl.setBounds(665, 505, 150, 30);
        clothingLbl.setFont(new Font("Arial", Font.PLAIN, 20));
        c.add(clothingLbl);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==grocery){
            new GroceryItem(f);
            setVisible(false);
        }
        
        else if(e.getSource()==clothing){
            new ClothingItem(f);
            setVisible(false);
        }
        else if (e.getSource()==logout){
            new CustomerLogin();
            setVisible(false);
        }
        else if(e.getSource()==profile){
            setVisible(false);
            new Uprofile(f);
        }
    }


}

