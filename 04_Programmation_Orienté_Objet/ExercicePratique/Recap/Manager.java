public class Manager extends Employe{
    private double prime;

    public Manager(String nom, double salaireBase, double prime){
        super(nom,salaireBase);
        this.prime = prime;
    }

    @Override
    public double calculerSalaire(){
        return salaireBase + prime;
    }

    public String toString(){
        return "Nom: "+nom+", Salaire: "+calculerSalaire();
    }


}