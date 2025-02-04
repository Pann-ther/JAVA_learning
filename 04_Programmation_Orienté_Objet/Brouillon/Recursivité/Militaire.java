public class Militaire {
    private String grade;
    private String nom;
    private Militaire superieur;

    public Militaire(String grade,String nom, Militaire superieur){
        this.grade = grade;
        this.nom = nom;
        this.superieur = superieur;
    }

    public String getGrade() {
        return grade;
    }
    public String getNom() {
        return nom;
    }
    public Militaire getSuperieur() {
        return this.superieur;
    }

    public int nbSuperieur(Militaire m){
        if (m == null) {
            return 0;
        }
        return 1+nbSuperieur(m.getSuperieur());
    }

    public String toString(){
        return "Grade: "+grade+", Nom: "+nom+", Superieur: "+ superieur.getNom()+", "+superieur.getGrade();
    }
}
