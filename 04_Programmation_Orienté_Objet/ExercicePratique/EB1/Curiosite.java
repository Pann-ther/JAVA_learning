public class Curiosite {
    private String intitule;
    private int kilometre;
    private Curiosite suivante;

    public Curiosite(String i, int k, Curiosite c) {
        intitule = i;
        kilometre = k;
        suivante = c;
    }

    public void afficherCuriosite() {
        System.out.println(this.toString());
        if (this.suivante != null) {
            suivante.afficherCuriosite();
        }
    }

    public boolean ordreCuriosite(){
        if (this.suivante == null) {
            return true;
        }

        if(this.kilometre > suivante.kilometre){
            return false;
        }

        return suivante.ordreCuriosite();


        
    }

    public String toString() {
        return "Nom: " + intitule + "; Kilometre: " + kilometre;
    }
}