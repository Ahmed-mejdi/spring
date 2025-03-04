import java.util.ArrayList;
import java.util.List;

public class GestionUtilisateurs {
    private List<Utilisateur> utilisateurs;

    public GestionUtilisateurs() {
        utilisateurs = new ArrayList<>();
    }
    public void ajouterUtilisateur(String nom, double argent) {
        utilisateurs.add(new Utilisateur(nom, argent));
        System.out.println("Utilisateur " + nom + " ajouté avec " + argent + "");
    }
    public Utilisateur trouverUtilisateur(String nom) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNom().equals(nom)) {
                return utilisateur;
            }
        }
        return null;
    }
}