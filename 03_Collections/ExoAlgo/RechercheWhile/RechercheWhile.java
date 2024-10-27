import java.util.Scanner;

public class RechercheWhile {
    public static void main(String[] args) {
        // Creation du scanner
        Scanner scanner = new Scanner(System.in);
        // Creation et initialisation du tableau
        int[] tab = { 10, 20, 30, 40, 50 };
        // stock la valeur vrai ou faux qui se traduit par si element a été trouvé dans
        // le tableau
        boolean appartient = false;
        // Stock la valeur de l'element recherché
        int element;
        // Demande a l'utilisateur d'initialiser l'element
        System.out.print("Entrez un nombre entier: ");
        element = scanner.nextInt();

        // boucle while pour changer la condition si l'element est trouvé dans le tableau
        int i = 0;
        while (i < tab.length && !appartient) {
            if (tab[i] == element) {
                appartient = true;
            }
            i++;
        }

        // retourne le resultat de la recherche a l'utilisateur
        if (appartient) {
            System.out.println(element + " appartient au tableau");
        } else {
            System.out.println(element + " n'a pas été trouvé dans le tableau");
        }
        // fermeture du scanner
        scanner.close();
    }
}