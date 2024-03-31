package Project.BankProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.xpath.XPathVariableResolver;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPage extends JFrame implements ActionListener {
    JButton lets;
    FrontPage(){
        setLayout(null);
        setTitle("Front_Page");
        getContentPane().setBackground(Color.WHITE);
        setLocation(500,10);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/BankProject/global-digital.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,700);


        lets = new JButton("Start Now → ");
        lets.setBounds(80,380,350,60);
        lets.setFont(new Font("RALEWAY",Font.BOLD,45));
        lets.setBorder(new EmptyBorder(10,10,10,10));
        lets.setBackground(Color.WHITE);
        lets.setForeground(Color.BLACK);
        lets.addActionListener(this);
        add(lets);

        setSize(850,730);
        setVisible(true);
        add(label);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == lets){
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }

    //-------------Main Class----------------
    public static void main(String[] args) {
        new FrontPage();
    }
}
