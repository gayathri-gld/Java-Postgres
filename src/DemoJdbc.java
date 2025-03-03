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
//        Statement stmt = con.createStatement();



        /* 5.Execute statement*/
        String name = "David Rose";
        int id = 6;
        int marks = 40;
        String get_query = "SELECT * FROM student";
        String insert_query = "INSERT INTO student VALUES(5, 89, 'Potter')";
        String update_query = "UPDATE student SET marks = 80 WHERE name='Potter' ";
        String query = "INSERT INTO student VALUES(?, ?, ?)";
//        ResultSet rs = stmt.executeQuery(insert_query);
//        boolean result = stmt.execute(insert_query);

        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(3, name);
        stmt.setInt(2, marks);
        stmt.setInt(1, id);
        stmt.execute();

        /* 6.Process results*/
//        System.out.println(rs.next());
//        System.out.println(rs.getString("name"));
//        while (rs.next()) {
//            System.out.print(rs.getString(3) + " scored ");
//            System.out.println(rs.getInt(2));
//        }


        /* 7. Close*/
        con.close();
        System.out.println("Closed connection");
    }
}