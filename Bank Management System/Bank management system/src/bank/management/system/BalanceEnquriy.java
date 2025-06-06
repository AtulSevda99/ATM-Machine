package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquriy extends JFrame implements ActionListener {
    JButton b1;
    JLabel l2;
    String pin;
    BalanceEnquriy(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1450,750);
        add(image);

        JLabel l1 = new JLabel("Your  Current Balance is Rs.");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setBounds(400,180,700,35);
        image.add(l1);

        l2 = new JLabel();
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        l2.setBounds(400,220,700,35);
        image.add(l2);

        b1 = new JButton("back");
        b1.setBackground(new Color(176, 228, 230));
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("Raleway",Font.BOLD,16));
        b1.setBounds(640,366,150,35);
        b1.addActionListener(this);
        image.add(b1);
         int balance = 0;
         try{
             Conn c = new Conn();
             ResultSet resultSet = c.statement.executeQuery("select * from banksystem.bank where pin = '"+pin+"'");
                while(resultSet.next()){
                        if (resultSet.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(resultSet.getString("amount"));
                        }else{
                            balance-=Integer.parseInt(resultSet.getString("amount"));
                        }
                }
         }catch (Exception e){
             e.printStackTrace();
         }
        l2.setText(""+balance);


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    setVisible(false);
    new main_Class(pin);
    }

    public static void main(String[] args) {
        new BalanceEnquriy("");
    }
}
