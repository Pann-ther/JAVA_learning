public class LaDate {
    private int jour;
    private int mois;
    private int annee;

    public LaDate(int j, int m, int a) {
        this.jour = j;
        this.mois = m;
        this.annee = a;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public String toString() {
        return jour + "/" + mois + "/" + annee;
    }
}
