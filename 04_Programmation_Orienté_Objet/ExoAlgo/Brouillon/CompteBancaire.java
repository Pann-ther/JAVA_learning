public class CompteBancaire {
    
    private int numeroCompte = 0;
    private String titulaire;
    private double solde;

    public CompteBancaire(String nom){
        titulaire = nom;
        solde = 0.0;
        numeroCompte +=1;
    }

    public int getNumeroCompte(){
        return numeroCompte;
    }

    public String getTitulaire(){
        return titulaire;
    }

    public double getSolde(){
        return solde;
    }
}
