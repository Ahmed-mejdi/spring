import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BanqueDAO {
    public void ajouterBanque(Banque banque) throws SQLException {
        String sql = "INSERT INTO Banque (nom) VALUES (?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, banque.getNom());
            pstmt.executeUpdate();
        }
    }

    public List<Banque> listerBanques() throws SQLException {
        List<Banque> banques = new ArrayList<>();
        String sql = "SELECT * FROM Banque";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                banques.add(new Banque(id, nom));
            }
        }
        return banques;
    }
}