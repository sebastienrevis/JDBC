package be.vdab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BeersExercise07 {
    public static void main(String[] args) {

        String sql1 = "update beersdb.beers set Stock = 75 where Name = 'MyBeer1";

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC", "root",
                "")) {
            System.out.println("Connection OK");

            //set Auto commit to false and start performing transactions
            con.setAutoCommit(false);

            PreparedStatement statement = con.prepareStatement(sql1);
            statement.setFloat(1, 5);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                double alcohol = rs.getDouble("Alcohol");
                System.out.format("%s %s%n", name, alcohol);
            }
                //commit the transactions
                con.commit();

                // set Auto commit back to true
                con.setAutoCommit(true);
            }

        catch(Exception ex){
                con.rollback();
                System.out.println("Something went wrong!");
                ex.printStackTrace(System.err);
            }
        }
    }
