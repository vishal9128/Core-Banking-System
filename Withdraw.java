package Project.BankProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField withAmt;
    JButton withbtn;
    JButton backbtnWith,exitW;
    String pinNumber;
    Withdraw(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setTitle("Withdrawal");
        setLocation(500,10);
        getContentPane().setBackground(Color.BLACK);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project/BankProject/mobile-banking.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0,0,900,700);


        //----------------Title------------
        JLabel title = new JLabel("Enter the Amount you want to withdraw");
        title.setBounds(220,150,400,30);
        title.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,20));
        title.setForeground(Color.WHITE);
        add(title);

        withAmt = new JTextField();
        withAmt.setBounds(220,200,360,30);
        withAmt.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,20));
        add(withAmt);

        //-----------------Withdraw button--------------
        withbtn = new JButton("Withdraw");
        withbtn.setBounds(420,400,150,30);
        withbtn.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,15));
//        depobtn.setBackground(Color.BLACK);
        withbtn.setBorder(new EmptyBorder(10,10,10,10));
        withbtn.setForeground(Color.BLACK);
        withbtn.addActionListener(this);
        add(withbtn);


        //----------------Back button-------------
        backbtnWith = new JButton("← Back");
        backbtnWith.setBounds(420,450,150,30);
        backbtnWith.setFont(new Font("RALEWAY", Font.CENTER_BASELINE,15));
//        depobtn.setBackground(Color.BLACK);
        backbtnWith.setBorder(new EmptyBorder(10,10,10,10));
        backbtnWith.setForeground(Color.BLACK);
        backbtnWith.addActionListener(this);
        add(backbtnWith);

        //-------------Exit------------------
        exitW = new JButton("Exit");
        exitW.setBounds(420,500,150,30);
        exitW.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        exitW.setBorder(new EmptyBorder(10,10,10,10));
        exitW.setForeground(Color.BLACK);
        exitW.addActionListener(this);
        add(exitW);

        setSize(850,730);
        setVisible(true);
        add(label);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withbtn){
            String number = withAmt.getText();
            Date date = new Date(System.currentTimeMillis());
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please, enter the amount you want to withdraw");
            } else {
                try{
                    ConnectionMaker cb = new ConnectionMaker();
                    String query = "insert into bank values ('"+pinNumber+"','"+date+"','Withdrawal','"+number+"')";
                    cb.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" withdrawal successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == backbtnWith){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == exitW){
            setVisible(false);
            new FrontPage().setVisible(true);
        }
    }



    public static void main(String[] args) {
        new Withdraw("");
    }
}
