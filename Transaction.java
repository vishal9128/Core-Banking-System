package Project.BankProject;

import org.xml.sax.helpers.ParserAdapter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {
    JButton deposit,fashCash,pinChange,cashWith,miniState,balEnq,exit,backbtnT;
    String pinNumber;
    Transaction(String pinNumber){
        this.pinNumber=pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/BankProject/mobile-banking.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,700);

        setLayout(null);
        setTitle("Transaction");
        getContentPane().setBackground(Color.BLACK);
        setLocation(500,10);

        JLabel title = new JLabel("Please select transaction type");
        title.setBounds(250,150,400,30);
        title.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,20));
        title.setForeground(Color.WHITE);
        add(title);


        //-------------Options Buttons----------------
        deposit = new JButton("Deposit");
        deposit.setBounds(160,250,180,30);
        deposit.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        deposit.setBorder(new EmptyBorder(10,10,10,10));
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        add(deposit);


        fashCash = new JButton("Fast Cash");
        fashCash.setBounds(160,300,180,30);
        fashCash.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        fashCash.setBorder(new EmptyBorder(10,10,10,10));
        fashCash.setForeground(Color.BLACK);
        fashCash.addActionListener(this);
        add(fashCash);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(160,350,180,30);
        pinChange.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        pinChange.setBorder(new EmptyBorder(10,10,10,10));
        pinChange.setForeground(Color.BLACK);
        pinChange.addActionListener(this);
        add(pinChange);


        //----------------Back button-------------
        backbtnT = new JButton("← Back");
        backbtnT.setBounds(160,400,180,30);
        backbtnT.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,20));
//        depobtn.setBackground(Color.BLACK);
        backbtnT.setBorder(new EmptyBorder(10,10,10,10));
        backbtnT.setForeground(Color.BLACK);
        backbtnT.addActionListener(this);
        add(backbtnT);

        cashWith = new JButton("Cash Withdraw");
        cashWith.setBounds(460,250,180,30);
        cashWith.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        cashWith.setBorder(new EmptyBorder(10,10,10,10));
        cashWith.setForeground(Color.BLACK);
        cashWith.addActionListener(this);
        add(cashWith);

        miniState = new JButton("Mini Statement");
        miniState.setBounds(460,300,180,30);
        miniState.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        miniState.setBorder(new EmptyBorder(10,10,10,10));
        miniState.setForeground(Color.BLACK);
        miniState.addActionListener(this);
        add(miniState);

        balEnq = new JButton("Balance Enquiry");
        balEnq.setBounds(460,350,180,30);
        balEnq.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        balEnq.setBorder(new EmptyBorder(10,10,10,10));
        balEnq.setForeground(Color.BLACK);
        balEnq.addActionListener(this);
        add(balEnq);

        exit = new JButton("Exit");
        exit.setBounds(460,400,180,30);
        exit.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        exit.setBorder(new EmptyBorder(10,10,10,10));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        add(exit);


        setSize(850,730);
        setVisible(true);
//        setUndecorated(true);             //title bar skip
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new FrontPage().setVisible(true);
        } else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if(ae.getSource() == cashWith) {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        } else if(ae.getSource() == fashCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if(ae.getSource() == pinChange){
            setVisible(false);
            new pinChange(pinNumber).setVisible(true);
        } else if(ae.getSource() == balEnq) {
            setVisible(false);
            new BalanceEqry("").setVisible(true);
        } else if(ae.getSource() == miniState){
            setVisible(true);
            new MiniStatement("").setVisible(true);
        } else if(ae.getSource() == backbtnT){
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Transaction("");
    }
}
