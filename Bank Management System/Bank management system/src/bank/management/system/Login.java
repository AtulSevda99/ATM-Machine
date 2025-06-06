package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel label1 , label2,label3;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton B1,B2,B3;
    Login(){
        super("SBI Bank Management System ");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,10,100,100);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630,350,100,100);
        add(iimage);

        label1 = new JLabel("WELCOME TO ATM");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde",Font.BOLD,38));
        label1.setBounds(230,125,450,40);
        add(label1);

        label2 = new JLabel("Card No : ");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setBounds(150,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setForeground(Color.BLACK);
        textField2.setFont(new Font("Arial",Font.BOLD,14));
        textField2.setBounds(325,190,230,30);
        add(textField2);

        label3 = new JLabel("PIN : ");
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setForeground(Color.BLACK);
        label3.setBounds(150,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setForeground(Color.BLACK);
        passwordField3.setFont(new Font("Arial",Font.BOLD,14));
        passwordField3.setBounds(325,250,230,30);
        add(passwordField3);

        B1 = new JButton("SIGN IN ");
        B1.setForeground(Color.WHITE);
        B1.setBackground(Color.BLACK);
        B1.setFont(new Font("Arial",Font.BOLD,14));
        B1.setBounds(300,300,100,30);
        B1.addActionListener(this);
        add(B1);

        B2 = new JButton(" CLEAR ");
        B2.setForeground(Color.WHITE);
        B2.setBackground(Color.BLACK);
        B2.setFont(new Font("Arial",Font.BOLD,14));
        B2.setBounds(430,300,100,30);
        B2.addActionListener(this);
        add(B2);

        B3 = new JButton("SIGN UP ");
        B3.setForeground(Color.WHITE);
        B3.setBackground(Color.BLACK);
        B3.setFont(new Font("Arial",Font.BOLD,14));
        B3.setBounds(300,350,230,30);
        B3.addActionListener(this);
        add(B3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850,480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0,0,850,480);
        add(iiimage);


        setLayout(null);
        setSize(850,480);
        setLocation(450,200);
       // setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
           if (e.getSource() == B1){
                Conn c = new Conn();
                String cardno = textField2.getText();
                String pin = passwordField3.getText();
                String  q = "select * from banksystem.login where card_number = '"+cardno+"' and pin = '"+pin+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    setVisible(false);
                    new main_Class(pin);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
           } else if (e.getSource()== B2) {
               textField2.setText("");
               passwordField3.setText("");
           } else if (e.getSource()== B3) {
                new Signup();
                setVisible(false);
           }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}