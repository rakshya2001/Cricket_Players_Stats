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
    JButton btn_Register, btn_Cancel;
    Font fon1, fon2;

    public Register() {
        fr = new JFrame("Registration Page");

        pan = new JPanel();
        pan.setBounds(90, 60, 490, 500);
        pan.setBackground(Color.white);
        pan.setBorder(new LineBorder(new Color(0, 0, 0),4));
        pan.setLayout(null);
        fr.add(pan);

        pan2 = new JPanel();
        pan2.setBounds(0, 0, 800, 700);
        pan2.setLayout(null);
        fr.add(pan2);

        String[] gender={" ","Male","Female","others"};

        //Fonts
        fon1 = new Font("arial", Font.BOLD, 22);
        fon2 = new Font("arial", Font.BOLD, 18);

        //Heading
        lbl_heading = new JLabel("Registration");
        lbl_heading.setFont(fon1);
        lbl_heading.setForeground(Color.BLACK);
        lbl_heading.setBounds(150, 10, 250, 40);
        pan.add(lbl_heading);

        //Labels
        lbl_fname = new JLabel("First Name:");
        lbl_fname.setFont(fon1);
        lbl_fname.setForeground(Color.BLACK);
        lbl_fname.setBounds(25, 50, 150, 40);
        pan.add(lbl_fname);

        lbl_lname = new JLabel("Last Name:");
        lbl_lname.setFont(fon1);
        lbl_lname.setForeground(Color.BLACK);
        lbl_lname.setBounds(25, 100, 150, 40);
        pan.add(lbl_lname);

        lbl_email = new JLabel("Username:");
        lbl_email.setFont(fon1);
        lbl_email.setForeground(Color.BLACK);
        lbl_email.setBounds(25, 150, 150, 40);
        pan.add(lbl_email);


        lbl_pass = new JLabel("Password:");
        lbl_pass.setFont(fon1);
        lbl_pass.setForeground(Color.BLACK);
        lbl_pass.setBounds(25, 200, 150, 40);
        pan.add(lbl_pass);

        lbl_cpass = new JLabel("Confirm Password:");
        lbl_cpass.setFont(fon1);
        lbl_cpass.setForeground(Color.BLACK);
        lbl_cpass.setBounds(15, 250, 200, 40);
        pan.add(lbl_cpass);

        lbl_gender = new JLabel("Gender:");
        lbl_gender.setFont(fon1);
        lbl_gender.setForeground(Color.BLACK);
        lbl_gender.setBounds(15, 300, 200, 40);
        pan.add(lbl_gender);


        //TextField
        txt_fname = new JTextField();
        txt_fname.setFont(fon2);
        txt_fname.setBounds(220, 50, 200, 40);
        pan.add(txt_fname);

        txt_lname = new JTextField();
        txt_lname.setFont(fon2);
        txt_lname.setBounds(220, 100, 200, 40);
        pan.add(txt_lname);

        txt_email = new JTextField();
        txt_email.setFont(fon2);
        txt_email.setBounds(220, 150, 200, 40);
        pan.add(txt_email);

        txt_pass = new JPasswordField();
        txt_pass.setFont(fon2);
        txt_pass.setBounds(220, 200, 200, 40);
        pan.add(txt_pass);

        txt_cpass = new JPasswordField();
        txt_cpass.setFont(fon2);
        txt_cpass.setBounds(220, 250, 200, 40);
        pan.add(txt_cpass);

        ComboBox=new JComboBox<String>(gender);
        ComboBox.setFont(fon2);
        ComboBox.setBounds(220, 300,200 , 40);
        pan.add(ComboBox);


        //Buttons
        btn_Register = new JButton("Sign Up");
        btn_Register.setFont(fon2);
        btn_Register.setBounds(70, 400, 150, 40);
        btn_Register.addActionListener(this);
        pan.add(btn_Register);

        btn_Cancel = new JButton("Cancel");
        btn_Cancel.setFont(fon2);
        btn_Cancel.setBounds(250, 400, 150, 40);
        btn_Cancel.addActionListener(this);
        pan.add(btn_Cancel);


        //Image
        background = new ImageIcon(getClass().getResource("bg.png"));
        lbl_img = new JLabel(background);
        lbl_img.setBounds(0, 0, 700, 700);
        pan2.add(lbl_img);


        fr.setSize(700, 700);
        fr.setLayout(null);
        fr.setVisible(true);
    }

    public static void main(String[] args) {
        new Register();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fulname = txt_fname.getText();
        String lastname = txt_lname.getText();
        String username = txt_email.getText();
        String pass = txt_pass.getText();
        String cpass = txt_cpass.getText();
        String gender = (String) ComboBox.getSelectedItem();

        if (e.getSource() == btn_Register) {
            DbConnection db = new DbConnection();
            String query = "insert into usr_tbl(fullname,lastname,username,pass,cpass,gender) " +
                    "values('" + fulname + "','" + lastname + "','" + username + "','" + pass + "','" + cpass + "','"+gender+"')";
            int ans = db.insert(query);
            if (ans > 0) {
                JOptionPane.showMessageDialog(fr, "Registration is completed successfully");
                fr.dispose();
                new Loginpage();
            }

        }

        if (e.getSource()==btn_Cancel){
            fr.dispose();
            new Loginpage();
        }
    }
}

