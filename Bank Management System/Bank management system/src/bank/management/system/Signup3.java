package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton s,c;
    String formno;
    Signup3( String formno){
        this.formno = formno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150,5,100,100);
        add(image);

        JLabel l1 = new JLabel("Page 3");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(280,70,400,40);
        add(l2);

        JLabel l3 = new JLabel("Account Type :");
        l3.setFont(new Font("Raleway",Font.BOLD,18));
        l3.setBounds(100,120,200,30);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,18));
        r1.setBackground(new Color(186, 239, 155, 255));
        r1.setBounds(100,160,200,30);
        add(r1);

        r2 = new JRadioButton("Fixed-Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,18));
        r2.setBackground(new Color(186, 239, 155, 255));
        r2.setBounds(350,160,300,30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,18));
        r3.setBackground(new Color(186, 239, 155, 255));
        r3.setBounds(100,200,250,30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,18));
        r4.setBackground(new Color(186, 239, 155, 255));
        r4.setBounds(350,200,250,30);
        add(r4);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);


        JLabel l4 = new JLabel("Card Number :");
        l4.setFont(new Font("Raleway",Font.BOLD,18));
        l4.setBounds(100,250,200,30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16- Digit Card Number)");
        l5.setFont(new Font("Raleway",Font.BOLD,12));
        l5.setBounds(100,280,250,20);
        add(l5);

        JLabel l6 = new JLabel("xxxx-xxxx-xxxx-4841");
        l6.setFont(new Font("Raleway",Font.BOLD,18));
        l6.setBounds(330,250,250,30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on atm card/change Book and statement)");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(330,280,500,20);
        add(l7);

        JLabel l8 = new JLabel("PIN Number :");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,320,200,30);
        add(l8);
        JLabel l9 = new JLabel("xxxx");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(330,320,200,30);
        add(l9);

        JLabel l10 = new JLabel("(4-Digit Password)");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(100,360,250,20);
        add(l10);

        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,400,200,30);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(new Color(186, 239, 155, 255));
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,440,200,30);
        add(c1);

        c2 = new JCheckBox("Internet banking");
        c2.setBackground(new Color(186, 239, 155, 255));
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,440,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(186, 239, 155, 255));
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,480,200,30);
        add(c3);

        c4 = new JCheckBox("E-mail Alerts");
        c4.setBackground(new Color(186, 239, 155, 255));
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,480,200,30);
        add(c4);
        c5 = new JCheckBox("Cheque-Book");
        c5.setBackground(new Color(186, 239, 155, 255));
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,520,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(new Color(186, 239, 155, 255));
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,520,200,30);
        add(c6);

        JCheckBox c7 = new JCheckBox(" I here by decleares that the above entered details correct to the best of my knowledge.",true);
        c7.setBackground(new Color(186, 239, 155, 255));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,560,600,20);
        add(c7);

        JLabel l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway",Font.BOLD,14));
        l12.setBounds(700,10,100,30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway",Font.BOLD,14));
        l13.setBounds(760,10,60,30);
        add(l13);

        s = new JButton("Submit");
        s.setFont(new Font("Raleway",Font.BOLD,14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(250,620,100,30);
        s.addActionListener(this);
        add(s);
        c = new JButton("Cancel");
        c.setFont(new Font("Raleway",Font.BOLD,14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
        c.setBounds(420,620,100,30);
        c.addActionListener(this);
        add(c);

        setLayout(null);
        setSize(850,750);
        setLocation(400,20);
        getContentPane().setBackground(new Color(186, 239, 155, 255));
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String atype = null;
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed-Deposit Account";
        }else if (r3.isSelected()) {
            atype = "Current Account";
        }else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }
        Random ran = new Random();
        long first7 = (ran.nextLong()%90000000l)+1409963000000000L;
        String cardno = ""+Math.abs(first7);
        long first3 = (ran.nextLong()%9000L)+1000L;
        String pin = ""+Math.abs(first3);
        String fac ="";
        if (c1.isSelected()) {
            fac = fac+"ATM CARD";
        } else if (c2.isSelected()) {
            fac = fac+"Internet banking";
        }else if (c3.isSelected()) {
            fac = fac+"Mobile Banking";
        }else if (c4.isSelected()) {
            fac = fac+"E-mail Alerts";
        }else if (c5.isSelected()) {
            fac = fac+"Cheque-Book";
        }else if (c6.isSelected()) {
            fac = fac+"E-Statement";
        }
        try{
           if(e.getSource()==s){
               if(atype.equals("")){
                   JOptionPane.showMessageDialog(null,"Fill All The Fields");
               }else{
                   Conn c1 = new Conn();
                   String q1 = "insert into banksystem.signupthree values('" + formno + "','" + atype + "','" + cardno + "','" + pin + "','" + fac + "')";
                   String q2 = "insert into banksystem.login values('" + formno + "','" + cardno + "','" + pin + "')";
                   c1.statement.executeUpdate(q1);
                   c1.statement.executeUpdate(q2);
                   JOptionPane.showMessageDialog(null," Card Number : "+cardno+"\n  Pin : "+pin);
                   new Deposit(pin);
                   setVisible(false);
               }
           } else if (e.getSource()==c) {
               System.exit(0);
           }
        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup3(" ");
    }
}
