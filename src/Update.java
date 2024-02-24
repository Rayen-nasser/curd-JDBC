import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public static void updateStep(Connection c, Step step) {
        try (PreparedStatement ps = c.prepareStatement("UPDATE step SET title = ?, description = ?, example = ? WHERE id = ?")) {
            ps.setString(1, step.getTitle());
            ps.setString(2, step.getDescription());
            ps.setString(3, step.getExample());
            ps.setInt(4, step.getId());
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Step updated successfully.");
            } else {
                System.out.println("No step found with ID " + step.getId());
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error updating step: " + ex.getMessage(), ex);
        }
    }
}
