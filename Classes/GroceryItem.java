package Classes;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class GroceryItem extends JFrame implements ActionListener {


    private Container c;


    private JButton rice;

    private JButton oil;

    private JButton honeynuts;


    private JButton back;

    private JButton order;


    private JLabel nmrice;

    private JLabel prrice;

    private JLabel nmoil;

    private JLabel proil;

    private JLabel nmhoneynuts;

    private JLabel prhoneynuts;


    private JCheckBox rrice;

    private JCheckBox roil;

    private JCheckBox rhoneynuts;


    private JComboBox<String> brice;

    private JComboBox<String> boil;

    private JComboBox<String> bhoneynuts;


    private String a[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private String b[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private String d[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    private String f;


    public GroceryItem(String user) {
        ImageIcon framelogo     = new ImageIcon("Images/icon.png");
        setIconImage(framelogo.getImage());

        f = user;



        Icon ricei = new ImageIcon("Images/basmatirice.jpg");

        Icon oili = new ImageIcon("Images/mustardoil.jpg");

        Icon honeynutsi = new ImageIcon("Images/honeynut.jpg");


        setTitle("Ghorer Bazar-Grocery Item");

        setBounds(0, 0, 1000, 737);

        setLayout(null);

        setResizable(false);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);


        c = getContentPane();

        c.setLayout(null);
        c.setBackground(Color.WHITE);


        back = new JButton("Back");

        back.setBounds(300, 550, 150, 50);

        back.setBackground(Color.RED);

        back.setOpaque(true);

        back.addActionListener(this);

        c.add(back);


        order = new JButton("Place Order");

        order.setBounds(550, 550, 150, 50);

        order.setBackground(Color.orange);

        order.setOpaque(true);

        order.addActionListener(this);

        c.add(order);




        rice = new JButton(ricei);

        rice.setBounds(150, 175, 200, 200);

        rice.addActionListener(this);

        c.add(rice);


        rrice = new JCheckBox("Basmati Rice");

        rrice.setBounds(150, 385, 200, 30);

        rrice.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(rrice);


        prrice = new JLabel("480 Tk");

        prrice.setBounds(150, 415, 150, 20);

        prrice.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(prrice);


        brice = new JComboBox<String>(a);

        brice.setBounds(150, 445, 70, 20);

        c.add(brice);


        nmrice = new JLabel("Kg");

        nmrice.setBounds(225, 445, 50, 20);

        nmrice.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(nmrice);


        oil = new JButton(oili);

        oil.setBounds(400, 175, 200, 200);

        oil.addActionListener(this);

        c.add(oil);


        roil = new JCheckBox("Mustard Oil");

        roil.setBounds(400, 385, 200, 30);

        roil.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(roil);


        proil = new JLabel("340 Tk");

        proil.setBounds(400, 415, 150, 20);

        proil.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(proil);


        boil = new JComboBox<String>(b);

        boil.setBounds(400, 445, 70, 20);

        c.add(boil);


        nmoil = new JLabel("Liter");
        nmoil.setBounds(475, 445, 50, 20);
        nmoil.setFont(new Font("Areal", Font.PLAIN, 15));
        c.add(nmoil);


        honeynuts = new JButton(honeynutsi);
        honeynuts.setBounds(650, 175, 200, 200);
        honeynuts.addActionListener(this);
        c.add(honeynuts);


        rhoneynuts = new JCheckBox("Honey Nut");
        rhoneynuts.setBounds(650, 385, 200, 30);
        rhoneynuts.setFont(new Font("Areal", Font.PLAIN, 15));
        c.add(rhoneynuts);


        prhoneynuts = new JLabel("950 Tk");
        prhoneynuts.setBounds(650, 415, 150, 20);
        prhoneynuts.setFont(new Font("Areal", Font.PLAIN, 15));
        c.add(prhoneynuts);


        bhoneynuts = new JComboBox<String>(d);
        bhoneynuts.setBounds(650, 445, 70, 20);
        c.add(bhoneynuts);


        nmhoneynuts = new JLabel("Kg");
        nmhoneynuts.setBounds(725, 445, 150, 20);
        nmhoneynuts.setFont(new Font("Areal", Font.PLAIN, 15));
        c.add(nmhoneynuts);


        setVisible(true);


    }


    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {

            new CustomerDashboard(f);

            setVisible(false);
        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double riceAmount = 0;
            double oilAmount = 0;
            double honeynutsAmount = 0;
            int a = 0;
            int b = 0;
            int c = 0;


            if (rrice.isSelected() == true) {
                a = (brice.getSelectedIndex()) + 1;
                riceAmount = a * 480;
            }
            if (roil.isSelected() == true) {
                b = boil.getSelectedIndex() + 1;
                oilAmount = b * 340;
            }
            if (rhoneynuts.isSelected() == true) {
                c = bhoneynuts.getSelectedIndex() + 1;
                honeynutsAmount = c * 950;
            }

            totalAmount = riceAmount +
                    oilAmount +
                    honeynutsAmount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?", " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "GroceryItem", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Rice--- " + a + " KG----" + riceAmount + " tk."
                                + "\nOil----" + b + " Litre---" + oilAmount + " tk."
                                + "\nhoneynuts---" + c + " Piece---" + honeynutsAmount + " tk."
                                + "\n" + totalAmount + " tk Total.");
                        file.close();

                    } catch (IOException io) {
                        JOptionPane.showMessageDialog(null, "An error Occured and failed to create the file");
                        io.printStackTrace();
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select something before placing order!", "Message", 0);
            }
        }

    }

}