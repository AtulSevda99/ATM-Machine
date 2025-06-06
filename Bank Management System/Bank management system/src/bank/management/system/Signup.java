package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {
    JRadioButton r1 , r2 , m1, m2;
    JTextField textName  , textFName, textEmail , textMs , textAdd ,textCT,textPin, textSt;
    JButton next;
    JDateChooser dateChooser;
    Random ran = new Random();
    long first4 = (ran.nextLong()%9000L)+1000L;
    String first = " " + Math.abs(first4);
    Signup(){
        super("Application Form");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25,10,100,100);
        add(image);

       JLabel label1 = new JLabel("Application Form No." + first);
       label1.setBounds(160,30,600,40);
       label1.setFont(new Font("Raleway",Font.BOLD,38));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330,80,600,30);
        label2.setFont(new Font("Raleway",Font.BOLD,22));
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(290,120,600,30);
        label3.setFont(new Font("Raleway",Font.BOLD,22));
        add(label3);

        JLabel labelName = new JLabel("Name :");
        labelName.setBounds(100,170,100,30);
        labelName.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelName);

        textName= new JTextField();
        textName.setFont(new Font("Raleway",Font.BOLD,14));
        textName.setBounds(300,170,400,30);
        add(textName);


        JLabel labelFName = new JLabel("Father's Name :");
        labelFName.setBounds(100,220,200,30);
        labelFName.setFont(new Font("Raleway",Font.BOLD,20));
        add(labelFName);

        textFName= new JTextField();
        textFName.setFont(new Font("Raleway",Font.BOLD,14));
        textFName.setBounds(300,220,400,30);
        add(textFName);

        JLabel DOB = new JLabel("Date of Birth :");
        DOB.setBounds(100,320,200,30);
        DOB.setFont(new Font("Raleway",Font.BOLD,20));
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105,105,105));
        dateChooser.setBounds(300,320,400,30);
        add(dateChooser);

        JLabel labelG = new JLabel("Gender :");
        labelG.setFont(new Font("Raleway",Font.BOLD,20));
        labelG.setBounds(100,270,200,30);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(new Color(222,255,228));
        r1.setBounds(300,270,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(new Color(222,255,228));
        r2.setBounds(450,270,90,30);
        add(r2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);

        JLabel labelEmail = new JLabel("E-mail Address");
        labelEmail.setFont(new Font("Raleway",Font.BOLD,20));
        labelEmail.setBounds(100,370,200,30);
        add(labelEmail);

        textEmail= new JTextField();
        textEmail.setFont(new Font("Raleway",Font.BOLD,14));
        textEmail.setBounds(300,370,400,30);
        add(textEmail);

        JLabel labelMs = new JLabel("Marital Status :");
        labelMs .setFont(new Font("Raleway",Font.BOLD,20));
        labelMs .setBounds(100,420,200,30);
        add(labelMs);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway",Font.BOLD,14));
        m1.setBackground(new Color(222,255,228));
        m1.setBounds(300,420,100,30);
        add(m1);

        m2 = new JRadioButton("Unmarried");
        m2.setFont(new Font("Raleway",Font.BOLD,14));
        m2.setBackground(new Color(222,255,228));
        m2.setBounds(450,420,100,30);
        add(m2);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(m1);
        buttonGroup1.add(m2);
        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Raleway",Font.BOLD,20));
        labelAdd.setBounds(100,470,200,30);
        add(labelAdd );

        textAdd= new JTextField();
        textAdd.setFont(new Font("Raleway",Font.BOLD,14));
        textAdd.setBounds(300,470,400,30);
        add(textAdd);

        JLabel labelCT = new JLabel("City :");
        labelCT.setFont(new Font("Raleway",Font.BOLD,20));
        labelCT.setBounds(100,520,200,30);
        add(labelCT );

        textCT= new JTextField();
        textCT.setFont(new Font("Raleway",Font.BOLD,14));
        textCT.setBounds(300,520,400,30);
        add(textCT);

        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setFont(new Font("Raleway",Font.BOLD,20));
        labelPin.setBounds(100,570,200,30);
        add(labelPin);

        textPin= new JTextField();
        textPin.setFont(new Font("Raleway",Font.BOLD,14));
        textPin.setBounds(300,570,400,30);
        add(textPin);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Raleway",Font.BOLD,20));
        labelState.setBounds(100,620,200,30);
        add(labelState);

        textSt= new JTextField();
        textSt.setFont(new Font("Raleway",Font.BOLD,14));
        textSt.setBounds(300,620,400,30);
        add( textSt);

        next = new JButton(" Next ");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,670,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(222,255,228));
        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     String formno = first;
     String name = textName.getText();
     String fname = textFName.getText();
     String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
     String gender = null;
     if (r1.isSelected()) {
      gender = "Male";
     } else if (r2.isSelected()) {
      gender = "Female";
     }
     String email = textEmail.getText();
     String marital = null;
     if (m1.isSelected()) {
      marital = "Married";
     } else if (m2.isSelected()) {
      marital = "Unmarried";
     }
     String address = textAdd.getText();
     String city = textCT.getText();
     String pincode = textPin.getText();
     String state = textSt.getText();

     try {
      if (textName.getText().equals("")) {
       JOptionPane.showMessageDialog(null, "Fill All The Fields");
      } else {
       Conn conn = new Conn();
       String q = " insert into banksystem.signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "' )";
       conn.statement.executeUpdate(q);
        new Signup2(formno);
        setVisible(false);
      }
     } catch (Exception E) {
      E.printStackTrace();
     }
    }
    public static void main(String[]args) {
         new Signup();
    }

}
