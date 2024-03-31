package Project.BankProject;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage extends JFrame implements ActionListener {
    JTextField cardTextField, passTextField;
    JButton clear,signin,signup, exitL;

    LoginPage(){
        setLayout(null);
        setTitle("Login_Page");
        getContentPane().setBackground(Color.WHITE);
        setLocation(500,10);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Project/BankProject/bank-icon-logo.jpg"));
        Image i3 = i2.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel label = new JLabel(i4);
        label.setBounds(210,30,100,100);
        add(label);




        JLabel title = new JLabel("Core Banking System");
        title.setBounds(380,50,1300,50);
        title.setFont(new Font("RALEWAY",Font.BOLD,30));
        add(title);

        JLabel cardText = new JLabel("Card No:");
        cardText.setBounds(170,150,200,30);
        cardText.setFont(new Font("Railways",Font.BOLD, 30));
        add(cardText);

        cardTextField = new JTextField();
        cardTextField.setBounds(400,150,350,40);
        cardTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
//        cardTextField.setBorder(new EmptyBorder(10,10,10,10));
        add(cardTextField);

        JLabel pinText = new JLabel("PIN:");
        pinText.setBounds(170,250,200,30);
        pinText.setFont(new Font("Railways",Font.BOLD, 30));
        add(pinText);

        passTextField = new JPasswordField();
        passTextField.setBounds(400,250,350,40);
        passTextField.setFont(new Font("RALEWAY",Font.BOLD,20));
//        passTextField.setBorder(new EmptyBorder(10,10,10,10));
        add(passTextField);

        signin = new JButton("LOGIN");
        signin.setBounds(400,350,150,30);
        signin.setFont(new Font("RALEWAY", Font.BOLD, 15));
        signin.setBorder(new EmptyBorder(10,10,10,10));
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);

//        signin.addActionListener(this);
        add(signin);

        clear = new JButton("CLEAR");
        clear.setBounds(600,350,150,30);
        clear.setFont(new Font("RALEWAY", Font.BOLD, 15));
        clear.setBorder(new EmptyBorder(10,10,10,10));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(400,450,350,30);
        signup.setFont(new Font("RALEWAY",Font.BOLD,15));
        signup.setBorder(new EmptyBorder(10,10,10,10));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);


        //-------------Exit------------------
        exitL = new JButton("Exit");
        exitL.setBounds(400,500,350,30);
        exitL.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        exitL.setBorder(new EmptyBorder(10,10,10,10));
        exitL.setBackground(Color.BLACK);
        exitL.setForeground(Color.WHITE);
        exitL.addActionListener(this);
        add(exitL);


//        String[] str = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Aug","Nov","Dec"};
//        JComboBox month = new JComboBox(str);
//        month.setBounds(400,500,350,50);
//        month.setBorder(new EmptyBorder(10,10,10,10));
//        add(month);


        setSize(850,730);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==clear){
//            System.out.println("Hello");
//            cardTextField.setText("");
//            passTextField.setText("");
//        }else if(ae.getSource()==signin){
//
//        }else if(ae.getSource()==signup){
//            setVisible(false);
//            new SignUpPage().setVisible(true);
//        }

        if(ae.getSource() == exitL){
            setVisible(false);
            new FrontPage().setVisible(true);
        }


        try {
            if (ae.getSource() == signin) {
                ConnectionMaker cb = new ConnectionMaker();
                String cardnumber = cardTextField.getText();
                String pinNumber = passTextField.getText();
                String q = "select * from login where cardnumber = '" + cardnumber + "' and pinNumber = '" + pinNumber + "'";

                ResultSet rs = cb.s.executeQuery(q);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect card number or Pin");
                }
            } else if (ae.getSource() == clear) {
                System.out.println("Hello");
                cardTextField.setText("");
                passTextField.setText("");
            } else if (ae.getSource() == signup) {
                setVisible(false);
                new SignUpPage().setVisible(true);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new LoginPage().setVisible(true);
    }
}
