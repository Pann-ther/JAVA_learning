public class Developpeur extends Employe{
    private String langage;
    private double prime;

    public Developpeur(String nom, double salaireBase, String langage, double prime){
        super(nom,salaireBase);
        this.langage = langage;
        this.prime = prime;
    }

    @Override
    public double calculerSalaire(){
        return salaireBase + prime;
    }

    public String toString(){
        return "Nom: "+nom+", Salaire: "+calculerSalaire()+", Langage: "+langage;
        
    }

}