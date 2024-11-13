public class CompteBancaire {

    // Declaration des attributs de la classe compteBancaire
    private String numeroCompte;
    private String titulaire;
    private int solde;

    // Constructeur
    public CompteBancaire(String numeroCompte, String titulaire, int solde) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        setSolde(solde);
    }

    // Getter numeroCompte
    public String getNumeroCompte() {
        return numeroCompte;
    }

    // Getter et Setter titulaire
    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire){
        this.titulaire = titulaire;
    }

    // Getter et Setter solde
    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde){
        if(solde>=0){
            this.solde = solde;
        }else {
            System.out.println("Le solde ne peut etre negatif");
            System.out.println();
        }
    }

    // Methode pour afficher les attributs de l'objet
    public void releveCompte() {
        System.out.println("Numero de compte: " + numeroCompte);
        System.out.println("titulaire: " + titulaire );
        System.out.println("Solde: " + solde + "€");
        System.out.println();
    }
}
