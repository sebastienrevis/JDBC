package be.vdab;

import java.sql.*;

public class ConnectorTest {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/beersdb?serverTimezone=UTC","root",
                "e!48ru57SQ$0")) {
            System.out.println("Connection OK");

      }
        catch (Exception ex) {
            System.out.println("Something went wrong!");
            ex.printStackTrace(System.err);
    }
    }
}
