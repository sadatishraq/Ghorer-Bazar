package Classes;

import Interface.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PaymentScs implements ActionListener,IPaymentSuccess
{

    private JFrame frame;
    private JLabel tcs;
    private JLabel ap;

    private JButton home;
    private JButton exit;
    private String f;
    public PaymentScs(double amount,String user) 
	{

        frame= new JFrame("Ghorer Bazar-Payment Successful");

        ImageIcon framelogo     = new ImageIcon("Images/icon.png");
        frame.setIconImage(framelogo.getImage());


        f=user;

        


        tcs = new JLabel("Payment Completed Successfully!");
        tcs.setForeground(Color.BLACK);
        tcs.setFont(new Font("Segoe UI Black", Font.PLAIN, 34));
        tcs.setBounds(240, 50, 600, 50);
        frame.add(tcs);


        ap = new JLabel("Amount Paid :    "+amount+" tk");
        ap.setVerticalTextPosition(JLabel.BOTTOM);
        ap.setHorizontalTextPosition(JLabel.CENTER);
        ap.setForeground(Color.BLACK);
        ap.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
        ap.setBounds(410, 200, 400, 100);
        frame.add(ap);


        home= new JButton("Home");
        home.setBounds(350, 450, 100, 30);
        home.setFocusable(false);
        home.setBackground(Color.decode("#FAAB78"));
        home.setForeground(Color.black);
        home.setBorder(BorderFactory.createEmptyBorder());
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        home.addActionListener(this);
        frame.add(home);

        exit= new JButton("Exit");
        exit.setBounds(550, 450, 100, 30);
        exit.setFocusable(false);
        exit.setBackground(Color.decode("#FAAB78"));
        exit.setForeground(Color.black);
        exit.setBorder(BorderFactory.createEmptyBorder());
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exit.addActionListener(this);
        frame.add(exit);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 737);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setResizable(false);
        frame.setLayout (null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) 
	{
        if(e.getSource()==exit)
        {
            System.exit(0);
        }

        else if(e.getSource()==home)
        {
            frame.setVisible(false);
            new CustomerDashboard(f);
        }

    }

}
