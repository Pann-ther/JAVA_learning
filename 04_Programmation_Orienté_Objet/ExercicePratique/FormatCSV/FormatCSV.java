import java.util.Scanner;
import java.util.Date;

public class FormatCSV {

    static Scanner scanner = new Scanner(System.in);
    static String ligneCSV;
    static String[] tab;
    static String nom, prenom, date;
    static boolean prenomValide = false;
    static boolean nomValide = false;
    static boolean dateValide = false;

    // Stock la ligne CSV entrée par l'utilisateur
    public static void saisieUtilisateur() {
        System.out.print("Entrer la ligne CSV: ");
        ligneCSV = scanner.nextLine();
    }

    // Decoupe la chaine de caractères pour en extraire les donnees
    public static void extraireDonnées() {
        tab = ligneCSV.split(";");
        for (int i = 0; i < tab.length; i++) {
            tab[i] = tab[i].replace('"', ' ').trim();
        }
        prenom = tab[0];
        nom = tab[1];
        date = tab[2];
    }

    // Verification des entrées qui contiennent des lettres
    public static boolean verifierDonnéeLettre(String donnée) {
        char d = donnée.charAt(0);
        if (!Character.isLetter(d)) {
            return false;

        }
        return true;
    }

    // Verification des entrées qui contiennent des chiffres
    public static boolean verifierDonnéeChiffre(String donnée) {
        char d = donnée.charAt(0);
        if (!Character.isDigit(d)) {
            return false;

        }
        return true;
    }

    

    public static void main(String[] args) {
        try {
            saisieUtilisateur();
            extraireDonnées();
            String[] dateStrings = date.split("/");
            int jour = Integer.parseInt(dateStrings[0]);
            int mois = Integer.parseInt(dateStrings[1])-1;
            int annee = Integer.parseInt(dateStrings[2])-1900;
            Date date = new Date(annee, mois, jour);
            String dateCEST = date.toString();
            String dateCET= dateCEST.replace("CEST", "CET");
            System.out.println(prenom);
            System.out.println(nom);
            System.out.println(dateCET.toString());
        } catch (Exception e) {
            System.out.println("Erreur de format");
        }

        scanner.close();
    }
}