import java.util.Scanner;
import java.util.Date;

public class FormatCSV{

    static Scanner scanner = new Scanner(System.in); // Création du scanner pour les entrées au clavier
    static String ligneCSV; // Stocke l'entrée utilisateur
    static String[] tab; // Stocke les données de la ligne CSV
    static String[] decompositionDate = new String[3]; // Stocke les données pour composer l'objet Date
    static int jour, mois, année; // Décompose la date 
    static String nom, prenom, date; // Stocke chaque donnée de la ligne CSV
    
    // Vérifie si les données sont valides
    static boolean prenomValide = false;
    static boolean nomValide = false;
    static boolean dateValide = false;

    // Stocke la ligne CSV entrée par l'utilisateur
    public static void saisieUtilisateur(){
        System.out.print("Entrez la ligne CSV: ");
        try {
            if(scanner.hasNextLine())
                ligneCSV = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erreur de format");
        }
    }

    // Découpe la chaîne de caractères pour en extraire les données
    public static void extraireDonnées(){
        try {
            tab = ligneCSV.split(";");
            if(tab.length < 3){
                System.out.println("Erreur de format");
                return;
            }
            for(int i = 0; i < tab.length; i++){
                tab[i] = tab[i].replace('"',' ').trim();
            }
            prenom = tab[0];
            nom = tab[1];
            date = tab[2];
        } catch (Exception e) {
            System.out.println("Erreur de format");
        }
    }

    // Vérification des entrées qui contiennent des lettres
    public static boolean verifierDonnéeLettre(String donnée){
        try {
            char d = donnée.charAt(0);
            return Character.isLetter(d);
        } catch (Exception e) {
            System.out.println("Erreur de format");
            return false;
        }
    }

    // Vérification des entrées qui contiennent des chiffres
    public static boolean verifierDonnéeChiffre(String donnée){
        try {
            char d = donnée.charAt(0);
            return Character.isDigit(d);
        } catch (Exception e) {
            System.out.println("Erreur de format");
            return false;
        }
    }

    // Décompose la date pour pouvoir créer un objet Date 
    public static void date(){
        try {
            decompositionDate = tab[2].split("/");
            if (decompositionDate.length < 3) {
                System.out.println("Erreur de format");
                return;
            }
            jour = Integer.parseInt(decompositionDate[0]);
            mois = Integer.parseInt(decompositionDate[1]) - 1;
            année = Integer.parseInt(decompositionDate[2]) - 1900;
        } catch (NumberFormatException e) {
            System.out.println("Erreur de format");
        } catch (Exception e) {
            System.out.println("Erreur de format");
        }
    }

    // Vérifie si la ligne CSV est valide
    public static void verifierLigneCSV(Date date){
        try {
            if(prenomValide && nomValide && dateValide){
                System.out.println(prenom);
                System.out.println(nom);
                System.out.println(date);
            } else {
                System.out.println("Erreur de format");
            }
        } catch (Exception e) {
            System.out.println("Erreur de format");
        }
    }

    public static void main(String[] args){
        try {
            saisieUtilisateur();
            extraireDonnées();
            prenomValide = verifierDonnéeLettre(prenom); // Permet de stocker le retour de la méthode 
            nomValide = verifierDonnéeLettre(nom); // Permet de stocker le retour de la méthode 
            dateValide = verifierDonnéeChiffre(date); // Permet de stocker le retour de la méthode 
            
            date(); // Prépare les variables pour créer l'objet Date
            Date naissance = new Date(année, mois, jour); // Crée l'objet naissance
            
            verifierLigneCSV(naissance); // le paramètre naissance permet d'afficher la date après que l'objet soit créé
            
        } catch (Exception e) {
            System.out.println("Erreur de format");
        } finally {
            scanner.close(); // ferme le scanner
        }
    }
}
