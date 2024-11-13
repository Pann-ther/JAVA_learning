import java.util.Scanner;

public class TableauCaractere{
	public static void main(String[]args){
		Scanner scanner = new Scanner(System.in);

		char [] tab = new char[10];

		int nbLettre = 0;
		int nbMaj = 0;

		for(int i=0; i<tab.length; i++){
			char input;
			System.out.print("Entrez un caractere: ");
			input = scanner.next().charAt(0);
			tab[i] = input;

			if(Character.isLetter(tab[i])){
				nbLettre += 1;
			}
			if (Character.isUpperCase(tab[i])){
				nbMaj += 1;
			}
		}

		System.out.println("Dans ce tableau il y a "+nbLettre+" lettres");
		System.out.println("Dans ce tableau il y a "+nbMaj+" majuscules");
		scanner.close();
	}
}
