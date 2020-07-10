package be.vdab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BeersExercise05 {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC","root",
                "")) {
            System.out.println("Connection OK");

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int rs = statement.executeUpdate(
                    "insert into beersdb.beers (Name, Alcohol, Price, Stock, BrewerId, CategoryId)\n" +
                            "values('MyBeer1', 1, 3, 100, 10, 22),\n" +
                            "('MyBeer2', 1, 5, 100, 10, 22),\n" +
                            "('MyBeer3', 1, 4, 100, 10, 22);");

            System.out.println(rs);
        }
        catch (Exception ex) {
            System.out.println("Something went wrong!");
            ex.printStackTrace(System.err);
    }
    }
}
