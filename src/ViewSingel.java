import java.sql.*;

public class ViewSingel {
    public static Step getStepById(Connection c, int id){
        try(PreparedStatement ps = c.prepareStatement("Select * from step where id = ?")){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                String example = rs.getString("example");
                Date date = rs.getDate("date");
                return new Step(id, title, description, example, date);
            } else {
                System.out.println("Step with ID " + id + " not found.");
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error retrieving step: " + ex.getMessage(), ex);
        }
    }
}
