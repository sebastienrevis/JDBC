package be.vdab;

import java.sql.*;

public class BeersExercise06 {
    public static void main(String[] args) {

        String sql = "Select * from Beers where Alcohol = ?";

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC","root",
                "")) {
            System.out.println("Connection OK");

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setFloat(1, 5);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("Name");
                double alcohol = rs.getDouble("Alcohol");
                System.out.format("%s %s%n", name, alcohol);
            }
        }
        catch (Exception ex) {
            System.out.println("Something went wrong!");
            ex.printStackTrace(System.err);
    }
    }
}
