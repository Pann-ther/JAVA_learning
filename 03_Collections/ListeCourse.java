import java.util.ArrayList;
import java.util.Scanner;

public class ListeCourse {

    static Scanner scanner = new Scanner(System.in); // Creation de l'objet scanner
    static ArrayList<String> liste = new ArrayList<>(); // Creation de la liste

    // Methode pour ajouter des elements a la liste
    public static void ajoutListe() {
        String reponse; // Déclaration variable reponse 

        //Boucle do-while pour ajouter le premiere element de la liste et demande à l'utilisateur si veux entrer d'autres éléments
        do {
            System.out.println("Entrer un element dans votre liste de course : ");
            String nouveauElement = scanner.nextLine().trim(); // Declaration et initialisation avec l'element ajouté par l'utilisateur

            // Boucle while pour verifier si aucun élement a été entré
            while (nouveauElement.isEmpty()) {
            System.out.println("L'element ne peut pas être vide, veuillez entrer un élément valide : ");
            nouveauElement = scanner.nextLine().trim(); // Réinitialisation avec l'element ajouté par l'utilisateur
            }

            liste.add(nouveauElement);
            System.out.println("Element ajouté : " + nouveauElement);
            System.out.println("Voulez vous ajoutez un autre element a votre liste ? : O/N");
            reponse = scanner.nextLine(); // Initialisation avec la reponse utilisateur
        } while (!reponse.equalsIgnoreCase("N")); // Boucle recommence si l'utilisteur repond O
            
        
        System.out.println("Voici votre liste : ");
            for(String element : liste){
                System.out.println(element);
            }

        
    }

    // Appel de la methode
    public static void main(String[] args) {
        ajoutListe();
        scanner.close();
    }
}
