public class Utilisateur {
    private String nom;
    private double argent;

    public Utilisateur(String nom, double argent) {
        this.nom = nom;
        this.argent = argent;
    }

    public String getNom() {
        return nom;
    }

    public double getArgent() {
        return argent;
    }
    public void setArgent(double argent) {
        this.argent = argent;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void ajouterArgent(double montant) {
        if (montant > 0) {
            argent += montant;
            System.out.println(nom + " a ajouté " + montant + ". Nouveau solde: " + argent + "");
        } else {
            System.out.println("Montant invalide !");
        }
    }
    public void retirerArgent(double montant) throws ExceptionSoldeInsuffisant {
        if (montant <= 0) {
            System.out.println("Montant invalide !");
        } else if (montant > argent) {
            throw new ExceptionSoldeInsuffisant(nom + " ne peut pas retirer " + montant + "car le solde est insuffisant.");
        } else {
            argent -= montant;
            System.out.println(nom + " a retiré " + montant + "Nouveau solde: " + argent + "");
        }
    }
}