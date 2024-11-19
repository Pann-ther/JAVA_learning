class Compte {
    private int solde = 0;
    private String titulaire;

    public Compte (String titulaire){
        this.titulaire = titulaire;
    }

    public void deposer(int montant) {
        solde = solde + montant;
    }

    public void retirer(int montant) {
        solde = solde - montant;
    }

    public int getSolde() {
        return solde;
    }

    public void virerVers(int montant, Compte destination) {
        this.retirer(montant);
        destination.deposer(montant);
    }

    public String toString() {
        return "solde: " + solde + ", titulaire: "+titulaire;
    }
}