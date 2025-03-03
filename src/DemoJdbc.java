/* 1.Import packages*/
import java.sql.*;

public class DemoJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /* 2.Load and register*/
        Class.forName("org.postgresql.Driver");

        /* 3.Create connection*/
        String url = "jdbc:postgresql://localhost:5432/demo";
        String username = "postgres";
        String password = "Minnaminni@2000";
        Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to PostgreSQL database");


        /* 4.Create statement*/
        Statement stmt = con.createStatement();


        /* 5.Execute statement*/
        String query = "SELECT * FROM student";
        ResultSet rs = stmt.executeQuery(query);


        /* 6.Process results*/
//        System.out.println(rs.next());
//        System.out.println(rs.getString("name"));
        while (rs.next()) {
            System.out.print(rs.getString(3) + " scored ");
            System.out.println(rs.getInt(2));
        }


        /* 7. Close*/
        con.close();
        System.out.println("Closed connection");
    }
}