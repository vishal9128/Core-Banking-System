package Project.BankProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.*;

public class SignUpPage3 extends JFrame implements ActionListener {
    JRadioButton saveRadio,fda,currentRadio,rda;
    JCheckBox atmCard,mobBank,checkbook,internet,emailSms,eState;
    JButton submit,cancel;
    String formno;
    long random;
    JLabel l11, l12;
    SignUpPage3(String formno){
        this.formno=formno;

        setLayout(null);
        setTitle("PersonalDetails");
        setLocation(500,10);


        //--------------Form no.----------------
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(650,10,70,30);
        add(l11);

        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(710,10,40,30);
        add(l12);


        //-----------SubTitle-------------
        JLabel subtitlePage3 = new JLabel("Page 3:Account Details");
        subtitlePage3.setBounds(300,50,500,30);
        subtitlePage3.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,22));
        add(subtitlePage3);


        //---------------Acount Type-----------------
        JLabel accountText = new JLabel("Account Type:");
        accountText.setBounds(120,100,500,25);
        accountText.setFont(new Font("Railways",Font.CENTER_BASELINE, 22));
        add(accountText);

        saveRadio = new JRadioButton("Saving Account");
        saveRadio.setBounds(120,130,200,30);
        saveRadio.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(saveRadio);

        fda = new JRadioButton("Fixed Deposit Account");
        fda.setBounds(450,130,500,30);
        fda.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(fda);

        currentRadio = new JRadioButton("Current Account");
        currentRadio.setBounds(120,160,200,30);
        currentRadio.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(currentRadio);

        rda = new JRadioButton("Recurring Deposit Account");
        rda.setBounds(450,160,500,30);
        rda.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(rda);

        ButtonGroup accountType = new ButtonGroup();
        accountType.add(saveRadio);
        accountType.add(fda);
        accountType.add(currentRadio);
        accountType.add(rda);


        //---------------Card Number-------------
        JLabel cardText = new JLabel("Card Number:");
        cardText.setBounds(120,210,500,25);
        cardText.setFont(new Font("Railways",Font.CENTER_BASELINE, 22));
        add(cardText);

        JLabel cardDigText = new JLabel("Your 16 digit card number");
        cardDigText.setBounds(130,240,500,12);
        cardDigText.setFont(new Font("Railways",Font.CENTER_BASELINE, 10));
        add(cardDigText);

        JLabel cardNumText = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNumText.setBounds(430,210,500,25);
        cardNumText.setFont(new Font("Railways",Font.CENTER_BASELINE, 22));
        add(cardNumText);


        //-------------Pin--------------
        JLabel pinText = new JLabel("PIN:");
        pinText.setBounds(120,280,500,25);
        pinText.setFont(new Font("Railways",Font.CENTER_BASELINE, 22));
        add(pinText);

        JLabel cardPassText = new JLabel("Your 4 digit Password");
        cardPassText.setBounds(130,305,500,12);
        cardPassText.setFont(new Font("Railways",Font.CENTER_BASELINE, 10));
        add(cardPassText);

        JLabel cardPinText = new JLabel("XXXX");
        cardPinText.setBounds(430,280,500,25);
        cardPinText.setFont(new Font("Railways",Font.CENTER_BASELINE, 22));
        add(cardPinText);


        //---------------Services--------------
        JLabel serviceText = new JLabel("Service Required:");
        serviceText.setBounds(120,340,500,25);
        serviceText.setFont(new Font("Railways",Font.CENTER_BASELINE, 22));
        add(serviceText);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setBounds(120,380,300,30);
        atmCard.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(atmCard);

        mobBank = new JCheckBox("Mobile Banking");
        mobBank.setBounds(120,420,300,30);
        mobBank.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(mobBank);

        checkbook = new JCheckBox("Cheque Book");
        checkbook.setBounds(120,460,300,30);
        checkbook.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(checkbook);

        internet = new JCheckBox("Internet Banking");
        internet.setBounds(450,380,300,30);
        internet.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(internet);

        emailSms = new JCheckBox("Email & SMS Alert");
        emailSms.setBounds(450,420,300,30);
        emailSms.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(emailSms);

        eState = new JCheckBox("E-Statement");
        eState.setBounds(450,460,300,30);
        eState.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(eState);


        //--------------final Statement---------------
        JCheckBox statement = new JCheckBox("I hereby declare that the above enter details are correct to the best  of my knowledge.");
        statement.setBounds(120,520,700,30);
        statement.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,12));
        add(statement);


        //---------------submit------------------------
        submit = new JButton("Submit");
        submit.setBounds(300,600,100,30);
        submit.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        submit.setBorder(new EmptyBorder(10,10,10,10));
        submit.addActionListener(this);
        add(submit);


        //-----------------Cancel--------------------
        cancel = new JButton("Cancel");
        cancel.setBounds(450,600,100,30);
        cancel.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        cancel.setBorder(new EmptyBorder(10,10,10,10));
        cancel.addActionListener(this);
        add(cancel);



        setSize(850,730);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String sformno = " "+random;
            String sAcccountType = null;
            if(saveRadio.isSelected()){
                sAcccountType="Saving Account";
            } else if(fda.isSelected()){
                sAcccountType="Fixed Deposit Account";
            } else if(currentRadio.isSelected()){
                sAcccountType="Current Account";
            } else if(rda.isSelected()){
                sAcccountType="Recurring Deposit Account";
            }

            Random random = new Random();
            String cardNumber = " "+Math.abs((random.nextLong() % 900L))+5040936000000L;
            String pinNumber = " "+Math.abs((random.nextLong() %90L))+10L;

            String service = "";
            if(atmCard.isSelected()){
                service = service+"ATM Card";
            }
            if(mobBank.isSelected()){
                service = service+"Mobile Banking";
            }
            if(checkbook.isSelected()){
                service = service+"Check Book";
            }
            if(internet.isSelected()){
                service = service+"Internet Banking";
            }
            if(emailSms.isSelected()){
                service = service+"Email & SMS Alert";
            }
            if(eState.isSelected()){
                service = service+"E-Statement";
            }

            try{
                if(sAcccountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is compulsory");

                } else {
                    ConnectionMaker cb = new ConnectionMaker();
                    String query1 = "insert into signup3 values('"+formno+"','"+sAcccountType+"','"+cardNumber+"','"+pinNumber+"','"+service+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"')";
                    PreparedStatement ps1 = cb.conn.prepareStatement(query1);
                    PreparedStatement ps2 = cb.conn.prepareStatement(query2);
                    ps1.executeUpdate();
                    ps2.executeUpdate();

                    JOptionPane.showMessageDialog(null,"card Number"+cardNumber+"\n Pin:"+pinNumber);
                    setVisible(false);

                    new SignUpPage3(formno).setVisible(false);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(false);
                }
            } catch (Exception e){
                System.out.println(e);
            }
        } else if(ae.getSource() == cancel){
                setVisible(false);
                new LoginPage().setVisible(true);
        }
    }

    //------------------Main class----------------
    public static void main(String[] args) {
        new SignUpPage3("");
    }
}
