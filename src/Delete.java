import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void deleteStep(Connection c, int id) {
        try {
            String query = "Delete from step where id =" + id ;

            try (PreparedStatement ps = c.prepareStatement(query)) {


                ps.executeUpdate();
                System.out.println("Step Deleted successfully!" + id);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error deleting step: " + ex.getMessage(), ex);
        }
    }
}
