package be.vdab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BeersExercise02 {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC","root",
                "")) {
            System.out.println("Connection OK");

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = statement.executeQuery(
                    "select \n" +
                            "\tbe.Name BeerName,\n" +
                            "be.Alcohol AlcoholPercentage,\n" +
                            "be.Price Price,\n" +
                            "br.Name BrewerName,\n" +
                            "ca.Category Category\n" +
                            "from beers be\n" +
                            "join brewers br\n" +
                            "on be.BrewerId = br.Id\n" +
                            "join Categories ca\n" +
                            "on be.CategoryId = ca.Id\n" +
                            "where be.Alcohol>=10\n" +
                            "order by be.Alcohol desc");
            while(rs.next()){
                String beerName = rs.getString("BeerName");
                double alcohol = rs.getDouble("AlcoholPercentage");
                double price = rs.getDouble("Price");
                String category = rs.getString("Category");
                String brewerName = rs.getString("BrewerName");
                System.out.format("%s %s %s %s %s%n", beerName, alcohol+"%",
                        "€"+price, brewerName, category);
            }
            }
        catch (Exception ex) {
            System.out.println("Something went wrong!");
            ex.printStackTrace(System.err);
    }
    }
}
