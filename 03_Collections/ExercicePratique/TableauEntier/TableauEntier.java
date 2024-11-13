import java.util.Scanner;

public class TableauEntier {
    public static void main(String[] args) {

        // Creation du scanner
        Scanner scanner = new Scanner(System.in);

        // Creation et initialisation du tableau de nombre entier
        int[] tab = { 12, 15, 13, 10, 8, 8, 13, 14 };

        // recuperation du nombre utilisateur et stockage avec une boucle do-while pour s'assurer d'avoir un entier entre 5 et 15
        int input;
        do {
            System.out.print("Entrez un entier entre 5 et 15: ");
            input = scanner.nextInt();
        } while (input > 15 || input < 5);

        System.out.println();

        // Verification de la presence de input dans le tableau
        System.out.println(input + " fait t'il parti du tableau?");
        boolean presence = false;
        int indice = -1;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == input) {
                presence = true;
                indice = i;
                break;
            }
        }

        // Reponse a l'utilisateur
        if (presence) {
            System.out.println("Oui a l'indice "+ indice);
        }else{
            System.out.println("Non");
        }

        // Fermeture du scanner
        scanner.close();
    }
}
