package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class Mini extends JFrame implements ActionListener {
    JButton button;
    String pin;
    Mini(String pin){
        this.pin = pin;
        setLayout(null);
        getContentPane().setBackground(new Color(233, 219, 234));
        setSize(400,600);
        setLocation(20,20);


        JLabel l1 = new JLabel();
        l1.setBounds(20,140,400,250);
        add(l1);

        JLabel l2 = new JLabel("Details Slip");
        l2.setFont(new Font("System",Font.BOLD,15));
        l2.setBounds(150,20,200,20);
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20,80,300,20);
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20,400,300,20);
        add(l4);


        try {
           Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from banksystem.login where pin = '"+pin+"'");
            while (resultSet.next()){
                l3.setText("Card Number : "+resultSet.getString("card_number").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_number").substring(12));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            int balance = 0;
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from banksystem.bank where pin = '"+pin+"'");
            while (resultSet.next()){
                l1.setText(l1.getText()+"<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+"<br><br><br><html>");


                if (resultSet.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(resultSet.getString("amount"));
                }else{
                    balance-=Integer.parseInt(resultSet.getString("amount"));
                }
            }

            l4.setText("Your Total Balance is Rs. "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }
        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener(this);
        add(button);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
