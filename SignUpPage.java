package Project.BankProject;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignUpPage extends JFrame implements ActionListener {
//    Long random;
    JTextField nameTextField,fTextField,emailTextField,addTextField,cityTextField,stateTextField,pinTextField;
    JDateChooser dateTextField;
    JRadioButton male, female,married, unMarried, other;
    JButton next,exitS1;
    Random ran = new Random();
    Long random = Math.abs(ran.nextLong()%9000L + 1000L);
    SignUpPage(){
        setLayout(null);
        setTitle("PersonalDetails");
        setLocation(500,10);

//        Random ran = new Random();
//        random = Math.abs(ran.nextLong()%9000L + 1000L);
        JLabel title = new JLabel("APPLICATION FORM NO."+random);
        title.setBounds(200,50,500,30);
        title.setFont(new Font("RALEWAY",Font.BOLD,30));
        add(title);

        JLabel subtitle = new JLabel("Page 1:Personal Details");
        subtitle.setBounds(330,100,500,23);
        subtitle.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,17));
        add(subtitle);

        JLabel nameText = new JLabel("Name:");
        nameText.setBounds(150,150,200,20);
        nameText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(nameText);

        nameTextField = new JTextField();
        nameTextField.setBounds(350,150,380,30);
        nameTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        TextField.setBorder(new EmptyBorder(10,10,10,10));
        add(nameTextField);

        JLabel fText = new JLabel("Father's Name:");
        fText.setBounds(150,200,200,20);
        fText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(fText);

        fTextField = new JTextField();
        fTextField.setBounds(350,200,380,30);
        fTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        Text2Field.setBorder(new EmptyBorder(10,10,10,10));
        add(fTextField);

        JLabel text3 = new JLabel("Date of Birth:");
        text3.setBounds(150,250,200,20);
        text3.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(text3);

        dateTextField = new JDateChooser();
        dateTextField.setBounds(350,250,380,30);
        dateTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        Text3Field.setBorder(new EmptyBorder(10,10,10,10));
        add(dateTextField);

        JLabel text4 = new JLabel("Gender:");
        text4.setBounds(150,300,200,20);
        text4.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(text4);

        male = new JRadioButton("Male");
        male.setBounds(350,300,100,30);
        male.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(male);

        female = new JRadioButton("FeMale");
        female.setBounds(450,300,100,30);
        female.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(female);

        ButtonGroup radioBtn = new ButtonGroup();
        radioBtn.add(male);
        radioBtn.add(female);

        JLabel emailText = new JLabel("Email Address:");
        emailText.setBounds(150,350,200,20);
        emailText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(emailText);

        emailTextField = new JTextField();
        emailTextField.setBounds(350,350,380,30);
        emailTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        Text4Field.setBorder(new EmptyBorder(10,10,10,10));
        add(emailTextField);

        JLabel marriedText = new JLabel("Marital status:");
        marriedText.setBounds(150,400,200,20);
        marriedText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(marriedText);

        married = new JRadioButton("Married");
        married.setBounds(350,400,100,30);
        married.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(married);

        unMarried = new JRadioButton("Unmarried");
        unMarried.setBounds(450,400,130,30);
        unMarried.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(unMarried);

        other = new JRadioButton("Others");
        other.setBounds(580,400,100,30);
        other.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        add(other);

        ButtonGroup mode = new ButtonGroup();
        mode.add(married);
        mode.add(unMarried);
        mode.add(other);

        JLabel addText = new JLabel("Address:");
        addText.setBounds(150,450,200,20);
        addText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(addText);

        addTextField = new JTextField();
        addTextField.setBounds(350,450,380,30);
        addTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        Text5Field.setBorder(new EmptyBorder(10,10,10,10));
        add(addTextField);

        JLabel cityText = new JLabel("City:");
        cityText.setBounds(150,500,200,20);
        cityText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(cityText);

        cityTextField = new JTextField();
        cityTextField.setBounds(350,500,380,30);
        cityTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        Text6Field.setBorder(new EmptyBorder(10,10,10,10));
        add(cityTextField);

        JLabel stateText = new JLabel("State:");
        stateText.setBounds(150,550,200,20);
        stateText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(stateText);

        stateTextField = new JTextField();
        stateTextField.setBounds(350,550,380,30);
        stateTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        Text7Field.setBorder(new EmptyBorder(10,10,10,10));
        add(stateTextField);

        JLabel pinText = new JLabel("Pin Code:");
        pinText.setBounds(150,600,200,20);
        pinText.setFont(new Font("Railways",Font.CENTER_BASELINE, 20));
        add(pinText);

        pinTextField = new JTextField();
        pinTextField.setBounds(350,600,380,30);
        pinTextField.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
//        Text8Field.setBorder(new EmptyBorder(10,10,10,10));
        add(pinTextField);

        //next button
        next = new JButton("Next →");
        next.setBounds(700,650,100,30);
        next.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        next.setBorder(new EmptyBorder(10,10,10,10));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        exitS1 = new JButton("Exit");
        exitS1.setBounds(500,650,100,30);
        exitS1.setFont(new Font("RALEWAY",Font.CENTER_BASELINE,15));
        exitS1.setBorder(new EmptyBorder(10,10,10,10));
        exitS1.setBackground(Color.BLACK);
        exitS1.setForeground(Color.WHITE);
        exitS1.addActionListener(this);
        add(exitS1);


        setSize(850,730);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String sName = nameTextField.getText();
        String sFname = fTextField.getText();
        String sDOB = ((JTextField) (dateTextField).getDateEditor().getUiComponent()).getText();
        String sGender = null;
        if (male.isSelected()) {
            sGender = "Male";
        } else if (female.isSelected()) {
            sGender = "FeMale";
        }
        String sEmail = emailTextField.getText();
        String sMarried_Status = null;
        if (married.isSelected()) {
            sMarried_Status = "Married";
        } else if (unMarried.isSelected()) {
            sMarried_Status = "Unmarried";
        } else if (other.isSelected()) {
            sMarried_Status = "Others";
        }
        String sAddress = addTextField.getText();
        String sCity = cityTextField.getText();
        String sState = stateTextField.getText();
        String sPinCode = pinTextField.getText();

        if (sName.equals("")) {
            JOptionPane.showMessageDialog(null, "no");
        }

        //connectionBuilder class
        try {
            ConnectionMaker cb = new ConnectionMaker();
            String query = "insert into signup values('" + formno + "','" + sName + "','" + sFname + "','" + sDOB + "','" + sGender + "','" + sEmail + "','" + sMarried_Status + "','" + sAddress + "','" + sCity + "','" + sState + "','" + sPinCode + "')";
            PreparedStatement ps = cb.conn.prepareStatement(query);
            ps.executeUpdate();
            setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }

        if(ae.getSource()==next){
            setVisible(false);
            new SignUpPage2(formno).setVisible(true);
        } else if(ae.getSource() == exitS1){
            setVisible(false);
            new FrontPage().setVisible(true);
        }
    }



    //Main Method
    public static void main(String[] args) {
        new SignUpPage().setVisible(true);
    }
}
