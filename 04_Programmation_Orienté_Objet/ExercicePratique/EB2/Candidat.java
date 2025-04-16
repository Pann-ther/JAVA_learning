public class Candidat {
    private String nom;
    private String prenom;
    private String affiliation;
    private int voix;
    private boolean apresElection;

    public Candidat(String nom, String prenom, String affiliation){
        this.nom = nom;
        this.prenom = prenom;
        this.affiliation = affiliation;
        voix = 0;
        apresElection = false;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getVoix() {
        return voix;
    }

    public boolean getApresElection(){
        return apresElection;
    }

    public void election(int vote) {
        this.voix = vote;
        apresElection = true;
    }


    public String toString(){
        return "Nom: "+ nom + "; Prenom: "+prenom+"; Affiliation: "+affiliation+"; Nombre de voix: "+voix+"; Apres les elections: "+apresElection;
    }
}
