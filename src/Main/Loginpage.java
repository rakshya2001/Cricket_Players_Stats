package Main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Loginpage implements ActionListener {
    JFrame fr;
    JPanel pan, pan2;
    ImageIcon background;
    JLabel lbl_heading,lbl_account,lbl_Username,lbl_password, lbl_img;
    JTextField text_Username;
    JPasswordField txt_password;
    JButton btn_login,btn_QUIT,btn_reg;
    Font f1,f2;
    public Loginpage(){
        fr=new JFrame("Login Page");

        pan = new JPanel();
        pan.setBounds(120, 70, 430, 500);
        pan.setBackground(Color.white);
        pan.setBorder(new LineBorder(new Color(246, 99, 54),4));
        pan.setLayout(null);
        fr.add(pan);

        pan2 = new JPanel();
        pan2.setBounds(0, 0, 800, 700);
        pan2.setLayout(null);
        fr.add(pan2);

        //Fonts
        f1=new Font("arial",Font.BOLD,27);
        f2=new Font("arial",Font.BOLD,20);

        //Heading
        lbl_heading=new JLabel("ADMIN LOGIN");
        lbl_heading.setFont(f2);
        lbl_heading.setForeground(Color.BLACK);
        lbl_heading.setBounds(150,10,250,30);
        pan.add(lbl_heading);

        //Label
        lbl_Username= new JLabel("Username:");
        lbl_Username.setFont(f2);
        lbl_Username.setForeground(Color.BLACK);
        lbl_Username.setBounds(25,125,150,40);
        pan.add(lbl_Username);


        //label for password
        lbl_password=new JLabel("Password:");
        lbl_password.setFont(f2);
        lbl_password.setForeground(Color.BLACK);
        lbl_password.setBounds(25,245,125,40);
        pan.add(lbl_password);

        lbl_account=new JLabel("Create A New Account?");
        lbl_account.setFont(f2);
        lbl_account.setForeground(Color.BLACK);
        lbl_account.setBounds(30,430,210,40);
        pan.add(lbl_account);

        //TextField
        txt_password=new JPasswordField();
        txt_password.setFont(f2);
        txt_password.setBounds(140,250,250,35);
        pan.add(txt_password);

        text_Username=new JTextField();
        text_Username.setFont(f2);
        text_Username.setBounds(140,130,250,35);
        pan.add(text_Username);

        //Buttons
        btn_login=new JButton("Login");
        btn_login.setFont(f1);
        btn_login.setBounds(50,350,150,40);
        btn_login.addActionListener(this);
        pan.add(btn_login);

        btn_QUIT=new JButton("QUIT");
        btn_QUIT.setFont(f1);
        btn_QUIT.setBounds(220,350,150,40);
        btn_QUIT.addActionListener(this);
        pan.add(btn_QUIT);

        btn_reg=new JButton("Sign Up");
        btn_reg.setFont(f1);
        btn_reg.setBackground(Color.white);
        btn_reg.setForeground(Color.black);
        btn_reg.setBounds(235,435,150,30);
        btn_reg.addActionListener(this);
        pan.add(btn_reg);

        //Image



        fr.setSize(700,700);
        fr.setLayout(null);
        fr.setVisible(true);
    }


    public static void main(String[] args){

        new Loginpage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_reg){
            fr.dispose();
            new Register();
        }
        if (e.getSource()==btn_QUIT){
            fr.dispose();
        }

        if(e.getSource()==btn_login){
            String Username=text_Username.getText();
            String Password=txt_password.getText();
            String query="select * from admin_tbl where Username='"+Username+"'and Password='"+Password+"'";
            DbConnection db=new DbConnection();
            ResultSet rs=db.select(query);
            try {
                if(rs.next()){
                    JOptionPane.showMessageDialog(fr,"Login Successful");
                    new Homepage();
                    fr.dispose();

                }
                else{
                    JOptionPane.showMessageDialog(fr,"Given Username and Password is Invalid");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }

}

