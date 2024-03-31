package Project.BankProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEqry extends JFrame implements ActionListener {
    String pinNumber;
    JButton backbtnBal, exitE;
    BalanceEqry(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setTitle("Balance Enquiry");
        setLocation(500,10);
        getContentPane().setBackground(Color.BLACK);


        //-------------Image------------------
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/BankProject/mobile-banking.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,700);


        //----------------Back button-------------
        backbtnBal = new JButton("← Back");
        backbtnBal.setBounds(420,450,150,30);
        backbtnBal.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,15));
        backbtnBal.setBorder(new EmptyBorder(10,10,10,10));
//        depobtn.setBackground(Color.BLACK);
        backbtnBal.setForeground(Color.BLACK);
        backbtnBal.addActionListener(this);
        add(backbtnBal);


        exitE = new JButton("Exit");
        exitE.setBounds(420,500,150,30);
        exitE.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        exitE.setBorder(new EmptyBorder(10,10,10,10));
        exitE.setForeground(Color.BLACK);
        exitE.addActionListener(this);
        add(exitE);


        int balance = 0;
        ConnectionMaker cb = new ConnectionMaker();
        try {
            ResultSet rs = cb.s.executeQuery("select * from bank where pinNumber = '" + pinNumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your current balance is Rs "+ balance);
        text.setBounds(220,150,400,30);
        text.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,20));
        text.setForeground(Color.WHITE);
        add(text);

        setSize(800,730);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(label);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == backbtnBal){
            setVisible(false);
            new Transaction("").setVisible(true);
        } else if(ae.getSource() == exitE){
            setVisible(false);
            new FrontPage().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEqry("");
    }
}
