import java.util.Scanner;

public class TableauInsert {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Creation et initialisation du tableau de nombre entier
        int[] tab = { 12, 15, 13, 10, 8, 8, 13, 14 };

        int tailleTableau = tab.length -1;
        
        // Recupere l'entier saisit et l'indice
        int inputEntier;
        int inputIndice;
        System.out.print("Entrez un entier: ");
        inputEntier = scanner.nextInt();
        do{ // Boucle pour verifier si l'indice est dans le tableau
            System.out.print("Entrez un indice: ");
            inputIndice = scanner.nextInt();
        }while (inputIndice < 0 || inputIndice > tailleTableau);


        // Affichage du tableau avant modification
        System.out.println("Affiche le tableau avant modification");
        for(int i=0; i < tab.length; i++){
            System.out.print(tab[i]+" ");
        }
        System.out.println();

        // Ajoute l'entier a l'indice indiqué
        tab[inputIndice] = inputEntier;

        // Affiche le tableau apres modification
        System.out.println("Affiche le tableau apres modification");
        for(int i=0; i < tab.length; i++){
            System.out.print(tab[i]+" ");
        }
        
    }
}
