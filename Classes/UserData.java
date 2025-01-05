package Classes;

import Interface.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserData extends JFrame implements ActionListener,IUserData 
{

    private JFrame frame;
    private JLabel label1;
    private JButton refresh;
    private JButton previous0;
    private JButton add;
    private JButton delete;
    private JButton exitButton;
    private JTable table;
    private DefaultTableModel model;
    private String[] column = {"User Name", "Password", "Email", "Date and Time"};
    private String[] rows = new String[8];
    private JScrollPane scroll;

    private String file = "data\\userdata.txt";
    private String temp = "data\\temp.txt";

    private User x;
    private Container c;

    public UserData(User a) 
	{
        x = a;

        frame = new JFrame("Ghorer Bazar-User Data");

        c = frame.getContentPane();
        c.setBackground(Color.WHITE);


        ImageIcon framelogo = new ImageIcon("Images/icon.png");
        ImageIcon previousImage = new ImageIcon("icons/previous.png");
        ImageIcon refreshImage = new ImageIcon("icons/refresh.png");
        ImageIcon deleteImage = new ImageIcon("icons/deleteuser.png");
        ImageIcon addImage = new ImageIcon("icons/adduser.png");
        ImageIcon exitImage = new ImageIcon("icons/exiticon.png");

        label1 = new JLabel();
        label1.setText("User Data");
        label1.setForeground(Color.black);
        label1.setFont(new Font("Forte", Font.PLAIN, 40));
        label1.setBounds(313, 0, 300, 60);
        frame.add(label1);


        table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);

        table.setModel(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        table.setSelectionBackground(Color.decode("#40E0D0"));
        table.setBackground(Color.decode("#E0FFFF"));
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);

        scroll = new JScrollPane(table);
        scroll.setBounds(150, 200, 700, 280);
        scroll.setBackground(Color.WHITE);
        frame.add(scroll);

        try 
		{

            BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null) 
			{
                totalLines++;
            }
            reader.close();

            for (int i = 0; i < totalLines; i++) 
			{
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
                if (x.equals("User")) {
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(12); // User Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(11); // Password
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(8); // Email
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(14); // Date and Time
                    model.addRow(rows);
                }
            }

        } catch (Exception ex) 
		{
            JOptionPane.showMessageDialog(null, "Something went horribly wrong!", "Warning!", 0);
            return;
        }

        refresh = new JButton("Refresh");
        refresh.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
        refresh.setBounds(572, 100, 130, 35);
        refresh.setFocusable(false);
        refresh.setBackground(Color.decode("#E0FFFF"));
        refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refresh.setBorder(BorderFactory.createEtchedBorder());
        refresh.setIcon(refreshImage);
        refresh.addActionListener(this);
        frame.add(refresh);


        add = new JButton("Add User");
        add.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
        add.setBounds(292, 100, 130, 35);
        add.setFocusable(false);
        add.setBackground(Color.decode("#E0FFFF"));
        add.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add.setBorder(BorderFactory.createEtchedBorder());
        add.setIcon(addImage);
        add.addActionListener(this);
        frame.add(add);


        delete = new JButton("Delete User");
        delete.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
        delete.setBounds(432, 100, 130, 35);
        delete.setFocusable(false);
        delete.setBackground(Color.decode("#E0FFFF"));
        delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        delete.setBorder(BorderFactory.createEtchedBorder());
        delete.setIcon(deleteImage);
        delete.addActionListener(this);
        frame.add(delete);


        previous0 = new JButton("Back");
        previous0.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
        previous0.setBounds(152, 100, 130, 35);
        previous0.setFocusable(false);
        previous0.setBackground(Color.decode("#E0FFFF"));
        previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
        previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        previous0.addActionListener(this);
        previous0.setIcon(previousImage);
        frame.add(previous0);


        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
        exitButton.setBounds(712, 100, 130, 35);
        exitButton.setFocusable(false);
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.setBackground(Color.decode("#E0FFFF"));
        exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        exitButton.setIcon(exitImage);
        exitButton.addActionListener(this);
        frame.add(exitButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 737);
        frame.setIconImage(framelogo.getImage());
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == refresh) 
		{
            frame.setVisible(false);
            new UserData(x);
        } else if (e.getSource() == delete) 
		{
            if (table.getSelectionModel().isSelectionEmpty()) 
			{
                JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                File oldFile = new File(file);
                File newFile = new File(temp);

                int q = 0;

                try 
				{

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i < totalLines; i++) {
                        String line = Files.readAllLines(Paths.get(file)).get(i);
                        String x = line.substring(0, 4);
                        if (x.equals("User")) {
                            String userName = Files.readAllLines(Paths.get(file)).get(i);
                            if (userName.substring(12).equals(removeUser)) {
                                q = i;
                            }
                        }
                    }
                } catch (Exception ex) 
				{
                    return;
                }
                try 
				{

                    FileWriter fw = new FileWriter(temp, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    int totalLines = 0;
                    while (reader.readLine() != null) 
					{
                        totalLines++;
                    }
                    reader.close();

                    for (int j = 0; j < totalLines; j++) 
					{
                        String line = Files.readAllLines(Paths.get(file)).get(j);
                        String x = line.substring(0, 4);

                        if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5))) {
                            String userName = Files.readAllLines(Paths.get(file)).get(j);
                            pw.println("#Removed! " + userName);
                        } else {
                            String userName = Files.readAllLines(Paths.get(file)).get(j);
                            pw.println(userName);
                        }
                    }
                    pw.flush();
                    pw.close();
                    fr.close();
                    br.close();
                    bw.close();
                    fw.close();

                } 
				catch (Exception ex) 
				{
                    System.out.print(ex);
                }

                oldFile.delete();
                File dump = new File(file);
                newFile.renameTo(dump);

                frame.setVisible(false);
                new UserData(x);

            }
        } else if (e.getSource() == add) 
		{
            frame.setVisible(false);
            new AdminAdd(x);

        } else if (e.getSource() == previous0) 
		{
            frame.setVisible(false);
            new AdminHome(x);

        } else if (e.getSource() == exitButton) 
		{
            System.exit(0);

        }

    }
}
