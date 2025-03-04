public class CompteEpargne extends Compte {
    private double benefice;

    public CompteEpargne(int id, double solde, double benefice) {
        super(id, solde);
        this.benefice = benefice;
    }

    public double getBenefice() {
        return benefice;
    }

    public void setBenefice(double benefice) {
        this.benefice = benefice;
    }

    @Override
    public String toString() {
        return "CompteEpargne{id=" + getId() + ", solde=" + getSolde() + ", benefice=" + benefice + "}";
    }
}