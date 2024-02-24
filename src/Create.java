import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    public static void createStep(Connection c, Step data) {
        try {
            String query = "INSERT INTO step (title, description, example, date) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = c.prepareStatement(query)) {
                ps.setString(1, data.getTitle());
                ps.setString(2, data.getDescription());
                ps.setString(3, data.getExample()); // Set the example value
                ps.setDate(4, new java.sql.Date(data.getDate().getTime()));

                ps.executeUpdate();
                System.out.println("Step created successfully!");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error creating step: " + ex.getMessage(), ex);
        }
    }

}
