package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    String pin;
    JPasswordField p1 , p2;
    JButton b1,b2;
    Pin(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1400,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1450,750);
        add(image);

        JLabel l1 = new JLabel("CHANGE YOUR PIN");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Raleway",Font.BOLD,16));
        l1.setBounds(400,180,400,35);
        image.add(l1);

        JLabel l2 = new JLabel("New PIN :");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Raleway",Font.BOLD,16));
        l2.setBounds(400,220,150,35);
        image.add(l2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(176, 228, 230));
        p1.setForeground(Color.BLACK);
        p1.setFont(new Font("Raleway",Font.BOLD,16));
        p1.setBounds(550,220,220,25);
        image.add(p1);

        JLabel l3 = new JLabel("Re-Enter New PIN :");
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Raleway",Font.BOLD,16));
        l3.setBounds(400,250,400,35);
        image.add(l3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(176, 228, 230));
        p2.setForeground(Color.BLACK);
        p2.setFont(new Font("Raleway",Font.BOLD,16));
        p2.setBounds(550,255,220,25);
        image.add(p2);

        b1 = new JButton("CHANGE");
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
            String pin1 = p1.getText();
            String pin2 = p2.getText();

            if (!pin1.equals(pin2)){
                JOptionPane.showMessageDialog(null,"Entered Pin Does not Match");
                return;
            }if (e.getSource()==b1){
                if (p1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter New PIN");
                    return;
                } if (p2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                    return;
                }
                Conn c = new Conn();
                String q1 = "update banksystem.bank set pin ='"+pin1+"' where pin = '"+pin+"'";
                String q2 = "update banksystem.login set pin ='"+pin1+"' where pin = '"+pin+"'";
                String q3 = "update banksystem.signupthree set pin ='"+pin1+"' where pin = '"+pin+"'";
                c.statement.executeUpdate(q1);
                c.statement.executeUpdate(q2);
                c.statement.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN Change Successfully");
                setVisible(false);
                new main_Class(pin);
            } else if (e.getSource()==b2) {
                new main_Class(pin);
                setVisible(false);
            }
        }catch (Exception E){
            E.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Pin("");
    }
}
