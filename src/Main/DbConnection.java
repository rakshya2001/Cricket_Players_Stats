package Main;
import java.sql.*;

public class DbConnection {
    Connection myConn;
    Statement st;
    int val;
    ResultSet rows;
    public DbConnection() {
        String url = "jdbc:mysql://localhost:3306/stats";
        String user = "root";
        String password = "root";
        try {
            myConn = DriverManager.getConnection(url, user, password);
            if (myConn != null) {
                System.out.print("");
            } else {
                System.out.println("There is an error.");
            }
            st = myConn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int insert(String query) {
        try {
            val = st.executeUpdate(query);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return val;
    }
    public int delete(String query) {
        try {
            val = st.executeUpdate(query);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return val;
    }
    public int update(String query) {
        try {
            val = st.executeUpdate(query);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return val;
    }
    public ResultSet select(String query) {
        try {
            rows = st.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
}

