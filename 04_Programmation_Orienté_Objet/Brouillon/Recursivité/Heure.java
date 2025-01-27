public class Heure {
    private int heures;
    private int minutes;
    public Heure(int heures, int minutes){
        if ((heures >= 0 && heures <= 23)&&(minutes >=0 && minutes <= 59)) {
            this.heures = heures;
            this.minutes = minutes;
        } else{
            throw new IllegalArgumentException("L'horaire sasise n'est pas valide");
        }
    }

    public int getHeures() {
        return heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public String toString(){
        return heures+":"+minutes;
    }
}
