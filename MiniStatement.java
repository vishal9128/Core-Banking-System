package Project.BankProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class MiniStatement extends JFrame implements ActionListener {
    JButton backMini;
    JLabel card;
    String pinNumber;
    MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;

        setLayout(null);
        setTitle("Mini statement");
        setLocation(500,10);
        getContentPane().setBackground(Color.WHITE);

        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel bank = new JLabel("State bank of India");
        bank.setBounds(110,20,250,20);
        bank.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,20));
//        bank.setForeground(Color.WHITE);
        add(bank);

        card = new JLabel();
        card.setBounds(20,80,300,20);
//        card.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,20));
        add(card);


        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);


        try{
            ConnectionMaker cb = new ConnectionMaker();
            ResultSet rs = cb.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
            //"select * from login where pinNumber = '"+pinNumber+"'"
            if (rs.next()){
                card.setText("Card Number " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
                return;
            }
            else {
                card.setText("No data found for the given PIN.");
            }
        } catch (Exception e){
            e.printStackTrace();
        }


        try {
            ConnectionMaker cb = new ConnectionMaker();
            int bal = 0;
            ResultSet rs = cb.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your Balance is Rs "+bal);
        } catch (Exception e){
            System.out.println(e);
        }

        //---------------back btn----------------
        backMini = new JButton("← Back");
        backMini.setBounds(200,450,150,30);
        backMini.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,15));
//        depobtn.setBackground(Color.BLACK);
        backMini.setForeground(Color.BLACK);
        backMini.addActionListener(this);
        add(backMini);

        setSize(400,730);
        setVisible(true);
//        setUndecorated(true);             //title bar skip
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transaction("").setVisible(true);
    }


    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
