import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompteDAO {
    public void ajouterCompte(Compte compte) throws SQLException {
        String sql = "INSERT INTO Compte (solde, benefice, banque_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, compte.getSolde());
            if (compte instanceof CompteEpargne) {
                pstmt.setDouble(2, ((CompteEpargne) compte).getBenefice());
            } else {
                pstmt.setNull(2, Types.DOUBLE);
            }
            pstmt.setInt(3, 1); // Exemple : banque_id = 1
            pstmt.executeUpdate();
        }
    }

    public List<Compte> listerComptes() throws SQLException {
        List<Compte> comptes = new ArrayList<>();
        String sql = "SELECT * FROM Compte";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                double solde = rs.getDouble("solde");
                double benefice = rs.getDouble("benefice");
                if (benefice > 0) {
                    comptes.add(new CompteEpargne(id, solde, benefice));
                } else {
                    comptes.add(new Compte(id, solde));
                }
            }
        }
        return comptes;
    }
}