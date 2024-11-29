import java.util.Scanner;
public class OccupationSalle {
    static Scanner scan = new Scanner(System.in);

    // Affiche si la salle est occupé en fonction du jour et des plages horaires
    public static void afficherDisponibilité(boolean[][] t, String[] jour, String[] horaire) {
        for (int i = 0; i < t.length; i++) {
            System.out.println("Disponibilité " + jour[i]);
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j]) {
                    System.out.println("la salle est occupé de " + horaire[j]);
                } else {
                    System.out.println("La salle est libre de " + horaire[j]);
                }
            }
            System.out.println();
        }
    }

    // Calcul le taux d'occupation de la salle
    public static void tauxOccupation(boolean[][] t) {
        double occupation = 0;
        double nbPlage = 0;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                nbPlage++;
                if (t[i][j]) {
                    occupation++;
                }
            }
        }
        double taux = (occupation / nbPlage) * 100;
        System.out.println("Le taux d'occupation de la salle est de " + String.format("%.2f", taux) + "%");
    }

    public static void reservation(boolean[][] t, String[] jour, String[] horaire) {
        int indexJour = rechercheIndex(jour, "Quelle jour voulez vous reserver la salle? (lundi/mardi/mercredi/jeudi/vendredi): ", 
        "Vous n'avez pas entré le bon jour de la semaine");
        int indexHoraire = rechercheIndex(horaire, "Sur quel créneau voulez vous reserver la salle? (de 8H-9H à 18H-19H): ", 
        "Vous n'avez pas entré le bon créneau horaire");
        if (t[indexJour][indexHoraire]) {
            System.out.println("La salle est occupé, vous ne pouvez pas reserver la salle");
        } else {
            System.out.println("La salle est libre, le créneau a été reservé");

        }
    }

    public static int rechercheIndex(String[] tab, String msg, String msgErreur) {
        String input="";
        int index = 0;
        boolean correct = false;
        do {
            input = lireString(msg);
            for (int i = 0; i < tab.length; i++) {
                if (input.equalsIgnoreCase(tab[i])) {
                    index = i;
                    correct = true;
                    return index;
                }
            }
            System.out.println(msgErreur);
        } while (!correct);
        return index;
    }

    public static String lireString(String msg){
        boolean correct;
        String input="";
        do{
            try {
                System.out.println(msg);
                input=scan.nextLine();
                correct = true;
            } catch (Exception e) {
                System.out.println("Vous n'avez pas entré une chaine de caractere");
                correct = false;
            }
        } while (!correct);
        return input;
    }

    public static void main(String[] args) {
        boolean[][] occupee = { { false, true, true, true, false, true, true, false, true, false, false },
                { false, true, true, true, false, true, true, false, true, false, false },
                { false, false, true, true, false, false, true, false, true, false, false },
                { true, true, false, true, false, true, true, false, true, true, true },
                { false, true, false, true, false, true, true, false, false, false, true } };
        String[] jourSemaine = { "lundi", "mardi", "mercredi", "jeudi", "vendredi" };
        String[] horaire = { "8H-9H", "9H-10H", "10H-11H", "11H-12H", "12H-13H", "13H-14H", "14H-15H", "15H-16H",
                "16H-17H", "17H-18H", "18H-19H" };
        afficherDisponibilité(occupee, jourSemaine, horaire);
        tauxOccupation(occupee);
        reservation(occupee, jourSemaine, horaire);

    }
}