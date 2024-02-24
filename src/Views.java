import java.sql.*;

public class Views {
    public static void getAllStep(Connection c) {
        try (
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery("SELECT * FROM step")) {

            ResultSetMetaData metaData = r.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (r.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String value = r.getString(columnName);
                    System.out.println(columnName + ": " + value);
                }
                System.out.println(); // separate rows
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
