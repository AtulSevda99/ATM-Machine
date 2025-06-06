package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Withdrawl( String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1450,750);
        add(image);

        JLabel l1 = new JLabel("MAXIMUM WITHDRAWL IS RS.25000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setBounds(430,180,700,35);
        image.add(l1);

        JLabel l2 = new JLabel("PLEASE ENTER YOUR AMMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        l2.setBounds(430,220,700,35);
        image.add(l2);

        textField = new TextField();
        textField.setBackground(new Color(176, 228, 230));
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Raleway",Font.BOLD,16));
        textField.setBounds(430,250,320,22);
        image.add(textField);

        b1 = new JButton("WITHDRAWL");
        b1.setBackground(new Color(176, 228, 230));
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBounds(640,325,150,35);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("BACK");
        b2.setBackground(new Color(176, 228, 230));
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("Raleway",Font.BOLD,16));
        b2.setBounds(640,370,150,35);
        b2.addActionListener(this);
        image.add(b2);



        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the ammount you want to withdraw");
                } else {
                    Conn c = new Conn();
                    ResultSet resultSet = c.statement.executeQuery("select * from banksystem.bank where pin = '"+pin+"'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                        if (balance < Integer.parseInt(amount)) {
                            JOptionPane.showMessageDialog(null, "Insufficent Balance");
                            return;
                        }
                        c.statement.executeUpdate("insert into banksystem.bank values('" + pin + "','" + date + "','Withdrawl','" + amount + "')");
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                        setVisible(false);
                        new main_Class(pin);

                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else if (e.getSource()==b2){
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
