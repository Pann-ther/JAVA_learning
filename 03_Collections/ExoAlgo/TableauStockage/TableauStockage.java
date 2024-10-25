import java.util.Scanner;

public class TableauStockage{

	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);

		// demande combien d'entier l'utilisateur veut saisir pour dimensionner le tableau
		int nbEntier;
		System.out.print("Combien d'entiers souhaitez vous saisir? ");
		nbEntier = scanner.nextInt();
		int [] tab = new int[nbEntier];
        int sommeEntier = 0;
		// Boucle for pour stocker les entiers saisis par l'utilisateur dans le tableau
		for(int i=0 ; i<tab.length; i++){
			int input;
			System.out.print("Entrez un entier: ");
			input = scanner.nextInt();
			tab[i]= input;
            sommeEntier += tab[i];
		}

        // Calcul de la moyenne des entiers du tableau
		double moyenne = (double)sommeEntier / nbEntier;

		System.out.println("\nVoici le contenu du tableau");		
		for(int i=0; i<tab.length; i++){
			System.out.print(tab[i]+" ");
		}
        // Affichage de la moyenne des entiers du tableau
        System.out.println("\n La moyenne des entiers du tableau est "+ moyenne);
		scanner.close();
	}
}