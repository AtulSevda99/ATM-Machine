package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    FastCash(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1450,750);
        add(image);

        JLabel l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System",Font.BOLD,20));
        l1.setBounds(430,180,700,35);
        image.add(l1);

        b1 = new JButton("Rs. 500");
        b1.setBackground(new Color(176, 228, 230));
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBounds(400,240,150,35);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs. 1000");
        b2.setBackground(new Color(176, 228, 230));
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBounds(590,240,200,35);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs. 5000");
        b3.setBackground(new Color(176, 228, 230));
        b3.setForeground(Color.BLACK);
        b3.setFont(new Font("Raleway",Font.BOLD,16));
        b3.setBounds(400,285,150,35);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs. 10000");
        b4.setBackground(new Color(176, 228, 230));
        b4.setForeground(Color.BLACK);
        b4.setFont(new Font("Raleway",Font.BOLD,16));
        b4.setBounds(590,285,200,35);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs. 20000");
        b5.setBackground(new Color(176, 228, 230));
        b5.setForeground(Color.BLACK);
        b5.setFont(new Font("Raleway",Font.BOLD,16));
        b5.setBounds(400,330,150,35);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs. 25000");
        b6.setBackground(new Color(176, 228, 230));
        b6.setForeground(Color.BLACK);
        b6.setFont(new Font("Raleway",Font.BOLD,16));
        b6.setBounds(590,330,200,35);
        b6.addActionListener(this);
        image.add(b6);

        b7 = new JButton("BACK");
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
    if(e.getSource()==b7){
        setVisible(false);
        new main_Class(pin);
    }else{
        String amount = ((JButton)e.getSource()).getText().substring(4);
        Conn c = new Conn();
        Date date = new Date();
        try{
            ResultSet resultSet = c.statement.executeQuery("select * from banksystem.bank where pin = '"+pin+"'");
            int balance = 0;
            while (resultSet.next()){
                if (resultSet.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(resultSet.getString("amount"));
                    }else{
                    balance-=Integer.parseInt(resultSet.getString("amount"));
                }
            }
            String num = "17";
            if (e.getSource()!=b7&&balance<Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null,"Insufficent Balance");
                return;
            }
            c.statement.executeUpdate("insert into banksystem.bank values('"+ pin + "','" + date + "','Withdrawl','" + amount + "')");
            JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
        }catch (Exception E){
            E.printStackTrace();
        }
        setVisible(false);
        new main_Class(pin);
    }
    }

    public static void main(String[] args) {
       new FastCash("");
    }
}
