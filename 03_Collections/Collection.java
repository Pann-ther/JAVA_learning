import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class Collection {

    static Scanner scanner = new Scanner(System.in); // Creation de l'objet scanner

    // Création des listes
    static HashSet<String> listeVilles = new HashSet<>();
    static ArrayList<String> nomsEtudiants = new ArrayList<>(); 
    static HashMap<String, String> annuaire = new HashMap<>();

    

    // Methode pour verifier si un élément a bien été saisi par l'utilisateur
    public static String verificationSaisie() {
        return scanner.nextLine().trim();
    }
    
    // Methode pour afficher l'element ajouté
    public static void affichageAjout(String element){
            System.out.println();
            System.out.println("La ville " + element + " à été ajouté");
    }

    // Methode pour savoir si l'utilisateur a d'autres elements à entrer
    public static String questionWhile(String element){
        System.out.println();
        System.out.println("Voulez vous entrer d'autres "+ element +" dans la liste? O/N");
        return scanner.nextLine();// Initialisation avec la reponse utilisateur
    }

    // Methode pour condition de la boucle while
        public static boolean conditionWhile(String reponse){
            return !reponse.equalsIgnoreCase("N");
        }



   
    // Methode pour crée une liste d'etudiant
    public static void arrayList(){
        
        String reponse; // Déclaration variable "response" de l'utilisateur

        // Boucle do-while pour demander a l'utilisateur après chaque saisie s'il souhaite en effectuer d'autres
        do{
            System.out.println("Veuillez entrer le nom de l'etudiant: ");
            String nom = verificationSaisie();// Declaration et initialisation avec l'element ajouté par l'utilisateur

            // boucle while pour gerer les erreurs de saisie
            while(nom.isEmpty()){
                System.out.println("Aucun nom à été entrer, veuillez entrer le nom de l'etudiant: ");
                nom = verificationSaisie();// Réinitialisation avec l'element ajouté par l'utilisateur
            }

            nomsEtudiants.add(nom);
            affichageAjout(nom);
            reponse = questionWhile("noms");

        } while(conditionWhile(reponse));

        // Affichage des etudiants saisis dans la liste
        System.out.println("Voici la liste des étudiants:");
        for(String etudiant : nomsEtudiants){
            System.out.println(etudiant);
        }
    }

    
    // Methode pour faire une liste de ville et verifie si une ville est deja dans la liste
    public static void hashSet(){

        String reponse;

        // Boucle do-while pour demander a l'utilisateur après chaque saisie s'il souhaite en effectuer d'autres
        do{
            System.out.println("Veuillez entrer une ville: ");
            String ville = verificationSaisie();

            // boucle while pour gerer les erreurs de saisie
            while (ville.isEmpty()) {
                System.out.println("Aucune ville n'a été entrer, veuillez entrer une ville: ");
                ville = verificationSaisie();
            }

            if(listeVilles.contains(ville)){
                System.out.println("Cette ville existe deja dans la liste");
            }else{
                listeVilles.add(ville);
                affichageAjout(ville);
                
            }

            reponse = questionWhile("villes");

        }while(conditionWhile(reponse));
        
        // Affichage des villes saisit dans la liste
        System.out.println();
        System.out.println("Voici la liste des villes:");
        for(String ville : listeVilles){
            System.out.println(ville);
        }
    }

    // Methode pour crée un annuaire et rechercher le numéro à partir du nom
    public static void hashMap(){
        String reponse;

        do {
            System.out.println("Veuillez entrer le nom du contact");
            String nom = verificationSaisie()

            while (nom.isEmpty()) {
                System.out.println("Aucun élement a été détecté,veuillez entrer le nom du contact");
                nom = verificationSaisie()
            }

            annuaire.put

            System.out.println("Veuillez entrer le numero du contact");
            String numero = verificationSaisie()

            while (numero.isEmpty()) {
                System.out.println("Aucun élement a été détecté,veuillez entrer le numero du contact");
                numero = verificationSaisie()
            }
        }
    }
   

    public static void main(String[] args) {
        //arrayList();
        hashSet();
        scanner.close();
    }

}
