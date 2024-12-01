public class Employés {
    protected String nom;
    protected String matricule;
    protected double indiceSalarial;
    protected static double salaireBase = 1500;
    protected double salaire;

    public Employés(String nom, String matricule, double indiceSalarial) {
        this.nom = nom;
        this.matricule = matricule;
        this.indiceSalarial = indiceSalarial;
    }

    public String getNom() {
        return nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public double getIndiceSalarial() {
        return indiceSalarial;
    }

    public double getSalaireBase() {
        return salaireBase;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setIndiceSalarial(double indiceSalarial) {
        this.indiceSalarial = indiceSalarial;
        calculerSalaire();
    }

    public void setSalaireBase(double salaireBase) {
        this.salaireBase = salaireBase;
            calculerSalaire();
    }

    public void calculerSalaire(){
        salaire = indiceSalarial * salaireBase;
    }

    public String toString() {
        return "Nom: " + nom + ", matricule: " + matricule + ", indice salarial: " + indiceSalarial
                + ", salaire de base: " + salaireBase + "€, salaire: "+salaire+"€";
    }

}
