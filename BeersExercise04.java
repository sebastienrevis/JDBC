package be.vdab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BeersExercise04 {
    public static void main(String[] args) {

        String sql = "update beersdb.beers set Stock = 60 where Name like '%kriek%";

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC","root",
                "")) {
            System.out.println("Connection OK");

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int rs = statement.executeUpdate(sql);

            System.out.println(rs);
        }
        catch (Exception ex) {
            System.out.println("Something went wrong!");
            ex.printStackTrace(System.err);
    }
    }
}
