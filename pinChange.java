package Project.BankProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pinChange extends JFrame implements ActionListener {
    JTextField pinTextField, repinTextField;
    JButton pinbtn, backpinbtn, exitP;
    String pinNumber;
    pinChange(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setTitle("Pin Change");
        getContentPane().setBackground(Color.BLACK);
        setLocation(500,10);


        //----------Image-----------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/BankProject/mobile-banking.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,700);


        //----------------Title------------
        JLabel title = new JLabel("Pin Change");
        title.setBounds(320,150,400,30);
        title.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,20));
        title.setForeground(Color.WHITE);
        add(title);

        //-------------pin-----------
        JLabel pinText = new JLabel("New Pin");
        pinText.setBounds(220,200,150,30);
        pinText.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        pinText.setForeground(Color.WHITE);
        add(pinText);

        pinTextField = new JTextField();
        pinTextField.setBounds(400,200,200,30);
        pinTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        add(pinTextField);


        //------------re-pin----------------
        JLabel repinText = new JLabel("Re-Enter Pin");
        repinText.setBounds(220,250,200,30);
        repinText.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        repinText.setForeground(Color.WHITE);
        add(repinText);

        repinTextField = new JTextField();
        repinTextField.setBounds(400,250,200,30);
        repinTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        add(repinTextField);


        //-----------------pin btn--------------
        pinbtn = new JButton("Change");
        pinbtn.setBounds(440,400,150,30);
        pinbtn.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,15));
//        depobtn.setBackground(Color.BLACK);
        pinbtn.setForeground(Color.BLACK);
        pinbtn.addActionListener(this);
        add(pinbtn);


        //----------------Back button-------------
        backpinbtn = new JButton("← Back");
        backpinbtn.setBounds(440,450,150,30);
        backpinbtn.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,15));
//        depobtn.setBackground(Color.BLACK);
        backpinbtn.setForeground(Color.BLACK);
        backpinbtn.addActionListener(this);
        add(backpinbtn);


        exitP = new JButton("Exit");
        exitP.setBounds(440,500,150,30);
        exitP.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        exitP.setBorder(new EmptyBorder(10,10,10,10));
        exitP.setForeground(Color.BLACK);
        exitP.addActionListener(this);
        add(exitP);


        setSize(800,730);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pinbtn){
            try{
                String spin = pinTextField.getText();
                String srepin = repinTextField.getText();

                if(!spin.equals(srepin)){
                    JOptionPane.showMessageDialog(null,"Entered pin does not match.");
                    return;
                }
                if(spin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter pin");
                    return;
                }
                if(srepin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter pin");
                    return;
                }
                ConnectionMaker cb = new ConnectionMaker();
                String query1 = "update bank set pinNumber = '"+srepin+"' where pinNumber = '"+pinNumber+"'";
                String query2 = "update login set pinNumber = '"+srepin+"' where pinNumber = '"+pinNumber+"'";
                String query3 = "update signup3 set pinNumber = '"+srepin+"' where pinNumber = '"+pinNumber+"'";

                cb.s.executeUpdate(query1);
                cb.s.executeUpdate(query2);
                cb.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin Change successfully");

                setVisible(false);
                new Transaction(srepin).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        } else if(ae.getSource() == backpinbtn){
            setVisible(false);
            new Transaction("").setVisible(true);
        } else if(ae.getSource() == exitP){
            setVisible(false);
            new FrontPage().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new pinChange("");
    }
}
