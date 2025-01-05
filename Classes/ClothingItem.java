package Classes;



import java.awt.*;


import javax.swing.*;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class ClothingItem extends JFrame implements ActionListener {


    private Container c;


    private JButton shirt;

    private JButton pant;

    private JButton panjabi;


    private JButton back;

    private JButton order;


    private JLabel nmshirt;

    private JLabel prshirt;

    private JLabel nmpant;

    private JLabel prpant;

    private JLabel nmpanjabi;

    private JLabel prpanjabi;



    private JCheckBox rshirt;

    private JCheckBox rpant;

    private JCheckBox rpanjabi;


    private JComboBox<String> bshirt;

    private JComboBox<String> bpant;

    private JComboBox<String> bpanjabi;


    private String a[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private String b[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    private String d[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};


    private String f;


    public ClothingItem(String user) {

        ImageIcon framelogo     = new ImageIcon("Images/icon.png");
        setIconImage(framelogo.getImage());


        f = user;



        Icon shirti = new ImageIcon("Images/mensshirt.jpg");

        Icon panti = new ImageIcon("Images/menspant.jpg");

        Icon panjabii = new ImageIcon("Images/menspanjabi.jpg");


        setTitle("Ghorer Bazar-Clothing Item");

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




        shirt = new JButton(shirti);

        shirt.setBounds(150, 175, 200, 200);

        shirt.addActionListener(this);

        c.add(shirt);


        rshirt = new JCheckBox("Men's Shirt");

        rshirt.setBounds(150, 385, 200, 30);

        rshirt.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(rshirt);


        prshirt = new JLabel("1700 Tk");

        prshirt.setBounds(150, 415, 150, 20);

        prshirt.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(prshirt);


        bshirt = new JComboBox<String>(a);

        bshirt.setBounds(150, 445, 70, 20);

        c.add(bshirt);


        nmshirt = new JLabel("Peice");

        nmshirt.setBounds(225, 445, 50, 20);

        nmshirt.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(nmshirt);


        pant = new JButton(panti);

        pant.setBounds(400, 175, 200, 200);

        pant.addActionListener(this);

        c.add(pant);


        rpant = new JCheckBox("Men's Pant");

        rpant.setBounds(400, 385, 200, 30);

        rpant.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(rpant);


        prpant = new JLabel("2200 Tk");

        prpant.setBounds(400, 415, 150, 20);

        prpant.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(prpant);


        bpant = new JComboBox<String>(b);

        bpant.setBounds(400, 445, 70, 20);

        c.add(bpant);


        nmpant = new JLabel("Peice");

        nmpant.setBounds(475, 445, 50, 20);

        nmpant.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(nmpant);


        panjabi = new JButton(panjabii);

        panjabi.setBounds(650, 175, 200, 200);

        panjabi.addActionListener(this);

        c.add(panjabi);


        rpanjabi = new JCheckBox("Panjabi");

        rpanjabi.setBounds(650, 385, 200, 30);

        rpanjabi.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(rpanjabi);


        prpanjabi = new JLabel("2500 Tk");

        prpanjabi.setBounds(650, 415, 150, 20);

        prpanjabi.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(prpanjabi);


        bpanjabi = new JComboBox<String>(d);

        bpanjabi.setBounds(650, 445, 70, 20);

        c.add(bpanjabi);


        nmpanjabi = new JLabel("Peice");

        nmpanjabi.setBounds(725, 445, 150, 20);

        nmpanjabi.setFont(new Font("Areal", Font.PLAIN, 15));

        c.add(nmpanjabi);


        setVisible(true);


    }


    @Override

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {

            new CustomerDashboard(f);

            setVisible(false);

        } else if (e.getSource() == order) {
            double totalAmount = 0;
            double shirtamount = 0;
            double pantamount = 0;
            double panjabiamount = 0;
            int a = 0;
            int b = 0;
            int c = 0;


            if (rshirt.isSelected() == true) {
                a = (bshirt.getSelectedIndex()) + 1;
                shirtamount = a * 1700;
            }
            if (rpant.isSelected() == true) {
                b = bpant.getSelectedIndex() + 1;
                pantamount = b * 2200;
            }
            if (rpanjabi.isSelected() == true) {
                c = bpanjabi.getSelectedIndex() + 1;
                panjabiamount = c * 2500;
            }

            totalAmount = shirtamount +
                    pantamount +
                    panjabiamount;
            if (totalAmount != 0) {
                int x = JOptionPane.showConfirmDialog(null, "Your Bill = " + totalAmount + " tk. Confirm Order?", " Conformation of Oder", 0);
                if (x == 0) {
                    setVisible(false);
                    new Payment(totalAmount, "ClothingItem", f);

                    try {
                        File newfile = new File("data\\Last.txt");
                        newfile.createNewFile();
                        FileWriter file = new FileWriter("data\\Last.txt");

                        file.write("Shirt--- " + a + " Piece----" + shirtamount + " tk."
                                + "\npant----" + b + " Piece---" + pantamount + " tk."
                                + "\npanjabi---" + c + " Piece---" + panjabiamount + " tk."
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
