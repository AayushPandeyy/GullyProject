// Java program to implement
// a Simple Registration Form
// using Java Swing
package com.example.jdbc;

import javax.swing.*;
import java.sql.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class RegisterPage
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JPasswordField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel phnum;
    private JTextField phnumb;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;



    // constructor, to initialize the components
    // with default values.
    public RegisterPage() {
    	setLocationRelativeTo(null);
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 30);
        tname.setLocation(200, 100);
        c.add(tname);

        mno = new JLabel("Password");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        c.add(mno);

        tmno = new JPasswordField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 30);
        tmno.setLocation(200, 150);
        c.add(tmno);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 200);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 200);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 200);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        phnum = new JLabel("Phone Number");
        phnum.setFont(new Font("Arial", Font.PLAIN, 20));
        phnum.setSize(150, 20);
        phnum.setLocation(50, 250);
        c.add(phnum);

        phnumb = new JTextField();
        phnumb.setFont(new Font("Arial", Font.PLAIN, 15));
        phnumb.setSize(190, 30);
        phnumb.setLocation(200, 250);
        c.add(phnumb);



        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 300);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
        c.add(tadd);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data1;
                String data
                        = "Name : "
                        + tname.getText() + "\n"
                        + "Password : "
                        + tmno.getText() + "\n";
                if (male.isSelected()) {
                    data1 = "Gender : Male"
                            + "\n";
                } else {
                    data1 = "Gender : Female"
                            + "\n";
                }

                String data2 = "Phone Number: "+phnumb.getText()+"\n";
                String data3 = "Address : " + tadd.getText();
                tout.setText(data + data1 +data2+ data3);
                tout.setEditable(false);
                res.setText("Registration Successfully..");
            } else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        } else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            phnumb.setText(null);

            resadd.setText(def);
        }
        try {
            queryPass();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    Connection con;

    public void connect() throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/projectdb";
        String user = "root";
        String pass = "Iamaprogram";

        Class.forName(driver);

        con = DriverManager.getConnection(url, user, pass);
    }
    String sql;
    PreparedStatement pstm;

    private void queryPass() throws SQLException, ClassNotFoundException {
        connect();
        String uname = tname.getText();
        String pw = tmno.getText();
        String gen;
        if(male.isSelected()){
            gen = "Male";
        }else{
            gen = "Female";
        }
        String add = tadd.getText();
        String ph = phnumb.getText();
        connect();

        sql = "insert into reg(username,pass,gender,address,phnum) values(?,?,?,?,?)";
        pstm = con.prepareStatement(sql);
        pstm.setString(1, uname);
        pstm.setString(2, pw);
        pstm.setString(3,gen);
        pstm.setString(4, add);
        pstm.setString(5,ph);
        int i = pstm.executeUpdate();
        if(i==1){
            JOptionPane.showMessageDialog(null,"Registered Successfully.");
            this.dispose();
            new LoginPage().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Registration Failed.");
        }
        disconnect();

    }

    public void disconnect() throws SQLException {
        con.close();
    }


}

// Driver Code

