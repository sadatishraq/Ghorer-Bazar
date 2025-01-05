package Classes;

import Interface.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Uprofile implements ActionListener,IUProfile
{

    private JButton previous0;
    private JTextArea display;
    private JFrame frame;

    private String f;

    private Container c;

    public Uprofile(String user)
    {
        f = user;
        frame = new JFrame("Ghorer Bazar-Profile");

        c = frame.getContentPane();
        c.setBackground(Color.WHITE);

        ImageIcon framelogo = new ImageIcon("Images/icon.png");
        ImageIcon previousImage = new ImageIcon("icons/previous.png");


        display = new JTextArea (5, 5);
        display.setBounds(40,20,500,200);
        display.setFont(new Font("Times New Roman",Font.BOLD,19));
        frame.add(display);


        String line1=" ";
        String line2=" ";
        String line3=" ";
        String line4=" ";
        try {
            String userNameS = "User Name : " + f;
            BufferedReader reader = new BufferedReader(new FileReader("data\\userdata.txt"));

            int totalLines = 0;
            while (reader.readLine() != null) {
                totalLines++;
            }
            reader.close();

            for (int i = 0; i <= totalLines; i++)
            {
                line1 = Files.readAllLines(Paths.get("data\\userdata.txt")).get(i);

                if (line1.equals(userNameS))
                {
                    line2 = Files.readAllLines(Paths.get("data\\userdata.txt")).get((i + 1));
                    line3 = Files.readAllLines(Paths.get("data\\userdata.txt")).get((i + 2));
                    line4 = Files.readAllLines(Paths.get("data\\userdata.txt")).get((i + 3));
                    break;
                }
            }

        }
        catch (Exception ex)
        {
            new CustomerDashboard(f);
            JOptionPane.showMessageDialog(null, "Something went horribly wrong", "Warning!", 0);
            return;
        }

        display.setText(line1+"\n\n"+line2+"\n\n"+line3+"\n\nUser creation "+line4);


        previous0 = new JButton ("Back");
        previous0.setBounds(450, 300, 100, 30);
        previous0.setFocusable(false);
        previous0.setBackground(Color.LIGHT_GRAY);
        previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        previous0.addActionListener(this);
        previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        previous0.setIcon(previousImage);
        frame.add(previous0);

        frame.setIconImage(framelogo.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,737);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout (null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource()==previous0)
        {
            frame.setVisible(false);
            new CustomerDashboard(f);
        }

    }


}

