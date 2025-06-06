package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1450,750);
        add(image);

        JLabel l1 = new JLabel("ENTER AMOUNT YOU WANT TO DIPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setBounds(430,180,400,35);
        image.add(l1);

        textField = new TextField();
        textField.setBackground(new Color(176, 228, 230));
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Raleway",Font.BOLD,16));
        textField.setBounds(430,230,320,22);
        image.add(textField);

        b1 = new JButton("DEPOSIT");
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
        try {
            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource()==b1){
                if (textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter The Amount");
                }
                else{
                    Conn c = new Conn();
                    c.statement.executeUpdate("insert into banksystem.bank values('" + pin + "','" + date + "','Deposit','"+amount+"')");
                    JOptionPane.showMessageDialog(null,"Rs."+amount+" Deposited Successfully");
                    setVisible(false);
                    new main_Class(pin);
                }
            }
            else if (e.getSource()==b2){
                setVisible(false);
                new main_Class(pin);

            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
