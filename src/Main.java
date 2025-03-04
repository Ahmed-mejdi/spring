import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            BanqueDAO banqueDAO = new BanqueDAO();
            CompteDAO compteDAO = new CompteDAO();
            banqueDAO.ajouterBanque(new Banque(1, "Banque Centrale"));
            compteDAO.ajouterCompte(new CompteEpargne(1, 1000, 50));
            for (Compte compte : compteDAO.listerComptes()) {
                System.out.println(compte);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}