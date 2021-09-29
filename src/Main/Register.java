package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class Register implements ActionListener {
    JFrame fr;
    JPanel pan, pan2;
    ImageIcon background;
    JLabel lbl_heading, lbl_fname, lbl_lname, lbl_email, lbl_pass, lbl_cpass, lbl_gender, lbl_img;
    JTextField txt_fname, txt_lname, txt_email;
    JPasswordField txt_pass, txt_cpass;
    JComboBox<String> ComboBox;
    JButton btn_Register, btn_Back;
    Font f1, f2;

    public Register() {
        fr = new JFrame("Registration Page");

        pan = new JPanel();
        pan.setBounds(90, 60, 490, 500);
        pan.setBackground(Color.white);
        pan.setBorder(new LineBorder(new Color(246, 99, 54),4));
        pan.setLayout(null);
        fr.add(pan);

        pan2 = new JPanel();
        pan2.setBounds(0, 0, 800, 700);
        pan2.setLayout(null);
        fr.add(pan2);

        String[] gender={" ","Male","Female","others"};

        //Fonts
        f1 = new Font("arial", Font.BOLD, 22);
        f2 = new Font("arial", Font.BOLD, 18);

        //Heading
        lbl_heading = new JLabel("Admin Registration");
        lbl_heading.setFont(f1);
        lbl_heading.setForeground(Color.BLACK);
        lbl_heading.setBounds(150, 10, 250, 40);
        pan.add(lbl_heading);

        //Labels
        lbl_fname = new JLabel("First Name:");
        lbl_fname.setFont(f1);
        lbl_fname.setForeground(Color.BLACK);
        lbl_fname.setBounds(25, 50, 150, 40);
        pan.add(lbl_fname);

        lbl_lname = new JLabel("Last Name:");
        lbl_lname.setFont(f1);
        lbl_lname.setForeground(Color.BLACK);
        lbl_lname.setBounds(25, 100, 150, 40);
        pan.add(lbl_lname);

        lbl_email = new JLabel("Username:");
        lbl_email.setFont(f1);
        lbl_email.setForeground(Color.BLACK);
        lbl_email.setBounds(25, 150, 150, 40);
        pan.add(lbl_email);


        lbl_pass = new JLabel("Password:");
        lbl_pass.setFont(f1);
        lbl_pass.setForeground(Color.BLACK);
        lbl_pass.setBounds(25, 200, 150, 40);
        pan.add(lbl_pass);

        lbl_cpass = new JLabel("Confirm Password:");
        lbl_cpass.setFont(f1);
        lbl_cpass.setForeground(Color.BLACK);
        lbl_cpass.setBounds(15, 250, 200, 40);
        pan.add(lbl_cpass);

        lbl_gender = new JLabel("Gender:");
        lbl_gender.setFont(f1);
        lbl_gender.setForeground(Color.BLACK);
        lbl_gender.setBounds(15, 300, 200, 40);
        pan.add(lbl_gender);


        //TextField
        txt_fname = new JTextField();
        txt_fname.setFont(f2);
        txt_fname.setBounds(220, 50, 200, 40);
        pan.add(txt_fname);

        txt_lname = new JTextField();
        txt_lname.setFont(f2);
        txt_lname.setBounds(220, 100, 200, 40);
        pan.add(txt_lname);

        txt_email = new JTextField();
        txt_email.setFont(f2);
        txt_email.setBounds(220, 150, 200, 40);
        pan.add(txt_email);

        txt_pass = new JPasswordField();
        txt_pass.setFont(f2);
        txt_pass.setBounds(220, 200, 200, 40);
        pan.add(txt_pass);

        txt_cpass = new JPasswordField();
        txt_cpass.setFont(f2);
        txt_cpass.setBounds(220, 250, 200, 40);
        pan.add(txt_cpass);

        ComboBox=new JComboBox<String>(gender);
        ComboBox.setFont(f2);
        ComboBox.setBounds(220, 300,200 , 40);
        pan.add(ComboBox);


        //Buttons
        btn_Register = new JButton("Sign Up");
        btn_Register.setFont(f2);
        btn_Register.setBounds(70, 400, 150, 40);
        btn_Register.addActionListener(this);
        pan.add(btn_Register);

        btn_Back = new JButton("Back");
        btn_Back.setFont(f2);
        btn_Back.setBounds(250, 400, 150, 40);
        btn_Back.addActionListener(this);
        pan.add(btn_Back);


        //Image


        fr.setSize(700, 700);
        fr.setLayout(null);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        new Register();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String First_Name = txt_fname.getText();
        String Last_Name = txt_lname.getText();
        String Username = txt_email.getText();
        String Password = txt_pass.getText();
        String Cpassword = txt_cpass.getText();
        String Gender = (String) ComboBox.getSelectedItem();

        if (e.getSource() == btn_Register) {
            DbConnection db = new DbConnection();
            String query = "insert into admin_tbl(First_Name,Last_Name,Username,Password,Cpassword,Gender) " +
                    "values('" + First_Name + "','" + Last_Name + "','" + Username + "','" + Password + "','" + Cpassword + "','"+Gender+"')";
            int ans = db.insert(query);
            if (ans > 0) {
                JOptionPane.showMessageDialog(fr, "Registration is completed successfully");
                fr.dispose();
                new Loginpage();
            }

        }

        if (e.getSource()==btn_Back){
            fr.dispose();
            new Loginpage();
        }
    }
}

