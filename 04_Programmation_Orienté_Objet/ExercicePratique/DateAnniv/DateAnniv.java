import java.time.LocalDate;
import java.util.Scanner;

public class DateAnniv {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//
		// String noms = "Kylian; Kaleel; Ursula; Félix";
		// String [] tab = sansaccent.split(";");
		// String sansaccent = noms.toLowerCase().replace('é','e');
		// for(int i = 0; i<tab.length; i++){
		// tab[i] = tab[i].trim();
		// System.out.println(tab[i]);
		// }

		// String dernier = tab[0];
		// for(int i= 1; i<tab.length; i++){
		// if (dernier.compareTo(tab[i]) < 0) {
		// dernier = tab[i];
		// }
		// }
		// System.out.println(dernier);
		int input;
		do {
			System.out.println("Entrez un entier: ");
			if (scanner.hasNextInt()) {
				input = scanner.nextInt();
				break;
			} else {
				System.out.println("Vous avez entrer autre chose qu'un entier");
				scanner.next();
			}
		} while (true);

		scanner.close();

	}
}