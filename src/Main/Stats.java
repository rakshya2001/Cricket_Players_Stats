package Main;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stats implements ActionListener {
    JFrame fr;
    JPanel pan;
    JLabel lbl_img, lbl_img1, lbl_MAT, lbl_Runs, lbl_Average, lbl_Century, lbl_Half_Century;
    JButton btn_update, btn_back;
    JTextField txt_MAT, txt_Runs, txt_Average, txt_Century, txt_Half_Century;
    ImageIcon image_premier, image2;
    Font fon1, fon2;
    String id;

    public Stats(String id) {
        this.id = id;
        System.out.println(id);

        fr = new JFrame("Stats");

        pan = new JPanel();
        pan.setBounds(0, 0, 800, 750);
        pan.setLayout(null);
        fr.add(pan);

        //Fonts
        fon1 = new Font("arial", Font.BOLD, 22);
        fon2 = new Font("arial", Font.BOLD, 15);

        //Headings

        lbl_MAT = new JLabel("MAT");
        lbl_MAT.setFont(fon1);
        lbl_MAT.setForeground(Color.darkGray);
        lbl_MAT.setBounds(50, 195, 100, 20);
        pan.add(lbl_MAT);

        lbl_Runs = new JLabel("Runs");
        lbl_Runs.setFont(fon1);
        lbl_Runs.setForeground(Color.darkGray);
        lbl_Runs.setBounds(200, 195, 100, 20);
        pan.add(lbl_Runs);

        lbl_Average = new JLabel("Average");
        lbl_Average.setFont(fon1);
        lbl_Average.setForeground(Color.darkGray);
        lbl_Average.setBounds(350, 195, 100, 20);
        pan.add(lbl_Average);

        lbl_Century = new JLabel("Century");
        lbl_Century.setFont(fon1);
        lbl_Century.setForeground(Color.darkGray);
        lbl_Century.setBounds(500, 195, 100, 20);
        pan.add(lbl_Century);

        lbl_Half_Century = new JLabel("Half Century");
        lbl_Half_Century.setFont(fon1);
        lbl_Half_Century.setForeground(Color.darkGray);
        lbl_Half_Century.setBounds(650, 195, 150, 20);
        pan.add(lbl_Half_Century);

        //Buttons
        btn_update = new JButton("update");
        btn_update.setFont(fon1);
        btn_update.setBounds(230, 300, 130, 50);
        btn_update.addActionListener(this);
        pan.add(btn_update);

        btn_back = new JButton("back");
        btn_back.setFont(fon1);
        btn_back.setBounds(400, 300, 130, 50);
        btn_back.addActionListener(this);
        pan.add(btn_back);

        String Player_ID=id;
        DbConnection db = new DbConnection();
        String query = "select * from Player_stats where Player_ID='" + Player_ID + "'";
        ResultSet rs = db.select(query);

        try {
            while (rs.next()) {

                //TextField
                txt_MAT = new JTextField(rs.getString("MAT"));
                txt_MAT.setFont(fon2);
                txt_MAT.setBounds(50, 230, 40, 25);
                txt_MAT.setBackground(new Color(245, 254, 255));
                txt_MAT.setBorder(new LineBorder(new Color(0, 0, 0),3));
                pan.add(txt_MAT);

                txt_Runs = new JTextField(rs.getString("Runs"));
                txt_Runs.setFont(fon2);
                txt_Runs.setBounds(200, 230, 40, 25);
                txt_Runs.setBackground(new Color(245, 254, 255));
                txt_Runs.setBorder(new LineBorder(new Color(0, 0, 0),3));
                pan.add(txt_Runs);

                txt_Average = new JTextField(rs.getString("Average"));
                txt_Average.setFont(fon2);
                txt_Average.setBounds(350, 230, 40, 25);
                txt_Average.setBackground(new Color(245, 254, 255));
                txt_Average.setBorder(new LineBorder(new Color(0, 0, 0),3));
                pan.add(txt_Average);

                txt_Century = new JTextField(rs.getString("Century"));
                txt_Century.setFont(fon2);
                txt_Century.setBounds(500, 230, 40, 25);
                txt_Century.setBackground(new Color(245, 254, 255));
                txt_Century.setBorder(new LineBorder(new Color(0, 0, 0),3));
                pan.add(txt_Century);

                txt_Half_Century = new JTextField(rs.getString("Half_Century"));
                txt_Half_Century.setFont(fon2);
                txt_Half_Century.setBounds(650, 230, 40, 25);
                txt_Half_Century.setBackground(new Color(245, 254, 255));
                txt_Half_Century.setBorder(new LineBorder(new Color(0, 0, 0),3));
                pan.add(txt_Half_Century);

            }


            //Image

            fr.setSize(815, 750);
            fr.setLayout(null);
            fr.setVisible(true);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btn_back){
            fr.dispose();
            new Homepage();
        }
        if (e.getSource() == btn_update) {
            try {
                String query = "update Player_stats set MAT='" + txt_MAT.getText() + "',"
                        + "Runs='" + txt_Runs.getText() + "',Average='" + txt_Average.getText() + "'"
                        + ",Century='" + txt_Century.getText() + "',Half_Century='" + txt_Half_Century.getText()  + "'where Player_ID = '"+id+"'";
                DbConnection db = new DbConnection();
                int rs = db.update(query);
                JOptionPane.showMessageDialog(btn_update, "Stats is Successfully Updated");
            } finally {

            }
        }
    }
}


