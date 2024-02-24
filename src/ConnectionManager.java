import java.sql.*;

public class ConnectionManager {
    public static Connection connect() {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://localhost/javaLean?serverTimezone=UTC",
                    "root",
                    "");

            System.out.println("Connection successful :) ");
            return c;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
