package Project.BankProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class SignUpPage2 extends JFrame implements ActionListener{
    JComboBox relig,cate,income,edu;
    JTextField occupTextField,panTextField,adharTextField;
    JRadioButton yes,no,eyes,eno;
    JButton nextp2,exitS2,exitS21;
//    long random;
    String formno;
    JLabel l12,l13;
    SignUpPage2(String formno){


        setLayout(null);
        setTitle("PersonalDetails");
        setLocation(500,10);

        this.formno=formno;
        //-----------SubTitle-------------
        JLabel subtitlePage2 = new JLabel("Page 2:Additional Details");
        subtitlePage2.setBounds(330,100,500,30);
        subtitlePage2.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,22));
        add(subtitlePage2);


        //------------------Form no-------------------
        l12 = new JLabel("Form No:");
        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        l12.setBounds(650,10,60,30);
        add(l12);

        l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 13));
        l13.setBounds(710,10,60,30);
        add(l13);

        //----------Religion--------------
        JLabel religionText = new JLabel("Religion:");
        religionText.setBounds(150,150,200,23);
        religionText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(religionText);

        String[] str = {" ","Hindu","Muslim","Sikh","Jain","Yahudi"};
        relig = new JComboBox(str);
        relig.setBounds(400,150,350,30);
//        month.setBorder(new EmptyBorder(10,10,10,10));
        add(relig);


        //-------------Category--------------
        JLabel categoryText = new JLabel("Category:");
        categoryText.setBounds(150,200,200,23);
        categoryText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(categoryText);

        String[] str1 = {" ","General","OBC","SC","ST"};
        cate = new JComboBox(str1);
        cate.setBounds(400,200,350,30);
//        month.setBorder(new EmptyBorder(10,10,10,10));
        add(cate);

        //-------------Income------------
        JLabel incomeText = new JLabel("Income:");
        incomeText.setBounds(150,250,200,23);
        incomeText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(incomeText);

        String[] str2 = {" ","100000","200000","500000","5 Lakh above"};
        income = new JComboBox(str2);
        income.setBounds(400,250,350,30);
//        month.setBorder(new EmptyBorder(10,10,10,10));
        add(income);


        //-------------Educational qualification---------------
        JLabel eduText = new JLabel("Education:");
        eduText.setBounds(150,300,200,23);
        eduText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(eduText);

        String[] str3 = {" ","Graduate","Post-Graduate","Diploma","Non-Matric"};
        edu = new JComboBox(str3);
        edu.setBounds(400,300,350,30);
//        month.setBorder(new EmptyBorder(10,10,10,10));
        add(edu);


        //---------------Occupation--------------
        JLabel occupText = new JLabel("Occupation:");
        occupText.setBounds(150,350,200,23);
        occupText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(occupText);

        occupTextField = new JTextField();
        occupTextField.setBounds(400,350,350,30);
        occupTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        TextField.setBorder(new EmptyBorder(10,10,10,10));
        add(occupTextField);


        //--------------Pan number-----------------
        JLabel panText = new JLabel("Pan Number:");
        panText.setBounds(150,400,200,23);
        panText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(panText);

        panTextField = new JTextField();
        panTextField.setBounds(400,400,350,30);
        panTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        TextField.setBorder(new EmptyBorder(10,10,10,10));
        add(panTextField);


        //------------Adhar Card Number----------------------
        JLabel adharText = new JLabel("Adhar Card:");
        adharText.setBounds(150,450,200,23);
        adharText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(adharText);

        adharTextField = new JTextField();
        adharTextField.setBounds(400,450,350,30);
        adharTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        TextField.setBorder(new EmptyBorder(10,10,10,10));
        add(adharTextField);


        //-----------------Senior citizen-----------------
        JLabel senText = new JLabel("Senior Citizen:");
        senText.setBounds(150,500,200,23);
        senText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(senText);

        yes = new JRadioButton("Yes");
        yes.setBounds(400,500,100,30);
        yes.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(550,500,100,30);
        no.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(no);

        ButtonGroup senCiti = new ButtonGroup();
        senCiti.add(yes);
        senCiti.add(no);


        //---------------Exisiting Account--------------------
        JLabel existText = new JLabel("Exisiting Account:");
        existText.setBounds(150,550,200,23);
        existText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(existText);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(400,550,100,30);
        eyes.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(550,550,100,30);
        eno.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(eno);

        ButtonGroup exi = new ButtonGroup();
        exi.add(eyes);
        exi.add(eno);


        //---------------Next-----------------
        nextp2 = new JButton("Next →");
        nextp2.setBounds(650,650,100,30);
        nextp2.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        nextp2.setBorder(new EmptyBorder(10,10,10,10));
        nextp2.setBackground(Color.BLACK);
        nextp2.setForeground(Color.WHITE);
        nextp2.addActionListener(this);
        add(nextp2);


        exitS2 = new JButton("Exit");
        exitS2.setBounds(500,650,100,30);
        exitS2.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        exitS2.setBorder(new EmptyBorder(10,10,10,10));
        exitS2.setBackground(Color.BLACK);
        exitS2.setForeground(Color.WHITE);
        exitS2.addActionListener(this);
        add(exitS2);


        exitS21 = new JButton("← Back");
        exitS21.setBounds(350,650,100,30);
        exitS21.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        exitS21.setBorder(new EmptyBorder(10,10,10,10));
        exitS21.setBackground(Color.BLACK);
        exitS21.setForeground(Color.WHITE);
        exitS21.addActionListener(this);
        add(exitS21);


        setSize(850,730);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //-----------ActionEvent-------------------
    public void actionPerformed(ActionEvent ae){
//        String sformno = " " + random;
        String sReligion = (String) relig.getSelectedItem();
        String sCategory = (String) cate.getSelectedItem();
        String sIncome = (String) income.getSelectedItem();
        String sEducation = (String) edu.getSelectedItem();
        String sOccupation = occupTextField.getText();
        String sPanNum = panTextField.getText();
        String sAadhar = adharTextField.getText();
        String sSeniorCiti = null;
        if(yes.isSelected()){
            sSeniorCiti= "Yes";
        } else if(no.isSelected()){
            sSeniorCiti="No";
        }
        String sExistingCust = null;
        if(eyes.isSelected()){
            sExistingCust="Yes";
        } else if(eno.isSelected()){
            sExistingCust="No";
        }

        //-------------Aadhar require-----------
        if (sAadhar.equals("")) {
            JOptionPane.showMessageDialog(null, "no");
        }

        //-------------connection-----------------------
        try{
            ConnectionMaker cb = new ConnectionMaker();
            String query = "insert into signup2 values('"+formno+"','"+sReligion+"','"+sCategory+"','"+sIncome+"','"+sEducation+"','"+sOccupation+"','"+sPanNum+"','"+sAadhar+"','"+sSeniorCiti+"','"+sExistingCust+"')";
            PreparedStatement ps = cb.conn.prepareStatement(query);
            ps.executeUpdate();
            setVisible(false);

//            new SignUpPage2("").setVisible(false);



        } catch (Exception e){
            System.out.println(e);
        }
        if(ae.getSource()==nextp2){
            setVisible(false);
            new SignUpPage3(formno).setVisible(true);
        }
        else if(ae.getSource() == exitS2){
            setVisible(false);
            new FrontPage().setVisible(true);
        }
        else if(ae.getSource() == exitS21){
            setVisible(false);
            new SignUpPage().setVisible(true);
        }


    }


    //---------------Main Class-------------
    public static void main(String[] args) {
        new SignUpPage2(" ").setVisible(true);
    }

}
