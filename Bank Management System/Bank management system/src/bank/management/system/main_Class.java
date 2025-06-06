package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    main_Class( String pin){
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1450,750);
        add(image);

        JLabel l1 = new JLabel("Please Select Your Transaction");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,20));
        l1.setBounds(430,180,700,35);
        image.add(l1);

        b1 = new JButton("DEPOSIT");
        b1.setBackground(new Color(176, 228, 230));
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBounds(400,240,150,35);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("CASH WITHDRAWL");
        b2.setBackground(new Color(176, 228, 230));
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBounds(590,240,200,35);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setBackground(new Color(176, 228, 230));
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Raleway",Font.BOLD,16));
        b3.setBounds(400,285,150,35);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setBackground(new Color(176, 228, 230));
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Raleway",Font.BOLD,16));
        b4.setBounds(590,285,200,35);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setBackground(new Color(176, 228, 230));
        b5.setForeground(Color.BLACK);
        b5.setFont(new Font("Raleway",Font.BOLD,16));
        b5.setBounds(400,330,150,35);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setBackground(new Color(176, 228, 230));
        b6.setForeground(Color.BLACK);
        b6.setFont(new Font("Raleway",Font.BOLD,16));
        b6.setBounds(590,330,200,35);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("EXIT");
        b7.setBackground(new Color(176, 228, 230));
        b7.setForeground(Color.BLACK);
        b7.setFont(new Font("Raleway",Font.BOLD,16));
        b7.setBounds(590,375,200,35);
        b7.addActionListener(this);
        image.add(b7);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            new Deposit(pin);
            setVisible(false);
        } else if (e.getSource()==b7) {
            System.exit(0);
        } else if (e.getSource()==b2) {
            new Withdrawl(pin);
            setVisible(false);
        }else if (e.getSource()==b6) {
            new BalanceEnquriy(pin);
            setVisible(false);
        }else if (e.getSource()==b3) {
            new FastCash(pin);
            setVisible(false);
        }else if (e.getSource()==b5) {
            new Pin(pin);
            setVisible(false);
        }else if (e.getSource()==b4) {
            new Mini(pin);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}
