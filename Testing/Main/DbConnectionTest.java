package Main;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class DbConnectionTest {

    @org.junit.Test
    public void insert() {

        String First_Name = "Rakshya";
        String Last_Name = "Bhatta";
        String Username = "Bhatta01";
        String Password = "852963";
        String Cpassword = "852963";
        String Gender = "Female";
        DbConnection db = new DbConnection();
        String query = "Insert into admin_tbl(First_Name,Last_Name,Username,Password,Cpassword,Gender) values('" + First_Name + "'" +
                ",'" + Last_Name + "','" + Username + "','" + Password + "','" + Cpassword + "','" + Gender + "')";
        int row = db.insert(query);
        assertEquals(1, row);


    }
    @org.junit.Test
    public void test_login() throws SQLException {
        String actual_email_val;
        String password_val;
        String Username = "Bhatta01";
        String Password = "852963";
        DbConnection db = new DbConnection();
        String query = "Select Username,Password from admin_tbl where Username='Bhatta01' and Password = '852963'";
        ResultSet rs = db.select(query);
        while (rs.next()) {
            actual_email_val = rs.getString("Username");
            password_val = rs.getString("Password");
            assertEquals(Username, actual_email_val);
            assertEquals(Password, password_val);
        }
    }
    @org.junit.Test
    public void delete() {
        DbConnection db = new DbConnection();
        String query = "Delete from admin_tbl where First_Name = 'Bhatta01'";
        int row = db.delete(query);
        assertEquals(1, row);
    }

    @org.junit.Test
    public void update() {
        DbConnection db = new DbConnection();
        String query = "Update admin_tbl SET First_Name = 'Rakshya_Test' where First_Name = 'Bhatta01'";
        int row = db.update(query);
        assertEquals(1, row);
    }

    @org.junit.Test
    public void select() throws SQLException {
        String result;
        String First_Name = "Bhatta01";
        DbConnection db = new DbConnection();
        String query = "Select First_Name from admin_tbl where First_Name='Bhatta01'";
        ResultSet rs = db.select(query);
        while (rs.next()) {
            result = rs.getString("First_Name");
            assertEquals(First_Name, result);
        }
    }
}