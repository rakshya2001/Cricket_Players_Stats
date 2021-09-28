package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Homepage implements ActionListener {
    JFrame fr;
    JPanel pan, pan2;
    JLabel lbl_img1,lbl_txt;
    JButton btn_addstd, btn_Update, btn_Logout;
    JTextField txt_id;
    ImageIcon  image_background;
    Font fon1, fon2;
    DefaultTableModel model;
    JTable std;

    public Homepage() {
        fr = new JFrame("Homepage");

        pan = new JPanel();
        pan.setBounds(0, 0, 800, 750);
        pan.setLayout(null);
        fr.add(pan);

        pan2 = new JPanel();
        pan2.setBounds(500, 220, 300, 100);
        pan2.setBackground(Color.white);
        pan2.setBorder(new LineBorder(new Color(0, 0, 0),4));
        pan2.setLayout(null);
        pan.add(pan2);

        //Fonts
        fon1 = new Font("arial", Font.BOLD, 22);
        fon2 = new Font("arial", Font.BOLD, 15);


        //Headings
        lbl_txt = new JLabel("Insert Your Id ");
        lbl_txt.setFont(fon1);
        lbl_txt.setForeground(Color.BLACK);
        lbl_txt.setBounds(25, 10, 200, 30);
        pan2.add(lbl_txt);

        //Text field
        txt_id = new JTextField();
        txt_id.setFont(fon1);
        txt_id.setBounds(30, 50, 70, 30);
        txt_id.setBorder(new LineBorder(new Color(0, 0, 0),1));
        pan2.add(txt_id);

        //Buttons
        btn_addstd = new JButton("Add Stats");
        btn_addstd.setFont(fon2);
        btn_addstd.setBounds(125, 40, 150, 40);
        btn_addstd.addActionListener(this);
        pan2.add(btn_addstd);

        btn_Logout = new JButton("Logout");
        btn_Logout.setFont(fon1);
        btn_Logout.setForeground(Color.white);
        btn_Logout.setBounds(665, 10, 120, 40);
        btn_Logout.setBackground(new Color(216, 33, 80));
        pan.add(btn_Logout);


        btn_Logout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Loginpage();
                fr.dispose();
            }
        });

        //Image



        Stats();
        image_background = new ImageIcon(getClass().getResource("rakshya.png"));
        lbl_img1 = new JLabel(image_background);
        lbl_img1.setBounds(0, 0, 850, 815);
        pan.add(lbl_img1);

        fr.setSize(850, 750);
        fr.setLayout(null);
        fr.setVisible(true);

    }
    public void Stats(){
        model= new DefaultTableModel();
        std= new JTable(model);
        fon1=new Font("Dialog", Font.BOLD, 22);
        fon1=new Font("Serif", Font.BOLD, 18);
        std.setFont(fon1);
        std.setRowHeight(65);
        std.setBackground(new Color(211,244,252));
        model.addColumn("MAT");
        model.addColumn("Runs");
        model.addColumn("Average");
        model.addColumn("Century");
        model.addColumn("Half Century");
        JTableHeader header = std.getTableHeader();
        header.setFont(fon1);
        header.setBackground(Color.white);
        header.setForeground(Color.darkGray);
        std.getTableHeader().setPreferredSize(new Dimension(30,53));
        try {
            DbConnection db=new DbConnection();
            String query="select * from Player_stats";
            ResultSet rs=db.select(query);
            DefaultTableModel model=(DefaultTableModel)std.getModel();
            model.setRowCount(0);
            int i=0;

            while(rs.next()){
                model.addRow(new Object[]{ rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6)});
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(std);
        pg.setBounds(285,320,515,380);
        pan.add(pg);
    }

    public static void main(String[] args) {
        new Homepage();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_Update){
            Stats();
        }
        if (e.getSource() == btn_addstd) {
            if (txt_id.getText().length()==0){
                JOptionPane.showMessageDialog(fr,"Insert ID First");
                return;
            }
            else {
                fr.dispose();
                new Stats(txt_id.getText());
            }

        }
    }
}
