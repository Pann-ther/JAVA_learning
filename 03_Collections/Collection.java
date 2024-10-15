import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;
import java.util.Set;

public class Collection {

    static Scanner scanner = new Scanner(System.in); // Creation de l'objet scanner

    // Création des listes
    static HashSet<String> listeVilles = new HashSet<>();
    static ArrayList<String> nomsEtudiants = new ArrayList<>(); 
    static HashMap<String, String> annuaire = new HashMap<>();

    

    // Methode pour verifier si un élément a bien été saisi par l'utilisateur
    public static String verificationSaisie() {
        return scanner.nextLine().trim().toUpperCase();
    }
    
    // Methode pour afficher l'element ajouté
    public static void affichageAjout(String sujet, String element){
            System.out.println();
            System.out.println(sujet +" "+element + " à été ajouté");
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

            // Boucle while pour gerer les erreurs de saisie
            while(nom.isEmpty()){
                System.out.println("Aucun nom à été entrer, veuillez entrer le nom de l'etudiant: ");
                nom = verificationSaisie();// Réinitialisation avec l'element ajouté par l'utilisateur
            }

            // Boucle if pour vérifier si l'etudiant n'est pas déja existant dans la liste
            if(nomsEtudiants.contains(nom)){
                System.out.print("L'etudiant existe deja dans la liste");
            }else{
                nomsEtudiants.add(nom);
                affichageAjout("L'etudiant",nom);
            }
            
            // Boucle do-while pour verifier si la reponse est conforme à celle attendu
            do{
                reponse = questionWhile("noms");  
                if (!reponse.equalsIgnoreCase("N") && !reponse.equalsIgnoreCase("O")) {
                    System.out.println();
                    System.out.println("Reponse invalide, entrer O ou N");
                }
            } while(!reponse.equalsIgnoreCase("N") && !reponse.equalsIgnoreCase("O"));
            

        } while(conditionWhile(reponse));

        // Affichage des etudiants saisis dans la liste
        System.out.println("Voici la liste des étudiants:");
        for(String etudiant : nomsEtudiants){
            System.out.println(etudiant);
        }
        System.out.println();
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

            // Boucle if-else pour verifier si l'element ajouté dans la liste existe déja
            if(listeVilles.contains(ville)){
                System.out.println("Cette ville existe deja dans la liste");
            }else{
                listeVilles.add(ville);
                affichageAjout("La ville",ville);
            }

            // Boucle do-while pour verifier si la reponse est conforme à celle attendu
            do{
                reponse = questionWhile("villes");  
                if (!reponse.equalsIgnoreCase("N") && !reponse.equalsIgnoreCase("O")) {
                    System.out.println();
                    System.out.println("Reponse invalide, entrer O ou N");
                }
            } while(!reponse.equalsIgnoreCase("N") && !reponse.equalsIgnoreCase("O"));
            

        }while(conditionWhile(reponse));
        
        // Affichage des villes saisit dans la liste
        System.out.println();
        System.out.println("Voici la liste des villes:");
        for(String ville : listeVilles){
            System.out.println(ville);
        }
        System.out.println();
    }

    // Methode pour crée un annuaire et rechercher le numéro à partir du nom
    public static void hashMap(){
        String reponse;

        // Boucle do-while pour demander a l'utilisateur après chaque saisie s'il souhaite en effectuer d'autres
        do {
            System.out.println("Veuillez entrer le nom du contact: ");
            String nom = verificationSaisie();

            // Boucle while pour gerer les erreurs de saisie
            while (nom.isEmpty()) {
                System.out.println("Aucun élement a été détecté,veuillez entrer le nom du contact: ");
                nom = verificationSaisie();
            }

            System.out.println("Veuillez entrer le numero du contact: ");
            String numero = verificationSaisie();

            // Boucle while pour gerer les erreurs de saisie
            while (numero.isEmpty()) {
                System.out.println("Aucun élement a été détecté,veuillez entrer le numero du contact: ");
                numero = verificationSaisie();
            }

            while(numero.length() != 10){
                System.out.println("Veuillez entrer un numero du valide: ");
                numero = verificationSaisie();
            }

            // Boucle else-if pour vérifier si le contact n'a pas déja été crée avec les infos entrées
            if(annuaire.containsKey(nom)){
                System.out.println("Cette personne existe déja dans l'annuaire");
            } else if(annuaire.containsValue(numero)){
                System.out.println("Ce numéro existe deja dans l'annuaire");
            } else{
                annuaire.put(nom, numero);
            affichageAjout("Le contact",nom);
            }

            // Boucle do-while pour verifier si la reponse est conforme à celle attendu
            do{
                reponse = questionWhile("contacts");
                if (!reponse.equalsIgnoreCase("O") && !reponse.equalsIgnoreCase("N")) {
                    System.out.println();
                    System.out.println("Reponse invalide, entrer O ou N");
                }
            } while (!reponse.equalsIgnoreCase("O") && !reponse.equalsIgnoreCase("N"));

        }while (conditionWhile(reponse));

        // Affichage de l'annuaire
        System.out.println();
        System.out.println("Voici l'annuaire");
        System.out.println();
        for(Map.Entry <String, String> entry : annuaire.entrySet()){
            System.out.println("Nom: "+ entry.getKey() + ", Numéro: "+ entry.getValue());
            System.out.println();
        }
        
        System.out.println();
    }
   

    public static void main(String[] args) {
        //arrayList();
        //hashSet();
        hashMap();
        scanner.close();
    }

}
