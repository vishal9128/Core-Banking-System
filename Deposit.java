package Project.BankProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField depoAmt;
    JButton depobtn,backbtn,exitD;
    String pinNumber;
    Deposit(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setTitle("Deposit");
        setLocation(500,10);
        getContentPane().setBackground(Color.BLACK);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/BankProject/mobile-banking.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,700);


        //----------------Title------------
        JLabel title = new JLabel("Enter the Amount you want to deposit");
        title.setBounds(220,150,400,30);
        title.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,20));
        title.setForeground(Color.WHITE);
        add(title);

        depoAmt = new JTextField();
        depoAmt.setBounds(220,200,360,30);
        depoAmt.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        add(depoAmt);


        //-----------------Deposit button--------------
        depobtn = new JButton("Deposit");
        depobtn.setBounds(420,400,150,30);
        depobtn.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,15));
        depobtn.setBorder(new EmptyBorder(10,10,10,10));
//        depobtn.setBackground(Color.BLACK);
        depobtn.setForeground(Color.BLACK);
        depobtn.addActionListener(this);
        add(depobtn);


        //----------------Back button-------------
        backbtn = new JButton("← Back");
        backbtn.setBounds(420,450,150,30);
        backbtn.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,15));
        backbtn.setBorder(new EmptyBorder(10,10,10,10));
//        depobtn.setBackground(Color.BLACK);
        backbtn.setForeground(Color.BLACK);
        backbtn.addActionListener(this);
        add(backbtn);


        exitD = new JButton("Exit");
        exitD.setBounds(420,500,150,30);
        exitD.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        exitD.setBorder(new EmptyBorder(10,10,10,10));
        exitD.setForeground(Color.BLACK);
        exitD.addActionListener(this);
        add(exitD);

        setSize(850,730);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == depobtn){
            String number = depoAmt.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please, enter the amount you want to deposit");
            } else {
                try{
                    ConnectionMaker cb = new ConnectionMaker();
                    String query = "insert into bank values ('"+pinNumber+"','"+date+"','Deposit','"+number+"')";
                    cb.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" deposited successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == backbtn){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == exitD){
            setVisible(false);
            new FrontPage().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
