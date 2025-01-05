`package Classes;

import Interface.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Payment extends JFrame implements ActionListener,IPayment{

    private JFrame frame;
    private JLabel cyp;
    private JLabel pfuycd;
    private JLabel noc;
    private JLabel cn;
    private JLabel vn;
    private JLabel cvvc;
    private JLabel pay;

    private JTextField tfUName;
    private JTextField tfcn;
    private JTextField tfvo;
    private JPasswordField pfcvvc;

    private JButton cpB;
    private JButton exitButton;
    private JButton back;


    private double z;

    private String Category;
    private String f;

    public Payment(double amount, String name, String user) {

        ImageIcon framelogo     = new ImageIcon("Images/icon.png");


        f= user;

        Category= name;

        z=amount;
        frame = new JFrame("Ghorer Bazar-Payment");



        cyp = new JLabel("Complete Your Payment");
        cyp.setForeground(Color.BLACK);
        cyp.setFont(new Font("Segoe UI Black", Font.PLAIN, 34));
        cyp.setBounds(265, 50, 500, 50);
        frame.add(cyp);


        Icon ipay  = new ImageIcon("Images/payment.jpg");



        pfuycd = new JLabel("Please Fillup Your Card Details");
        pfuycd.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        pfuycd.setBounds(620, 150, 350, 50);
        frame.add(pfuycd);


        noc = new JLabel("Name On Card          : ");
        noc.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        noc.setBounds(600, 220, 200, 50);
        noc.setHorizontalAlignment(JLabel.LEFT);
        frame.add(noc);


        cn = new JLabel("Card Number            : ");
        cn.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        cn.setBounds(600, 290, 200, 50);
        cn.setHorizontalAlignment(JLabel.LEFT);
        frame.add(cn);


        vn = new JLabel("Valid On                     : ");
        vn.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        vn.setBounds(600, 360, 200, 50);
        vn.setHorizontalAlignment(JLabel.LEFT);
        frame.add(vn);

        cvvc = new JLabel("CVV Code                   : ");
        cvvc.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
        cvvc.setBounds(600, 410, 200, 50);
        cvvc.setHorizontalAlignment(JLabel.LEFT);
        frame.add(cvvc);


        tfUName = new JTextField();
        tfUName.setBounds(800, 235, 150, 23);
        tfUName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tfUName.setToolTipText("Your name?");
        tfUName.setVisible(true);
        frame.add(tfUName);


        tfcn = new JTextField();
        tfcn.setBounds(800, 305, 150, 23);
        tfcn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tfcn.setToolTipText("Your card number?");
        tfcn.setVisible(true);
        frame.add(tfcn);


        tfvo = new JTextField();
        tfvo.setBounds(800, 373, 150, 23);
        tfvo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        tfvo.setToolTipText("Your card validity date?");
        tfvo.setVisible(true);
        frame.add(tfvo);


        pfcvvc = new JPasswordField();
        pfcvvc.setBounds(800, 422, 150, 23);
        pfcvvc.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pfcvvc.setToolTipText("Your CVV code?");
        pfcvvc.setEchoChar('*');
        pfcvvc.setVisible(true);
        frame.add(pfcvvc);


        cpB= new JButton("Confirm Payment");
        cpB.setBounds(800, 480, 150, 30);
        cpB.setFocusable(false);
        cpB.setBackground(Color.decode("#FAAB78"));
        cpB.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        cpB.setBorder(BorderFactory.createEmptyBorder());
        cpB.addActionListener(this);
        cpB.setVisible(true);
        frame.add(cpB);


        exitButton = new JButton("Exit");
        exitButton.setBounds(695, 520, 150, 30);
        exitButton.setFocusable(false);
        exitButton.setForeground(Color.black);
        exitButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        exitButton.setBackground(Color.decode("#FAAB78"));
        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.addActionListener(this);
        frame.add(exitButton);


        back = new JButton ("Back");
        back.setBounds(600, 480, 150, 30);
        back.setFocusable(false);
        back.setBackground(Color.decode("#FAAB78"));
        back.setForeground(Color.black);
        back.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        back.setVisible(true);
        frame.add(back);

        pay = new JLabel(ipay);
        pay.setBounds(10,185,500,330);
        frame.add(pay);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 737);
        frame.getContentPane().setBackground(Color.decode("#FFFFFF"));
        frame.setResizable(false);
        frame.setLayout (null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setIconImage(framelogo.getImage());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back)
        {
            if(Category=="GroceryItem")
            {
                frame.setVisible(false);
                new GroceryItem(f);
            }

            else if(Category=="ClothingItem")
            {
                frame.setVisible(false);
                new ClothingItem(f);
            }


        }
        else if(e.getSource()==exitButton)
        {
            int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
            if(a==0)
            {
                System.exit(0);
            }
        }

        else if(e.getSource()==cpB)
        {
            String a = tfUName.getText();
            String b = tfcn.getText();
            String c = tfvo.getText();
            String d = pfcvvc.getText();
            if (a.isEmpty()|| b.isEmpty() || c.isEmpty() || d.isEmpty())
            {
                JOptionPane.showInternalMessageDialog(null, "Please fill up all the necessary details");
            }
            else
            {
                try
                {


                    if(b.length()>16)
                    {
                        JOptionPane.showMessageDialog(null, "Card number should't have more than 16 digit ", "Alert!", 0);
                    }

                    else if (d.length()!=3)
                    {
                        JOptionPane.showMessageDialog(null, "CVV code number should have 3 digit ", "Alert!", 0);
                    }

                    else if(b.length()<=16 && d.length()==3)
                    {
                        frame.setVisible(false);
                        new PaymentScs(z,f);
                    }
                    try
                    {
                        File newfile = new File("data\\Last2.txt");
                        newfile.createNewFile();
                        FileWriter writeFile = new FileWriter("data\\Last2.txt");

                        writeFile.write("Name on Card : "+a+".\nCard Number :"+b+
                                ".\nValid On : "+c+".\nCVV Code : "+d+".");
                        writeFile.close();

                    }

                    catch(IOException io)
                    {
                        JOptionPane.showMessageDialog(null, "An error Occured while writting file");
                        io.printStackTrace();
                    }

                }


                catch(InputMismatchException a1)
                {
                    JOptionPane.showMessageDialog(null, "Please enter valid card no or code!", "Alert!", 0);
                }
                catch(NumberFormatException a2)
                {
                    JOptionPane.showMessageDialog(null, "Please enter valid information!", "Alert!", 0);
                }

            }
        }

    }

}

