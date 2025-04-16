public class Lettre {
    private Adresse adresse;
    private double poids;
    private double timbre;

    public Lettre(Adresse adresse, double poids, double timbre){
        this.adresse = adresse;
        this.poids = poids;
        this.timbre = timbre;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public double getPoids() {
        return poids;
    }

    public double getTimbre() {
        return timbre;
    }

    public String toString(){
        return "Adresse: "+adresse.toString()+" Poids: "+poids+"kg Timbre: "+timbre;
    }
}
