public class CompteBancaire {
    private String titulaire;
    private double solde;
    private int numeroCompte;
    private static int nombreCompte = 0;

    public CompteBancaire(String titulaire){
        nombreCompte +=1;
        this.titulaire=titulaire;
        numeroCompte = nombreCompte;
    }

    public String getTitulaire(){
        return titulaire;
    }

    public int getNumeroCompte(){
        return numeroCompte;
    }

    public void setTitulaire(String titulaire){
        this.titulaire = titulaire;
    }

    public void deposer(double montant){
        solde += montant;
        System.out.println("Vous avez bien deposé "+montant+"€");
    }

    public void retirer(double montant){
        if (solde - montant < 0) {
            System.out.println("Vous ne pouvez pas effectuer de retrait, vous n'avez pas assez de fond sur votre compte");
        }else{
          solde -= montant;
        System.out.println("Vous avez bien retiré "+montant+"€");  
        }
        
    }

    public String afficherSolde(){
        return "Votre solde est de "+solde+"€";
    }

    public String toString(){
        return "Titulaire du compte: "+titulaire+", Numero de compte: "+numeroCompte;
    }


}
