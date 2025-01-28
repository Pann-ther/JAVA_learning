public class Heure {
    private int heures;
    private int minutes;

    public Heure(int heures, int minutes) {
        if ((heures >= 0 && heures <= 23) && (minutes >= 0 && minutes <= 59)) {
            this.heures = heures;
            this.minutes = minutes;
        } else {
            throw new IllegalArgumentException("L'horaire sasise n'est pas valide");
        }
    }

    public int getHeures() {
        return heures;
    }

    public int getMinutes() {
        return minutes;
    }

    public String toString() {
        return String.format("%02d", heures) + ":" +String.format("%02d", minutes) ;
    }

    public void ajouterRetard(int retard) {
        int ajustementMinutes = 0;
        int ajustementHeures = 1;
        if ((retard + minutes) > 59) {
            ajustementMinutes = (retard + minutes) - 60;
            if (ajustementMinutes < 60) {
                minutes = ajustementMinutes;
                heures++;
            } else {
                while (ajustementMinutes > 60) {
                    ajustementMinutes -= 60;
                    ajustementHeures ++;
                }
                minutes = ajustementMinutes;
                heures+= ajustementHeures;
            }
        } else{
            minutes += retard;
        }
    }
}
