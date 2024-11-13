import java.util.HashSet;
import java.util.Scanner;

public class ListeCourse {

    static Scanner scanner = new Scanner(System.in); // Creation d'un scanner
    static String element; // Declaration variable
    static HashSet<String> liste = new HashSet<>(); // Creation d'une liste a partir de la collection HashSet

  

    // Methode pour demander a l'utilisateur dans quel mode veut-il se mettre
    static public String demanderModeUtilisation() {
        String input; // Déclaration variable qui va stocker la saisie utilisateur

        // Boucle do-while pour continuer de poser la question tant qu'une reponse valide n'est pas saisi
        do{
            System.out.println("Voulez vous ajouter ou supprimer un element, afficher la liste ou vous avez terminer votre liste? aj/su/af/fin");
            input = scanner.nextLine();
        }while (!input.equalsIgnoreCase("aj") && !input.equalsIgnoreCase("su") && !input.equalsIgnoreCase("af") && !input.equalsIgnoreCase("fin"));

        return input;
    }

    //Methode pour que l'utilisateur accede au mode qu'il a choisi
    static public void modeUtilisation(String mode){ // Utilise le return de la methode demanderModeUtilisation dans la methode main

        switch (mode) {
            case "aj":
                ajouterElementListe();
                break;
            case "su":
                supprimerElementListe();
                break;
            case "af":
                afficherListe();
                break;
            case "fin":
                System.out.println("Fin du programme");
                break;
        
            default:
                break;
        }

    }

    // Methode pour demander si l'utilisateur veut continuer a utiliser le mode
    static public String demanderContinuer(String message){
        String input; // Déclaration variable qui va stocker la saisie utilisateur

        System.out.println(message);
        input = scanner.nextLine();
        System.out.println();

        return input;
    
    }

    // Methode pour verifier si l'utilisateur entre un element vide
    static public String verifierSaisieElement(String message){
        String input; // Déclaration variable qui va stocker la saisie utilisateur

        do{
            System.out.println(message);
            input = scanner.nextLine();
            System.out.println();
        }while(input.trim().isEmpty());
        return input;
    }

    // Methode pour ajouter un element a la liste
    static public void ajouterElementListe(){
        String input; // Déclaration variable qui va stocker la saisie utilisateur

        // Boucle do-while pour rester dans le mode tant que l'utilisateur a d'autres elements a ajouter
        do{
            element = verifierSaisieElement("Veuillez un element que vous voulez ajouter");
            liste.add(element.toLowerCase());
            
            if(liste.contains(element)){
                System.out.println("Cette element a deja ete ajoute a la liste");
                System.out.println();
            } else {
                System.out.println(element + " a ete ajoute a la liste");
                System.out.println();
            }
            input = demanderContinuer("Voulez vous ajouter un autre element a la liste? O/N");
        }while(!input.equalsIgnoreCase("N"));

        input = demanderModeUtilisation();
        modeUtilisation(input);
        
    }

    // Methode pour supprimer un element a la liste
    static public void supprimerElementListe() {
        String input; // Déclaration variable qui va stocker la saisie utilisateur

        // Boucle do-while pour rester dans le mode tant que l'utilisateur a d'autres elements a supprimer
        do {
            element = verifierSaisieElement("Quel element voulez vous supprimer");
            System.out.println();
            if (liste.contains(element.toLowerCase())) {
                liste.remove(element);
                System.out.println(element + " a ete supprime de la liste");
                System.out.println();
            } else{
                System.out.println("L'element n'existe pas");
                System.out.println();
            }
            input = demanderContinuer("Voulez vous supprimer un autre element de la liste? O/N");
        } while (!input.equalsIgnoreCase("N"));
        
        input = demanderModeUtilisation();
        modeUtilisation(input);
    }

    // Methode pour afficher la liste
    static public void afficherListe() {
        String input; // Déclaration variable qui va stocker la saisie utilisateur

        System.out.println("Voici votre liste de course");
        System.out.println();
        for(String course : liste){
            System.out.println(course);
        }
        System.out.println();

        input = demanderModeUtilisation();
        modeUtilisation(input);
    }


    // Methode pour demarrer les programmes
    public static void main(String[] args) {
        String input; // Déclaration variable qui va stocker la saisie utilisateur

        // Choix du mode utilisateur initialiser dans input
        input = demanderModeUtilisation();
        // Choix utilisateur mis en paramettre de la methode 
        modeUtilisation(input);

        scanner.close();

    }
}
