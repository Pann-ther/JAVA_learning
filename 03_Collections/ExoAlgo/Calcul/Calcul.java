import java.util.Scanner;
public class Calcul{
	static Scanner scanner = new Scanner(System.in);

	// Methode pour stocker les 3 entiers saisis au clavier
	public static void saisieEntier(int[] tab){
		for(int i = 0; i < tab.length; i++){
			do{
				System.out.print("Entrez un entier: ");
				if(scanner.hasNextInt()){
					tab[i]= scanner.nextInt();
					break;
				}else{
					System.out.println("Vous avez entré autre chose qu'un entier, veuillez entrer un entier");
					scanner.next();
				}
			} while (true);
		}
	}

	// Methode pour calculer le nombre le plus grand des 3 entiers
	public static void calculerPlusGrand(int[] tab){
        int plusGrand = tab[0];
		for(int i=1; i<tab.length; i++){
			if(tab[i]>plusGrand){
				plusGrand = tab[i];
			}
		}
		System.out.println("L'entier le plus grand: "+ plusGrand);
	}

	// Methode pour calculer la moyenne des 3 nombres
	public static void calculerMoyenne(int[] tab){
        double moyenne = 0;
		for(int i=0; i<tab.length; i++){
			moyenne += tab[i];
		}
		moyenne = moyenne / tab.length;
		System.out.println("La moyenne des 3 entiers: "+ String.format("%.2f", moyenne));
	}	

	public static void main(String[]args){
	    int[] tab = new int[3];
		saisieEntier(tab);
		calculerPlusGrand(tab);
		calculerMoyenne(tab);
        scanner.close();
	}
}